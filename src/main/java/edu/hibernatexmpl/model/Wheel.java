package edu.hibernatexmpl.model;

import javax.persistence.*;

@Entity
@Table(name = "wheel")
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private int size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tyres_id")
    private Tyre tyre;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public void setId() {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Wheel(String name, int size, Tyre tyre) {
        this.name = name;
        this.size = size;
        this.tyre = tyre;
    }

    Wheel() {
    }
}
