package ro.tourism.api.sport.model;

public class SportCostModel {

    private String sportName;

    private Double cost;

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "SportCostModel{" +
                "sportName='" + sportName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
