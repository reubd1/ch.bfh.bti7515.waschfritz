package ch.bfh.bti7515.waschfritz.model;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by adrian on 11.11.14.
 */
public class DeleteIT {

    @Test
    public void test() {
        EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.bti7515.waschfritz.domain").createEntityManager();
        Query query = em.createQuery("select r from Reservation r");

        List<Reservation> reservations = query.getResultList();

        Reservation res = reservations.get(0);

        assertEquals(1, reservations.size());

        em.getTransaction().begin();
        em.remove(res);
        em.getTransaction().commit();
    }
}
