package ro.tourism.api.sport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tourism.api.sport.entity.Locality;
import ro.tourism.api.sport.model.LocalityModel;
import ro.tourism.api.sport.service.LocalityService;

import java.util.List;


@RestController
@RequestMapping("/locality")
public class LocalityController {

    private LocalityService localityService;

    public LocalityController(LocalityService localityService){
        this.localityService = localityService;
    }

    @GetMapping("/list")
    public List<Locality> getLocalities() {
        return localityService.getAllLocality();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLocality(@RequestBody LocalityModel localityModel) {
        return localityService.addLocality(localityModel);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateLocality(@RequestBody LocalityModel localityModel) {
        return localityService.updateLocality(localityModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLocality(@PathVariable("id") final Long id) {
        return localityService.deleteLocality(id);
    }

}
