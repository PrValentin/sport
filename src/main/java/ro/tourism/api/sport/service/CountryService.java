package ro.tourism.api.sport.service;

import org.springframework.stereotype.Service;
import ro.tourism.api.sport.entity.Country;
import ro.tourism.api.sport.model.CountryModel;
import ro.tourism.api.sport.repository.CountryRepository;

import java.util.List;
import java.util.Objects;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "countryRepository must not be null");
    }

    public List<Country> getAllCountries() {
        return countryRepository.findByOrderById();
    }

    public CountryModel addCountry(CountryModel countryAdd) {
        Country country = new Country();
        country.setName(countryAdd.getName());
        countryRepository.save(country);
        return countryAdd;
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
    public void deleteCountry(Long id){
        Country country = countryRepository.getOne(id);
        countryRepository.delete(country);
    }

}
