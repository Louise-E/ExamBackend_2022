package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Festival")
@NamedQuery(name = "Festival.deleteAllRows", query = "DELETE FROM Festival")
public class Festival implements Serializable {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "festival_id", updatable = false, nullable = false)
    private Integer festivalId;
    @Column(name = "festival_name", nullable = false)
    private String festivalName;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "start_date", nullable = false)
    private String startDate;
    @Column(name = "duration", nullable = false)
    private String duration;

    @OneToMany(mappedBy = "festival", cascade = {CascadeType.PERSIST})
    private List<Guest> guests = new ArrayList<>();

    public Festival() {
    }

    public Festival(Integer festivalId, String festivalName, String city, String startDate, String duration, List<Guest> guests) {
        this.festivalId = festivalId;
        this.festivalName = festivalName;
        this.city = city;
        this.startDate = startDate;
        this.duration = duration;
        this.guests = guests;
    }

    public Festival(String festivalName, String city, String startDate, String duration) {
        this.festivalName = festivalName;
        this.city = city;
        this.startDate = startDate;
        this.duration = duration;
    }

    public Festival(String festivalName, String city, String startDate, String duration, List<Guest> guests) {
        this.festivalName = festivalName;
        this.city = city;
        this.startDate = startDate;
        this.duration = duration;
        this.guests = guests;
    }

    public Integer getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(Integer festivalId) {
        this.festivalId = festivalId;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "Festival{" +
                "festivalId=" + festivalId +
                ", festivalName='" + festivalName + '\'' +
                ", city='" + city + '\'' +
                ", startDate=" + startDate +
                ", duration='" + duration + '\'' +
                ", guests=" + guests +
                '}';
    }
}
