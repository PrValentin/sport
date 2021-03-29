package ro.tourism.api.sport.model;

public class RegionModel {
    private Long id;
    private Long idCountry;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RegionModel{" +
                "id=" + id +
                ", idCountry=" + idCountry +
                ", name='" + name + '\'' +
                '}';
    }
}
