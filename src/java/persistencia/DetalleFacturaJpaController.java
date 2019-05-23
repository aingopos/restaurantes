/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.DetalleFactura;
import entidades.DetalleFacturaPK;
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
public class DetalleFacturaJpaController implements Serializable {

    public DetalleFacturaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleFactura detalleFactura) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (detalleFactura.getDetalleFacturaPK() == null) {
            detalleFactura.setDetalleFacturaPK(new DetalleFacturaPK());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(detalleFactura);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findDetalleFactura(detalleFactura.getDetalleFacturaPK()) != null) {
                throw new PreexistingEntityException("DetalleFactura " + detalleFactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleFactura detalleFactura) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            detalleFactura = em.merge(detalleFactura);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetalleFacturaPK id = detalleFactura.getDetalleFacturaPK();
                if (findDetalleFactura(id) == null) {
                    throw new NonexistentEntityException("The detalleFactura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetalleFacturaPK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            DetalleFactura detalleFactura;
            try {
                detalleFactura = em.getReference(DetalleFactura.class, id);
                detalleFactura.getDetalleFacturaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleFactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleFactura);
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

    public List<DetalleFactura> findDetalleFacturaEntities() {
        return findDetalleFacturaEntities(true, -1, -1);
    }

    public List<DetalleFactura> findDetalleFacturaEntities(int maxResults, int firstResult) {
        return findDetalleFacturaEntities(false, maxResults, firstResult);
    }

    private List<DetalleFactura> findDetalleFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleFactura.class));
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

    public DetalleFactura findDetalleFactura(DetalleFacturaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleFactura> rt = cq.from(DetalleFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
