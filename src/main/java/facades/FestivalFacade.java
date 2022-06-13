package facades;

import dtos.FestivalDTO;
import entities.Festival;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FestivalFacade {
    private static EntityManagerFactory emf;
    private static FestivalFacade instance;

    public FestivalFacade(){

    }

    public static FestivalFacade getFestivalFacade(EntityManagerFactory _emf){
        if (instance == null){
            emf = _emf;
            instance = new FestivalFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public FestivalDTO createFestival(FestivalDTO festivalDTO) throws IllegalStateException{
        EntityManager em = getEntityManager();
        Festival festival = new Festival(festivalDTO.getFestivalId(), festivalDTO.getFestivalName(), festivalDTO.getCity(), festivalDTO.getStartDate(), festivalDTO.getDuration(), festivalDTO.getGuests());
        try {
            em.getTransaction().begin();
            em.persist(festival);
            em.getTransaction().commit();
        } finally {
          em.close();
        }
        return new FestivalDTO(festival);
    }
}
