package br.edu.ifsp.pep.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDAO<T> {

    private EntityManagerFactory emf;

    public AbstractDAO() {
        emf = Persistence.createEntityManagerFactory("herancaPU");
    }

    protected EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(T entity) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();
    }

    public void alterar(T entity) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        em.merge(entity);

        em.getTransaction().commit();
    }
}
