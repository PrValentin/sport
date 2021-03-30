package ro.tourism.api.sport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tourism.api.sport.entity.LocalitySport;
import ro.tourism.api.sport.model.LocalitySportModel;
import ro.tourism.api.sport.service.LocalitySportService;

import java.util.List;

@RestController
@RequestMapping("/localitySport")
public class LocalitySportController {
    LocalitySportService localitySportService;

    public LocalitySportController(LocalitySportService localitySportService){
        this.localitySportService = localitySportService;
    }
    @GetMapping("/list")
    public List<LocalitySport> getLocalitiesSport() {
        return localitySportService.getAllLocalitiesSport();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLocalitySport(@RequestBody LocalitySportModel newLocalitySportModel)  {
        return localitySportService.addLocalitySport(newLocalitySportModel);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateLocalitySport(@RequestBody LocalitySportModel localitySportModel) {
        return localitySportService.updateLocalitySport(localitySportModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLocalitiesSport(@PathVariable("id") final Long id) {
        return localitySportService.deleteLocalitiesSport(id);
    }
}
