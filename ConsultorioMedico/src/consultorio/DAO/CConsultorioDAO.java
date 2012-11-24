/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.DAO;

import consultorio.VO.CEps;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author arturo
 */
public class CConsultorioDAO {

    public void insertar(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void actualizar(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void eliminar(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(object));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        
    }
    
    public CEps getEpsById(String codigo){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        return em.find(CEps.class, codigo);
    }
    
    
    
}
