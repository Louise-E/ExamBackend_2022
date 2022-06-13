package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Guest")
@NamedQuery(name = "Guest.deleteAllRows", query = "DELETE FROM Guest")
public class Guest implements Serializable {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "guest_id", updatable = false, nullable = false)
    private Integer guestId;
    @Column(name = "guest_name", nullable = false)
    private String guestName;
    @Column(name = "guest_phone", nullable = false)
    private String phone;
    @Column(name = "guest_email", nullable = false)
    private String email;
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Festival festival = new Festival();

    @ManyToMany(mappedBy = "guestList", cascade = CascadeType.PERSIST)
    private List<Shows> showsList = new ArrayList<>();

    public Guest() {
    }

    public Guest(Integer guestId, String guestName, String phone, String email, String status, Festival festival, List<Shows> showsList) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.festival = festival;
        this.showsList = showsList;
    }

    public Guest(String guestName, String phone, String email, String status, Festival festival) {
        this.guestName = guestName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.festival = festival;
    }

    public Guest(String guestName, String phone, String email, String status, Festival festival, List<Shows> showsList) {
        this.guestName = guestName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.festival = festival;
        this.showsList = showsList;
    }

    public Guest(String guestName, String phone, String email, String status, List<Shows> showsList) {
        this.guestName = guestName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.showsList = showsList;
    }

    public Guest(String guestName, String phone, String email, String status) {
        this.guestName = guestName;
        this.phone = phone;
        this.email = email;
        this.status = status;
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
        return "Guest{" +
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
