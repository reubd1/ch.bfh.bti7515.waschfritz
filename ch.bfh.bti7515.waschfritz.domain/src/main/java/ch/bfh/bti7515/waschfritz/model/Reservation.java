package ch.bfh.bti7515.waschfritz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by reubid on 04.11.14.
 */
@Entity
public class Reservation {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Date startDate;

    @Basic
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private Date endDat;

    @Basic
    public Date getEndDat() {
        return endDat;
    }

    public void setEndDat(Date endDat) {
        this.endDat = endDat;
    }

    private Machine machine;

    @OneToOne
    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    private Tenant tenant;

    @ManyToOne
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
