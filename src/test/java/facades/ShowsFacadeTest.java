package facades;

import dtos.ShowDTO;
import entities.Festival;
import entities.Guest;
import entities.Shows;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowsFacadeTest {
    private static EntityManagerFactory emf;
    private static ShowFacade showFacade;

    Shows shows1, shows2;
    Guest guest1, guest2;
    Festival festival;

    @BeforeAll
    public static void SetUpClass(){
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        showFacade = ShowFacade.getShowFacade(emf);
    }

    @AfterAll
    public static void tearDownClass(){

    }

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        festival = new Festival("Sundance", "Salt Lake City", "14-06-2022", "10 days");
        List<Guest> guests = new ArrayList<>();
        guest1 = new Guest("Bente", "23543276", "bente@email.dk", "Assigned",festival);
        guest2 = new Guest("Poul", "54769832", "poul@email.dk", "Cancelled",festival);
        guests.add(guest1);
        guests.add(guest2);
        shows1 = new Shows("Marvel", "3 hours", "Theater 2", "14-06-2022", "20:00", guests);
        shows2 = new Shows("Horror Night", "4 hours", "Theater 1", "14-06-2022", "23:30", guests);
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Shows.deleteAllRows").executeUpdate();
            //em.createNamedQuery("Festival.deleteAllRows").executeUpdate();
            //em.createNamedQuery("Guest.deleteAllRows").executeUpdate();
            em.persist(festival);
            em.persist(guest1);
            em.persist(guest2);
            em.persist(shows1);
            em.persist(shows2);
            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void getShowFacade() {
    }

    //virker
    @Test
    public void getAllShows() {
        /*ShowDTO showDTO1 = new ShowDTO(shows1);
        ShowDTO showDTO2 = new ShowDTO(shows2);
        List<Guest> guests = shows1.getGuestList();
        showDTO1.setGuestList(guests);
        showDTO2.setGuestList(guests);

        List<ShowDTO> showDTOS = new ArrayList<>();
        showDTOS.add(showDTO1);
        showDTOS.add(showDTO2);

        String expected = shows1.getShowName();
        String actual = showFacade.getAllShows().size();

        */
        int expected = 2;
        int actual = showFacade.getAllShows().size();

        assertEquals(expected, actual);

    }
}