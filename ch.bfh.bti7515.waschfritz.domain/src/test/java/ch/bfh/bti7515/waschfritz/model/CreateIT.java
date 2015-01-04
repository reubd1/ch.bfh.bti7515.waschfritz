package ch.bfh.bti7515.waschfritz.model;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;

/**
 * Created by adrian on 04.11.14.
 */
public class CreateIT {

    @Test
    public void test() {
        Machine machine = new Machine();
        machine.setName("Super Machine");
        machine.setType("Zug");

        Tenant tenant = new Tenant();
        tenant.setName("Hans Muster");
        tenant.setAddress("6b");

        Reservation reservation = new Reservation();


        reservation.setStartDate(new GregorianCalendar(2014, 11, 04, 14, 00, 00).getTime());
        reservation.setEndDate(new GregorianCalendar(2014, 11, 04, 20, 00, 00).getTime());

        reservation.setMachine(machine);
        //reservation.setTenant(tenant);

        EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.bti7515.waschfritz.domain").createEntityManager();

        em.getTransaction().begin();
        em.persist(reservation);
        em.getTransaction().commit();


    }
}
