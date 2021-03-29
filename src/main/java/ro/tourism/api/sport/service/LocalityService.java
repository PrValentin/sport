package ro.tourism.api.sport.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tourism.api.sport.entity.Locality;
import ro.tourism.api.sport.entity.Region;
import ro.tourism.api.sport.model.LocalityModel;
import ro.tourism.api.sport.repository.LocalityRepository;
import ro.tourism.api.sport.repository.LocalitySportRepository;
import ro.tourism.api.sport.repository.RegionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class LocalityService {
    LocalityRepository localityRepository;
    RegionRepository regionRepository;
    LocalitySportRepository localitySportRepository;

    public LocalityService(LocalityRepository localityRepository, RegionRepository regionRepository, LocalitySportRepository localitySportRepository) {
        this.localityRepository = Objects.requireNonNull(localityRepository, "localityRepository must not be null");
        this.regionRepository = Objects.requireNonNull(regionRepository, "regionRepository must not be null");
        this.localitySportRepository = Objects.requireNonNull(localitySportRepository, "localitySportRepository must not be null");
    }

    public List<Locality> getAllLocality() {
        return localityRepository.findByOrderById();
    }

    public ResponseEntity<String> addLocality(LocalityModel localityModel) {
        Locality locality = new Locality();
        Optional<Locality> optionalLocality = localityRepository.findByName(localityModel.getName());
        if (optionalLocality.isPresent()){
            return new ResponseEntity<>("This name already exist in database", HttpStatus.BAD_REQUEST);
        }
        Optional<Region> optionalRegion = regionRepository.findById(localityModel.getIdRegion());
        if (optionalRegion.isEmpty()){
            return new ResponseEntity<>("Id region was not found in database", HttpStatus.BAD_REQUEST);
        }
        locality.setRegion(optionalRegion.get());
        locality.setName(localityModel.getName());
        localityRepository.save(locality);
        return new ResponseEntity<>("Add locality ok",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteLocality(Long id) {
        Optional<Locality> optionalLocality = localityRepository.findById(id);
        if (optionalLocality.isEmpty()) {
            return new ResponseEntity<>("Id locality was not found in database", HttpStatus.BAD_REQUEST);
        }
        localitySportRepository.deleteByLocalityId(id);
        localityRepository.delete(optionalLocality.get());
        return new ResponseEntity<>("Delete locality ok", HttpStatus.OK);
    }
}
