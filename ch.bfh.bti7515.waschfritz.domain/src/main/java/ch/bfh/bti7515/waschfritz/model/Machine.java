package ch.bfh.bti7515.waschfritz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by reubid on 04.11.14.
 */
@Entity
public class Machine {

    @GeneratedValue
    @Id
    private Long id;


    private String name;
    private String type;

    //@OneToMany(mappedBy = "machine")
    //private List<Reservation> reservations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //@Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

/*
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }*/
}
