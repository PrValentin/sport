package ro.tourism.api.sport.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ro.tourism.api.sport.entity.LocalitySport;
import ro.tourism.api.sport.filter.SportLocalityFilterBuilder;
import ro.tourism.api.sport.model.LocalitySportsCostsListModel;
import ro.tourism.api.sport.model.LocalitySportsCostsModel;
import ro.tourism.api.sport.model.SportCostModel;
import ro.tourism.api.sport.model.SportsFilterModel;
import ro.tourism.api.sport.repository.LocalitySportRepository;

import java.util.*;

@Service
public class FilterService {
    LocalitySportRepository localitySportRepository;

    public FilterService(LocalitySportRepository localitySportRepository) {
        this.localitySportRepository = Objects.requireNonNull(localitySportRepository, "localitySportRepository must not be null");

    }

    public LocalitySportsCostsListModel getLocalitySportsCostsModels(SportsFilterModel sportsFilterModel) {

        Specification<LocalitySport> specification = new SportLocalityFilterBuilder(sportsFilterModel).buildFilter();

        LocalitySportsCostsListModel localitySportsCostsListModel = new LocalitySportsCostsListModel();

        List<LocalitySport> localitySportsFiltered = localitySportRepository.findAll(specification);

        Map<Long, List<LocalitySport>> groupByLocality = getMapOfLocalityIdKeyLocalitySportListValue(localitySportsFiltered);

        List<LocalitySportsCostsModel> localitySportsCostsModels = new ArrayList<>();

        for (Map.Entry<Long, List<LocalitySport>> entry : groupByLocality.entrySet()) {
            LocalitySportsCostsModel localitySportsCostsModel = getLocalitySportsCostsModel(entry);
            localitySportsCostsModels.add(localitySportsCostsModel);
        }

        localitySportsCostsListModel.setSportsFilterReturnModels(localitySportsCostsModels);
        return localitySportsCostsListModel;
    }

    private Map<Long, List<LocalitySport>> getMapOfLocalityIdKeyLocalitySportListValue(List<LocalitySport> localitySportsFiltered) {
        Map<Long, List<LocalitySport>> groupByLocality = new HashMap<>();

        for (LocalitySport localitySport : localitySportsFiltered) {
            List<LocalitySport> localitySports = groupByLocality.get(localitySport.getLocality().getId());
            if (localitySports == null) {
                localitySports = new ArrayList<>();
                groupByLocality.put(localitySport.getLocality().getId(), localitySports);
            }
            localitySports.add(localitySport);
        }
        return groupByLocality;
    }

    private LocalitySportsCostsModel getLocalitySportsCostsModel(Map.Entry<Long, List<LocalitySport>> entry) {
        LocalitySportsCostsModel localitySportsCostsModel = new LocalitySportsCostsModel();
        localitySportsCostsModel.setLocalityName(entry.getValue().get(0).getLocality().getName());

        List<SportCostModel> sportCostModels = getSportCostModels(entry);

        localitySportsCostsModel.setSportCostModels(sportCostModels);
        return localitySportsCostsModel;
    }

    private List<SportCostModel> getSportCostModels(Map.Entry<Long, List<LocalitySport>> entry) {
        List<SportCostModel> sportCostModels = new ArrayList<>();
        for (LocalitySport localitySport : entry.getValue()) {
            SportCostModel sportCostModel = new SportCostModel();

            sportCostModel.setSportName(localitySport.getSport().getName());
            sportCostModel.setCost(localitySport.getCostDay());

            sportCostModels.add(sportCostModel);
        }
        return sportCostModels;
    }

}
