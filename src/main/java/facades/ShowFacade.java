package facades;

import dtos.ShowDTO;
import entities.Shows;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShowFacade {
    private static EntityManagerFactory emf;
    private static ShowFacade instance;

    public ShowFacade() {
    }

    public static ShowFacade getShowFacade(EntityManagerFactory _emf){
        if (instance == null){
            emf = _emf;
            instance = new ShowFacade();
        }
        return instance;
    }

    /*public Show createShow(){

    }*/

    public List<ShowDTO> getAllShows(){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query = em.createQuery("SELECT s FROM Shows s", Shows.class);
            List<Shows> shows = query.getResultList();
            return ShowDTO.getDtos(shows);
        }finally {
            em.close();
        }
    }
}
