package ro.tourism.api.sport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tourism.api.sport.entity.Region;
import ro.tourism.api.sport.model.RegionModel;
import ro.tourism.api.sport.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    private RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Region> getRegions() {
        return regionService.getAllRegions();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRegion(@RequestBody RegionModel newRegion) {
        return regionService.addRegion(newRegion);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateRegion(@RequestBody RegionModel regionModel) {
        return regionService.updateRegion(regionModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRegion(@PathVariable("id") final Long id) {
        return regionService.deleteRegion(id);
    }
}
