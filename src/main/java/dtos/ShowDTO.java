package dtos;

import entities.Guest;
import entities.Shows;
import java.util.ArrayList;
import java.util.List;

public class ShowDTO {
    private Integer showId;
    private String showName;
    private String duration;
    private String location;
    private String startDate;
    private String startTime;
    private List<Guest> guestList;

    public ShowDTO() {
    }

    public ShowDTO(Integer showId, String showName, String duration, String location, String startDate, String startTime, List<Guest> guestList) {
        this.showId = showId;
        this.showName = showName;
        this.duration = duration;
        this.location = location;
        this.startDate = startDate;
        this.startTime = startTime;
        this.guestList = guestList;
    }

    public ShowDTO(Shows shows) {
        this.showId = shows.getShowId();
        this.showName = shows.getShowName();
        this.duration = shows.getDuration();
        this.location = shows.getLocation();
        this.startDate = shows.getStartDate();
        this.startTime = shows.getStartTime();
        this.guestList = shows.getGuestList();
    }

    public static List<ShowDTO> getDtos(List<Shows> shows){
        List<ShowDTO> showDTOS = new ArrayList<>();
        if (shows != null){
            shows.forEach(s -> showDTOS.add(new ShowDTO(s)));
        }
        return showDTOS;
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
        return "ShowDTO{" +
                "showId=" + showId +
                ", showName='" + showName + '\'' +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", guestList=" + guestList +
                '}';
    }
}
