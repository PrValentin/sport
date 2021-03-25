package ro.tourism.api.sport.entity;

import javax.persistence.*;

@Entity
@Table(name = "locality")
public class Locality {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_locality_gen")
    @SequenceGenerator(name = "seq_locality_gen", sequenceName = "seq_id_locality", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", region=" + region +
                ", name='" + name + '\'' +
                '}';
    }
}
