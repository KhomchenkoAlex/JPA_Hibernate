package edu.hibernatexmpl.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "car", cascade = CascadeType.ALL)
    private List<Wheel> wheels;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    public void setId() {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public Car(String name, List<Wheel> wheels, Engine engine) {
        this.name = name;
        this.wheels = wheels;
        this.engine = engine;
    }

    Car() {
    }

    @Override
    public String toString() {
        String result = name + " " + id + " " + engine.getName();
        return result;
    }
}
