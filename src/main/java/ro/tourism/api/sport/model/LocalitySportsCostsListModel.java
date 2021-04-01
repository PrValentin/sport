package ro.tourism.api.sport.model;

import java.util.List;

public class LocalitySportsCostsListModel {

    private List<LocalitySportsCostsModel> localitySportsCostsModels;

    public List<LocalitySportsCostsModel> getSportsFilterReturnModels() {
        return localitySportsCostsModels;
    }

    public void setSportsFilterReturnModels(List<LocalitySportsCostsModel> localitySportsCostsModels) {
        this.localitySportsCostsModels = localitySportsCostsModels;
    }

    @Override
    public String toString() {
        return "FilterReturnModel{" +
                "sportsFilterReturnModels=" + localitySportsCostsModels +
                '}';
    }
}
