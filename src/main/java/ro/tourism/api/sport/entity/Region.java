package ro.tourism.api.sport.entity;

import javax.persistence.*;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_region_gen")
    @SequenceGenerator(name = "seq_region_gen", sequenceName = "seq_id_region", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", country=" + country +
                ", name='" + name + '\'' +
                '}';
    }
}
