package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Shows")
@NamedQuery(name = "Shows.deleteAllRows", query = "DELETE FROM Shows")
public class Shows implements Serializable {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "show_id", updatable = false, nullable = false)
    private Integer showId;
    @Column(name = "show_name", nullable = false)
    private String showName;
    @Column(name = "duration", nullable = false)
    private String duration;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "start_date", nullable = false)
    private String startDate;
    @Column(name = "start_time", nullable = false)
    private String startTime;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Guest> guestList = new ArrayList<>();

    public Shows() {
    }

    public Shows(Integer showId, String showName, String duration, String location, String startDate, String startTime, List<Guest> guestList) {
        this.showId = showId;
        this.showName = showName;
        this.duration = duration;
        this.location = location;
        this.startDate = startDate;
        this.startTime = startTime;
        this.guestList = guestList;
    }

    public Shows(String showName, String duration, String location, String startDate, String startTime, List<Guest> guestList) {
        this.showName = showName;
        this.duration = duration;
        this.location = location;
        this.startDate = startDate;
        this.startTime = startTime;
        this.guestList = guestList;
    }

    public Shows(String showName, String duration, String location, String startDate, String startTime) {
        this.showName = showName;
        this.duration = duration;
        this.location = location;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", showName='" + showName + '\'' +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", startDate=" + startDate +
                ", startTime='" + startTime + '\'' +
                ", guestList=" + guestList +
                '}';
    }
}
