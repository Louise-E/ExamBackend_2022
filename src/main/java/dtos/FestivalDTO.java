package dtos;

import entities.Festival;
import entities.Guest;
import java.util.ArrayList;
import java.util.List;

public class FestivalDTO {
    private Integer festivalId;
    private String festivalName;
    private String city;
    private String startDate;
    private String duration;
    private List<Guest> guests;

    public FestivalDTO() {
    }

    public FestivalDTO(Integer festivalId, String festivalName, String city, String startDate, String duration, List<Guest> guests) {
        this.festivalId = festivalId;
        this.festivalName = festivalName;
        this.city = city;
        this.startDate = startDate;
        this.duration = duration;
        this.guests = guests;
    }

    public FestivalDTO(Festival festival){
        this.festivalId = festival.getFestivalId();
        this.festivalName = festival.getFestivalName();
        this.city = festival.getCity();
        this.startDate = festival.getStartDate();
        this.duration = festival.getDuration();
        this.guests = festival.getGuests();
    }

    public static List<FestivalDTO> getDtos(List<Festival> festivals) {
        List <FestivalDTO> festivalDTOS = new ArrayList<>();
        if (festivals != null){
            festivals.forEach(f -> festivalDTOS.add(new FestivalDTO(f)));
        }
        return festivalDTOS;
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
        return "FestivalDTO{" +
                "festivalId=" + festivalId +
                ", festivalName='" + festivalName + '\'' +
                ", city='" + city + '\'' +
                ", startDate='" + startDate + '\'' +
                ", duration='" + duration + '\'' +
                ", guests=" + guests +
                '}';
    }
}
