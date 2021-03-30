package ro.tourism.api.sport.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="locality_sport")
public class LocalitySport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_locality_sport_gen")
    @SequenceGenerator(name = "seq_locality_sport_gen", sequenceName = "seq_id_locality_sport", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sport")
    private Sport sport;

    @ManyToOne
    @JoinColumn(name = "id_locality")
    private Locality locality;

    @Column(name="start_season")
    private LocalDate startSeason;

    @Column(name="end_season")
    private LocalDate endSeason;

    @Column(name="cost_day")
    private Long costDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public LocalDate getStartSeason() {
        return startSeason;
    }

    public void setStartSeason(LocalDate startSeason) {
        this.startSeason = startSeason;
    }

    public LocalDate getEndSeason() {
        return endSeason;
    }

    public void setEndSeason(LocalDate endSeason) {
        this.endSeason = endSeason;
    }

    public Long getCostDay() {
        return costDay;
    }

    public void setCostDay(Long costDay) {
        this.costDay = costDay;
    }

    @Override
    public String toString() {
        return "LocalitySport{" +
                "id=" + id +
                ", sport=" + sport +
                ", locality=" + locality +
                ", startSeason=" + startSeason +
                ", endSeason=" + endSeason +
                ", costDay=" + costDay +
                '}';
    }

}
