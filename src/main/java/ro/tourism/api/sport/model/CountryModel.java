package ro.tourism.api.sport.model;

public class CountryModel {
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CountryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
