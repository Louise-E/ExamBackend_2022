package facades;

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

class GuestFacadeTest {
    /*private static EntityManagerFactory emf;
    private static GuestFacade guestFacade;

    private Guest guest1, guest2;
    private Shows shows1, shows2;
    private Festival festival;

    @BeforeAll
    public static void SetUpClass(){
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        guestFacade = GuestFacade.getGuestFacade(emf);
    }

    @AfterAll
    public static void tearDownClass(){

    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        festival = new Festival("Sundance", "Salt Lake City", "14-06-2022", "10 days");
        List<Shows> showsList = new ArrayList<>();
        shows1 = new Shows("Marvel", "3 hours", "Theater 2", "14-06-2022", "20:00");
        shows2 = new Shows("Horror Night", "4 hours", "Theater 1", "14-06-2022", "23:30");
        showsList.add(shows1);
        showsList.add(shows2);
        guest1 = new Guest("Bente", "23543276", "bente@email.dk", "Assigned",festival, showsList);
        guest2 = new Guest("Poul", "54769832", "poul@email.dk", "Cancelled",festival, showsList);
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Guest.deleteAllRows").executeUpdate();
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
    public void getGuestFacade() {
    }

    @Test
    public void getAllShowsFromGuest() {
        List<ShowDTO> showsList = guestFacade.getAllShowsFromGuest(guest1.getGuestName());

        ShowDTO showDTO1 = new ShowDTO(shows1);
        ShowDTO showDTO2 = new ShowDTO(shows2);

        int expected = 2;
        int actual = showsList.size();
        List<Shows> showsList = new ArrayList<>();

        String expected = showsList.toString();
        String actual = guestFacade.getAllShowsFromGuest();

        assertEquals(expected, actual);


    }*/
}