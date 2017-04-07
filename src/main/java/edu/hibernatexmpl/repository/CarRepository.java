package edu.hibernatexmpl.repository;

import edu.hibernatexmpl.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CarRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Car findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }

    public List<Car> findAll(){
        Session session = sessionFactory.openSession();
        return session.createCriteria(Car.class).list();
    }

    public void save(Car car){
        Session session = sessionFactory.openSession();
        session.save(car);
    }
}
