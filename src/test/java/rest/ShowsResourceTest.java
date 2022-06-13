package rest;

import dtos.ShowDTO;
import entities.Festival;
import entities.Guest;
import entities.Shows;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class ShowsResourceTest {
    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();

        httpServer.shutdownNow();
    }


    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Shows").executeUpdate();
            em.createQuery("DELETE FROM Guest").executeUpdate();
            em.createQuery("DELETE FROM Festival").executeUpdate();

            Festival festival = new Festival("Sundance", "Salt Lake City", "14-06-2022", "10 days");
            List<Guest> guests = new ArrayList<>();
            Guest guest1 = new Guest("Bente", "23543276", "bente@email.dk", "Assigned",festival);
            Guest guest2 = new Guest("Poul", "54769832", "poul@email.dk", "Cancelled",festival);
            guests.add(guest1);
            guests.add(guest2);
            Shows shows1 = new Shows("Marvel", "3 hours", "Theater 2", "14-06-2022", "20:00", guests);
            Shows shows2 = new Shows("Horror Night", "4 hours", "Theater 1", "14-06-2022", "23:30", guests);

            em.persist(shows1);
            em.persist(shows2);
            em.persist(guest1);
            em.persist(guest2);
            em.persist(festival);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    private static String securityToken;

    @AfterEach
    public void tearDown() {
    }

    //virker
    @Test
    public void getAllShows() {
        List<ShowDTO> showDTOList;

        showDTOList = given()
                .contentType(MediaType.APPLICATION_JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/show/all")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", ShowDTO.class);

        assertEquals(2, showDTOList.size());
    }
}