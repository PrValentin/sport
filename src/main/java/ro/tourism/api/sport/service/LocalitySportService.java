package ro.tourism.api.sport.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tourism.api.sport.entity.Locality;
import ro.tourism.api.sport.entity.LocalitySport;
import ro.tourism.api.sport.entity.Sport;
import ro.tourism.api.sport.model.LocalitySportModel;
import ro.tourism.api.sport.repository.LocalityRepository;
import ro.tourism.api.sport.repository.LocalitySportRepository;
import ro.tourism.api.sport.repository.SportRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class LocalitySportService {
    LocalitySportRepository localitySportRepository;
    SportRepository sportRepository;
    LocalityRepository localityRepository;

    public LocalitySportService(LocalitySportRepository localitySportRepository, SportRepository sportRepository, LocalityRepository localityRepository) {
        this.localitySportRepository = Objects.requireNonNull(localitySportRepository, "regionRepository must not be null");
        this.sportRepository = Objects.requireNonNull(sportRepository, "sportRepository must not be null");
        this.localityRepository = Objects.requireNonNull(localityRepository, "localityRepository must not be null");
    }

    public List<LocalitySport> getAllLocalitiesSport() {
        return localitySportRepository.findByOrderById();
    }

    public ResponseEntity<String> addLocalitySport(LocalitySportModel newLocalitySportModel) {

        LocalDate startSeason = newLocalitySportModel.getStartSeason();
        LocalDate endSeason = newLocalitySportModel.getEndSeason();
        if (startSeason.isAfter(endSeason)) {
            return new ResponseEntity<>("The end date is before start date", HttpStatus.BAD_REQUEST);
        }

        Optional<Sport> optionalSport = sportRepository.findById(newLocalitySportModel.getIdSport());
        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>("Id sport was not found in database", HttpStatus.BAD_REQUEST);
        }

        Optional<Locality> optionalLocality = localityRepository.findById(newLocalitySportModel.getIdLocality());
        if (optionalLocality.isEmpty()) {
            return new ResponseEntity<>("Id locality was not found in database", HttpStatus.BAD_REQUEST);
        }

        LocalitySport  newLocalitySport= new LocalitySport();

        newLocalitySport.setSport(optionalSport.get());
        newLocalitySport.setLocality(optionalLocality.get());
        newLocalitySport.setStartSeason(newLocalitySportModel.getStartSeason());
        newLocalitySport.setEndSeason(newLocalitySportModel.getEndSeason());
        newLocalitySport.setCostDay(newLocalitySportModel.getCostDay());
        localitySportRepository.save(newLocalitySport);

        return new ResponseEntity<>("Add LocalitySport ok", HttpStatus.OK);

    }

    public ResponseEntity<String> updateLocalitySport(LocalitySportModel localitySportModel) {

        Optional<LocalitySport> optionalLocalitySport = localitySportRepository.findById(localitySportModel.getId());
        if (optionalLocalitySport.isEmpty()) {
            return new ResponseEntity<>("Id LocalitySport was not found in database", HttpStatus.BAD_REQUEST);
        }

        LocalDate startSeason = localitySportModel.getStartSeason();
        LocalDate endSeason = localitySportModel.getEndSeason();
        if (startSeason.isAfter(endSeason)) {
            return new ResponseEntity<>("The end date is before start date", HttpStatus.BAD_REQUEST);
        }

        Optional<Sport> optionalSport = sportRepository.findById(localitySportModel.getIdSport());
        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>("Id sport was not found in database", HttpStatus.BAD_REQUEST);
        }

        Optional<Locality> optionalLocality = localityRepository.findById(localitySportModel.getIdLocality());
        if (optionalLocality.isEmpty()) {
            return new ResponseEntity<>("Id locality was not found in database", HttpStatus.BAD_REQUEST);
        }

        optionalLocalitySport.get().setSport(optionalSport.get());
        optionalLocalitySport.get().setLocality(optionalLocality.get());
        optionalLocalitySport.get().setStartSeason(startSeason);
        optionalLocalitySport.get().setEndSeason(endSeason);
        optionalLocalitySport.get().setCostDay(localitySportModel.getCostDay());

        localitySportRepository.save(optionalLocalitySport.get());

        return new ResponseEntity<>("Update LocalitySport ok", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteLocalitiesSport(Long id) {
        Optional<LocalitySport> optionalLocalitySport = localitySportRepository.findById(id);
        if (optionalLocalitySport.isEmpty()) {
            return new ResponseEntity<>("Id LocalitySport was not found in database", HttpStatus.BAD_REQUEST);
        }
        localitySportRepository.delete(optionalLocalitySport.get());

        return new ResponseEntity<>("Delete LocalitySport ok", HttpStatus.OK);
    }
}
