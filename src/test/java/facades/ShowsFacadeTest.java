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

class ShowsFacadeTest {
    /*private static EntityManagerFactory emf;
    private static ShowFacade showFacade;

    private Shows shows1, shows2;
    private Guest guest1, guest2;
    private Festival festival;

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
            em.createNamedQuery("Festival.deleteAllRows").executeUpdate();
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
    public void getShowFacade() {
    }

    //virker
    @Test
    public void getAllShowsTest() {
        int expected = 2;
        int actual = showFacade.getAllShows().size();

        assertEquals(expected, actual);

    }

    //virker
    @Test
    public void deleteShowByIdTest(){
        Integer id = shows1.getShowId();
        String expected = "Show has been deleted with id: " + id;
        String actual = showFacade.deleteShowById(id);

        assertEquals(expected, actual);
    }

    @Test
    public void getAllShowsFromGuest(){
        int expected = 2;
        int actual = showFacade.getAllShows().get(0).;

        //assertEquals(expected, actual);

    }*/
}