/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.DatosEmpresa;
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
public class DatosEmpresaJpaController implements Serializable {

    public DatosEmpresaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DatosEmpresa datosEmpresa) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(datosEmpresa);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findDatosEmpresa(datosEmpresa.getDatEmpId()) != null) {
                throw new PreexistingEntityException("DatosEmpresa " + datosEmpresa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DatosEmpresa datosEmpresa) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            datosEmpresa = em.merge(datosEmpresa);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = datosEmpresa.getDatEmpId();
                if (findDatosEmpresa(id) == null) {
                    throw new NonexistentEntityException("The datosEmpresa with id " + id + " no longer exists.");
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
            DatosEmpresa datosEmpresa;
            try {
                datosEmpresa = em.getReference(DatosEmpresa.class, id);
                datosEmpresa.getDatEmpId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datosEmpresa with id " + id + " no longer exists.", enfe);
            }
            em.remove(datosEmpresa);
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

    public List<DatosEmpresa> findDatosEmpresaEntities() {
        return findDatosEmpresaEntities(true, -1, -1);
    }

    public List<DatosEmpresa> findDatosEmpresaEntities(int maxResults, int firstResult) {
        return findDatosEmpresaEntities(false, maxResults, firstResult);
    }

    private List<DatosEmpresa> findDatosEmpresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DatosEmpresa.class));
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

    public DatosEmpresa findDatosEmpresa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DatosEmpresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatosEmpresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DatosEmpresa> rt = cq.from(DatosEmpresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
