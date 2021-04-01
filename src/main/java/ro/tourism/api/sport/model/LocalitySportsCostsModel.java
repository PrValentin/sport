package ro.tourism.api.sport.model;

import java.util.List;

public class LocalitySportsCostsModel {

    private String localityName;

    private List<SportCostModel> sportCostModels;

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public List<SportCostModel> getSportCostModels() {
        return sportCostModels;
    }

    public void setSportCostModels(List<SportCostModel> sportCostModels) {
        this.sportCostModels = sportCostModels;
    }

    @Override
    public String toString() {
        return "SportsFilterReturnModel{" +
                "localityName='" + localityName + '\'' +
                ", sportCostModels=" + sportCostModels +
                '}';
    }
}
