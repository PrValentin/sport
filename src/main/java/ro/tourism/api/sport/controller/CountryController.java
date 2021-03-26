package ro.tourism.api.sport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ro.tourism.api.sport.entity.Country;
import ro.tourism.api.sport.service.CountryService;

import java.net.http.HttpResponse;
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


}
