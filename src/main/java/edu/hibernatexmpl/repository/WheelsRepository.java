package edu.hibernatexmpl.repository;

import edu.hibernatexmpl.model.Wheel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WheelsRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Wheel findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Wheel.class, id);
    }

    public List<Wheel> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Wheel.class).list();
    }

    public void save(Wheel wheel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(wheel);
    }
}
