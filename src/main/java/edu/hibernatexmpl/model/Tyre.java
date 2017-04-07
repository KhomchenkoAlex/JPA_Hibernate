package edu.hibernatexmpl.model;

import edu.hibernatexmpl.enums.SeasonType;

import javax.persistence.*;

@Entity
@Table(name = "tyre")
public class Tyre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seasontype")
    private SeasonType seasonType;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Wheel wheel;

    public void setId() {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSeasonType(SeasonType seasonType) {
        this.seasonType = seasonType;
    }

    public SeasonType getSeasonType() {
        return seasonType;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public Tyre(SeasonType seasonType) {
        this.seasonType = seasonType;
    }

    Tyre() {
    }
}
