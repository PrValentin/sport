package ro.tourism.api.sport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tourism.api.sport.entity.Country;
import ro.tourism.api.sport.model.CountryModel;
import ro.tourism.api.sport.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCountry(@RequestBody CountryModel newCountry){
        return countryService.addCountry(newCountry);
    }

    @PostMapping("/update")
    public CountryModel updateCountry(@RequestBody CountryModel countryModel) {
        return countryService.updateCountry(countryModel);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteCountry(@PathVariable("id") final Long id) {
       return countryService.deleteCountry(id);
    }

}
