/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.AdministradorSistema;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;
import persistencia.exceptions.RollbackFailureException;

/**
 *
 * @author usuario
 */
public class AdministradorSistemaJpaController implements Serializable {

    public AdministradorSistemaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AdministradorSistema administradorSistema) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(administradorSistema);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findAdministradorSistema(administradorSistema.getIdAdmin()) != null) {
                throw new PreexistingEntityException("AdministradorSistema " + administradorSistema + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AdministradorSistema administradorSistema) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            administradorSistema = em.merge(administradorSistema);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = administradorSistema.getIdAdmin();
                if (findAdministradorSistema(id) == null) {
                    throw new NonexistentEntityException("The administradorSistema with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            AdministradorSistema administradorSistema;
            try {
                administradorSistema = em.getReference(AdministradorSistema.class, id);
                administradorSistema.getIdAdmin();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administradorSistema with id " + id + " no longer exists.", enfe);
            }
            em.remove(administradorSistema);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AdministradorSistema> findAdministradorSistemaEntities() {
        return findAdministradorSistemaEntities(true, -1, -1);
    }

    public List<AdministradorSistema> findAdministradorSistemaEntities(int maxResults, int firstResult) {
        return findAdministradorSistemaEntities(false, maxResults, firstResult);
    }

    private List<AdministradorSistema> findAdministradorSistemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AdministradorSistema.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AdministradorSistema findAdministradorSistema(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AdministradorSistema.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministradorSistemaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AdministradorSistema> rt = cq.from(AdministradorSistema.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
