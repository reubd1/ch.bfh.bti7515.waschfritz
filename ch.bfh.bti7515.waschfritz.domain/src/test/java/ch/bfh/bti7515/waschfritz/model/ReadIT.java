package ch.bfh.bti7515.waschfritz.model;

import org.junit.Test;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by adrian on 04.11.14.
 */
public class ReadIT {

    @Test
    public void test() {

        EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.bti7515.waschfritz.domain").createEntityManager();

        Query query = em.createQuery("select r from Reservation r");

        List<Reservation> reservations = query.getResultList();

        System.out.println(reservations.get(0).getTenant().getName());

    }
}
