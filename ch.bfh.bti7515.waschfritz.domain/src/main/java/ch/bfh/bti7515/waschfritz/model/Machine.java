package ch.bfh.bti7515.waschfritz.model;

import javax.persistence.*;

/**
 * Created by reubid on 04.11.14.
 */
@Entity
public class Machine {
    private Long id;
    private String name;
    private String type;


    private Reservation reservation;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToOne(mappedBy = "machine")
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
