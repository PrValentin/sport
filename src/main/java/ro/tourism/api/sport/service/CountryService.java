package ro.tourism.api.sport.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tourism.api.sport.entity.Country;
import ro.tourism.api.sport.entity.Locality;
import ro.tourism.api.sport.entity.Region;
import ro.tourism.api.sport.model.CountryModel;
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
public class CountryService {
    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;
    private final LocalityRepository localityRepository;
    private final LocalitySportRepository localitySportRepository;

    public CountryService(CountryRepository countryRepository, RegionRepository regionRepository, LocalityRepository localityRepository, LocalitySportRepository localitySportRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "countryRepository must not be null");
        this.regionRepository = Objects.requireNonNull(regionRepository, "regionRepository must not be null");
        this.localityRepository = Objects.requireNonNull(localityRepository, "localityRepository must not be null");
        this.localitySportRepository = Objects.requireNonNull(localitySportRepository, "localitySportRepository must not be null");
    }

    public List<Country> getAllCountries() {
        return countryRepository.findByOrderById();
    }

    public ResponseEntity<String> addCountry(CountryModel countryAdd) {
        Optional<Country> optionalCountry = countryRepository.findByName(countryAdd.getName());
        if (optionalCountry.isPresent()) {
            return new ResponseEntity<>("This name already exist in database", HttpStatus.BAD_REQUEST);
        }
        Country country = new Country();
        country.setName(countryAdd.getName());
        countryRepository.save(country);
        return new ResponseEntity<>("Add newCountry ok", HttpStatus.OK);
    }

    public Country getCountry(final Long countryId) {
        return countryRepository.getOne(countryId);
    }

    public CountryModel updateCountry(CountryModel countryModel) {
        Country country = countryRepository.getOne(countryModel.getId());
        country.setName(countryModel.getName());
        countryRepository.save(country);
        return countryModel;
    }
    public ResponseEntity<String> deleteCountry(Long id){
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isEmpty()) {
            return new ResponseEntity<>("Id country was not found in database", HttpStatus.BAD_REQUEST);
        }

        List<Region> regionList = regionRepository.findByCountryId(id);
        List<Long> regionIdsList = new ArrayList<>();
        for (Region region : regionList) {
            regionIdsList.add(region.getId());
        }
        List<Locality> localityList = localityRepository.findByRegionIdIn(regionIdsList);
        List<Long> localityIdsList = new ArrayList<>();
        for (Locality locality : localityList){
            localityIdsList.add(locality.getId());
        }

        localitySportRepository.deleteByLocalityIdIn(localityIdsList);
        localityRepository.deleteByRegionIdIn(regionIdsList);
        regionRepository.deleteByCountryId(optionalCountry.get().getId());
        countryRepository.delete(optionalCountry.get());

        return new ResponseEntity<>("Delete country ok", HttpStatus.OK);
    }

}
