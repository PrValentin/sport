package ro.tourism.api.sport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tourism.api.sport.entity.Sport;
import ro.tourism.api.sport.model.SportModel;
import ro.tourism.api.sport.service.SportService;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {

    private SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Sport> getSports() {
        return sportService.getAllSports();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSport(SportModel newSportModel) {
        return sportService.addSport(newSportModel);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateSport(@RequestBody SportModel sportModel) {
        return sportService.updateSport(sportModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSport(@PathVariable("id") final Long id) {
        return sportService.deleteSport(id);
    }


}
