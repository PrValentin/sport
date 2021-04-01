package ro.tourism.api.sport.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class SportsFilterModel {

    private List<Long> idSports;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startSeason;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endSeason;

    public List<Long> getIdSports() {
        return idSports;
    }

    public void setIdSports(List<Long> idSports) {
        this.idSports = idSports;
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

    @Override
    public String toString() {
        return "SportsFilterModel{" +
                "idSports=" + idSports +
                ", startSeason=" + startSeason +
                ", endSeason=" + endSeason +
                '}';
    }
}
