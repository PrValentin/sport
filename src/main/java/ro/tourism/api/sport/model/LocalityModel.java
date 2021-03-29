package ro.tourism.api.sport.model;

public class LocalityModel {
    Long id;
    Long idRegion;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LocalityModel{" +
                "id=" + id +
                ", idRegion=" + idRegion +
                ", name='" + name + '\'' +
                '}';
    }
}
