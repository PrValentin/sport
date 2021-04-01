package ro.tourism.api.sport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tourism.api.sport.model.LocalitySportsCostsListModel;
import ro.tourism.api.sport.model.SportsFilterModel;
import ro.tourism.api.sport.service.FilterService;

@RestController
@RequestMapping("/filter")
public class FilterController {
    private final FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }
    @GetMapping("/sportDate")
    public LocalitySportsCostsListModel showLocalitySportsCostsModels (@RequestBody SportsFilterModel sportsFilterModel) {
       return filterService.getLocalitySportsCostsModels(sportsFilterModel);
    }
}
