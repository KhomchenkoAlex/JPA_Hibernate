package edu.hibernatexmpl.repository;

import edu.hibernatexmpl.model.Tyre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TyresRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Tyre findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tyre.class, id);
    }

    public List<Tyre> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Tyre.class).list();
    }

    public void save(Tyre tyre) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tyre);
    }
}
