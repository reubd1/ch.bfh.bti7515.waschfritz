package ch.bfh.bti7515.waschfritz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by reubid on 04.11.14.
 */
@Entity
public class Reservation {
    @GeneratedValue
    @Id
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Machine machine;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Tenant tenant;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }


    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
