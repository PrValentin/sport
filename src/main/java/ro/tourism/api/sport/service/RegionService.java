package ro.tourism.api.sport.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tourism.api.sport.entity.Country;
import ro.tourism.api.sport.entity.Locality;
import ro.tourism.api.sport.entity.Region;
import ro.tourism.api.sport.model.RegionModel;
import ro.tourism.api.sport.repository.CountryRepository;
import ro.tourism.api.sport.repository.LocalityRepository;
import ro.tourism.api.sport.repository.LocalitySportRepository;
import ro.tourism.api.sport.repository.RegionRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class RegionService {
    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;
    private final LocalityRepository localityRepository;
    private final LocalitySportRepository localitySportRepository;

    public RegionService(RegionRepository regionRepository, CountryRepository countryRepository, LocalityRepository localityRepository, LocalitySportRepository localitySportRepository) {
        this.regionRepository = Objects.requireNonNull(regionRepository, "regionRepository must not be null");
        this.countryRepository = Objects.requireNonNull(countryRepository, "countryRepository must not be null");
        this.localityRepository = Objects.requireNonNull(localityRepository, "localityRepository must not be null");
        this.localitySportRepository = Objects.requireNonNull(localitySportRepository, "localitySportRepository must not be null");
    }
    public List<Region> getAllRegions(){
        return regionRepository.findByOrderById();
    }

    public ResponseEntity<String> addRegion(RegionModel newRegion) {
        Region region = new Region();
        final Optional<Country> optionalCountry = countryRepository.findById(newRegion.getIdCountry());
        final Optional<Region> optionalRegion = regionRepository.findByName(newRegion.getName());
        if (optionalRegion.isPresent()) {
            return new ResponseEntity<>("This name already exist in database", HttpStatus.BAD_REQUEST);
        }

        if (optionalCountry.isEmpty()) {
            return new ResponseEntity<>("Id country was not found in database", HttpStatus.BAD_REQUEST);
        }
        region.setCountry(countryRepository.getOne(newRegion.getIdCountry()));
        region.setName(newRegion.getName());
        regionRepository.save(region);
        return new ResponseEntity<>("OK save newRegion", HttpStatus.OK);
    }

    public ResponseEntity<String> updateRegion(RegionModel regionModel) {
        Region region = regionRepository.getOne(regionModel.getId());
        final Optional<Country> optionalCountry = countryRepository.findById(regionModel.getIdCountry());
        if (optionalCountry.isEmpty()) {
            return new ResponseEntity<>("Id country was not found in database", HttpStatus.BAD_REQUEST);
        }
        region.setCountry(optionalCountry.get());
        region.setName(regionModel.getName());
        regionRepository.save(region);

        return new ResponseEntity<>("OK update Region", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteRegion(Long id) {
        final Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isEmpty()) {
            return new ResponseEntity<>("Id region was not found", HttpStatus.BAD_REQUEST);
        }

        List<Locality> localities = localityRepository.findByRegionId(id);

        List<Long> localityIds = new ArrayList<>();
        for (Locality locality : localities) {
            localityIds.add(locality.getId());
        }

        localitySportRepository.deleteByLocalityIdIn(localityIds);

        for(Locality locality : localities) {
            localityRepository.delete(locality);
        }
        regionRepository.delete(optionalRegion.get());

        return new ResponseEntity<>("Delete Ok", HttpStatus.OK);
    }


}
