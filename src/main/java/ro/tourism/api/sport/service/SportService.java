package ro.tourism.api.sport.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tourism.api.sport.entity.Sport;
import ro.tourism.api.sport.model.SportModel;
import ro.tourism.api.sport.repository.LocalitySportRepository;
import ro.tourism.api.sport.repository.SportRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SportService {

    SportRepository sportRepository;
    LocalitySportRepository localitySportRepository;


    public SportService(SportRepository sportRepository, LocalitySportRepository localitySportRepository) {
        this.sportRepository = Objects.requireNonNull(sportRepository, "sportRepository must not be null");
        this.localitySportRepository = Objects.requireNonNull(localitySportRepository, "localitySportRepository must not be null");
    }

    public List<Sport> getAllSports() {
        return sportRepository.findByOrderById();
    }

    public ResponseEntity<String> addSport(SportModel newSportModel) {
        final Optional<Sport> optionalSport = sportRepository.findByNameIgnoreCase(newSportModel.getName().toUpperCase());
        if(optionalSport.isPresent()) {
            return new ResponseEntity<>("This name already exist in database", HttpStatus.BAD_REQUEST);
        }
        Sport newSport = new Sport();
        newSport.setName(newSportModel.getName());
        sportRepository.save(newSport);

        return new ResponseEntity<>("Add newSport ok", HttpStatus.OK);
    }

    public ResponseEntity<String> updateSport(SportModel sportModel) {
        Optional<Sport> optionalSport = sportRepository.findById(sportModel.getId());
        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>("Id sport was not found in database", HttpStatus.BAD_REQUEST);
        }

        Optional<Sport> optionalSport1 = sportRepository.findByNameIgnoreCase(sportModel.getName());
        if (optionalSport1.isPresent() && optionalSport1.get().getId() != sportModel.getId()) {
            return new ResponseEntity<>("This name already exist in database", HttpStatus.BAD_REQUEST);
        }
        optionalSport.get().setName(sportModel.getName());
        sportRepository.save(optionalSport.get());

        return new ResponseEntity<>("Update sport ok", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteSport(Long id) {
        Optional<Sport> optionalSport = sportRepository.findById(id);
        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>("Id sport was not found in database", HttpStatus.BAD_REQUEST);
        }
        localitySportRepository.deleteBySportId(id);
        sportRepository.delete(optionalSport.get());

        return new ResponseEntity<>("Delete sport ok", HttpStatus.OK);
    }
}
