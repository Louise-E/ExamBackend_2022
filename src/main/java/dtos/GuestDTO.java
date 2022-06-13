package dtos;

import entities.Festival;
import entities.Guest;
import entities.Shows;
import java.util.ArrayList;
import java.util.List;

public class GuestDTO {
    private Integer guestId;
    private String guestName;
    private String phone;
    private String email;
    private String status;
    private Festival festival;
    private List<Shows> showsList;

    public GuestDTO() {
    }

    public GuestDTO(Integer guestId, String guestName, String phone, String email, String status, Festival festival, List<Shows> showsList) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.festival = festival;
        this.showsList = showsList;
    }

    public GuestDTO(Guest guest) {
        this.guestId = guest.getGuestId();
        this.guestName = guest.getGuestName();
        this.phone = guest.getPhone();
        this.email = guest.getEmail();
        this.status = guest.getStatus();
        this.festival = guest.getFestival();
        this.showsList = guest.getShowList();
    }

    public static List<GuestDTO> getDtos(List<Guest> guests) {
        List<GuestDTO> guestDTOS = new ArrayList<>();
        if (guests != null){
            guests.forEach(g -> guestDTOS.add(new GuestDTO(g)));
        }
        return guestDTOS;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public List<Shows> getShowList() {
        return showsList;
    }

    public void setShowList(List<Shows> showsList) {
        this.showsList = showsList;
    }

    @Override
    public String toString() {
        return "GuestDTO{" +
                "guestId=" + guestId +
                ", guestName='" + guestName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", festival=" + festival +
                ", showList=" + showsList +
                '}';
    }
}
