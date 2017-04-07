package edu.hibernatexmpl.repository;

import edu.hibernatexmpl.model.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EngineRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Engine findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Engine.class, id);
    }

    public List<Engine> findAll(){
        Session session = sessionFactory.openSession();
        return session.createCriteria(Engine.class).list();
    }

    public void save(Engine engine){
        Session session = sessionFactory.getCurrentSession();
        session.save(engine);
    }
}
