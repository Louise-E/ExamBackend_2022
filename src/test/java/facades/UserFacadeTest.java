package facades;

import entities.Role;
import entities.User;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

class UserFacadeTest {
    private static EntityManagerFactory emf;
    private static UserFacade userFacade;

    User user1, user2;
    Role role1, role2;

    public UserFacadeTest(){

    }
    @BeforeAll
    public static void SetUpClass(){
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        userFacade = UserFacade.getUserFacade(emf);
    }

    @AfterAll
    public static void tearDownClass(){

    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        user1 = new User("Hanne", "kode1");
        user2 = new User("Per", "hemmeligt");
        role1 = new Role("user");
        role2 = new Role("admin");
        user1.addRole(role1);
        user2.addRole(role2);

        try {
            em.getTransaction().begin();
            em.createNamedQuery("Users.deleteAllRows").executeUpdate();
            em.persist(user1);
            em.persist(user2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Disabled
    @Test
    public void getUserFacade() {
    }
    @Disabled
    @Test
    public void getVeryfiedUser() {
    }
    @Disabled
    @Test
    public void createTest() {

    }
}