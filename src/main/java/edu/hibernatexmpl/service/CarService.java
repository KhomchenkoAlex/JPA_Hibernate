package edu.hibernatexmpl.service;

import edu.hibernatexmpl.model.Car;
import edu.hibernatexmpl.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car findById(int id) {
        return carRepository.findById(id);
    }

    public List<Car> findAll(){ return carRepository.findAll();}

    public void save(Car car) {
        carRepository.save(car);
    }
}
