package ro.tourism.api.sport.entity;

import javax.persistence.*;

@Entity
@Table(name = "sport")
public class Sport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sport_gen")
    @SequenceGenerator(name ="seq_sport_gen", sequenceName = "seq_id_sport", allocationSize = 1)
    private long id;

    @Column(name="name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
