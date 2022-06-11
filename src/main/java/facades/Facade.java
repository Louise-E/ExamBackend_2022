package facades;

import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Facade {
    private static Facade instance;
    private static EntityManagerFactory emf;

    private Facade() {
    }

    public static Facade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new Facade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private String create(){
        return "add later";
    }
    private String read(){
        return "add later";
    }
    private String update(){
        return "add later";
    }
    private String delete(){
        return "add later";
    }

    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        Facade f = getFacadeExample(emf);
    }

}
