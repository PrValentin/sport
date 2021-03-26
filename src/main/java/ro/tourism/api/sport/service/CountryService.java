package ro.tourism.api.sport.service;

import org.springframework.stereotype.Service;
import ro.tourism.api.sport.entity.Country;
import ro.tourism.api.sport.repository.CountryRepository;

import java.util.List;
import java.util.Objects;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository = Objects.requireNonNull(countryRepository, "countryRepository must not be null");
    }
    public List<Country> getAllCountries(){
        return countryRepository.findByOrderById();
    }
}
