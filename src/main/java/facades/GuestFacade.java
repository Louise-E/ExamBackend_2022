package facades;

import dtos.ShowDTO;
import entities.Guest;
import entities.Shows;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class GuestFacade {
    private static EntityManagerFactory emf;
    private static GuestFacade instance;

    public GuestFacade(){

    }

    public static GuestFacade getGuestFacade(EntityManagerFactory _emf){
        if (instance == null){
            emf = _emf;
            instance = new GuestFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /*public List<ShowDTO> getAllShowsFromGuest(List<ShowDTO> showlist){
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
