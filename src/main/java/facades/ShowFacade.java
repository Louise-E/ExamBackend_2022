package facades;

import dtos.ShowDTO;
import entities.Festival;
import entities.Guest;
import entities.Shows;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   /* public ShowDTO createShow(ShowDTO showDTO){
        EntityManager em = emf.createEntityManager();
        try {
            Guest guest = em.find(Guest.class, showDTO.getGuestList());
            if (guest == null){
                throw new NotFoundException(showDTO.getShowName(), showDTO.getDuration(), showDTO.getLocation(), showDTO.getStartDate(), showDTO.getStartTime())
            }
        }
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

    public String deleteShowById(Integer id){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Shows shows = em.find(Shows.class, id);
            em.remove(shows);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return "Show has been deleted with id: " + id;
    }

    /*public List<ShowDTO> getAllShowsFromGuest(String showlist){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query = em.createQuery("SELECT g FROM Guest g Where g.showsList.size = :showlist", Guest.class);
            query.setParameter("showlist", showlist);
            List<Shows> showsList = query.getResultList();
            List<ShowDTO> showDTOS = new ArrayList<>();
            for (Shows s:showsList) {
                showDTOS.add(new ShowDTO(s));
            }
            return showDTOS;

        } finally {
            em.close();
        }
    }*/
}
