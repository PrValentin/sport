package ro.tourism.api.sport.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class LocalitySportModel {
    Long id;

    Long idSport;

    Long idLocality;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate startSeason;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate endSeason;

    Double costDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSport() {
        return idSport;
    }

    public void setIdSport(Long idSport) {
        this.idSport = idSport;
    }

    public Long getIdLocality() {
        return idLocality;
    }

    public void setIdLocality(Long idLocality) {
        this.idLocality = idLocality;
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

    public Double getCostDay() {
        return costDay;
    }

    public void setCostDay(Double costDay) {
        this.costDay = costDay;
    }

    @Override
    public String toString() {
        return "LocalitySportModel{" +
                "id=" + id +
                ", idSport=" + idSport +
                ", idLocality=" + idLocality +
                ", startSeason=" + startSeason +
                ", endSeason=" + endSeason +
                ", costDay=" + costDay +
                '}';
    }
}
