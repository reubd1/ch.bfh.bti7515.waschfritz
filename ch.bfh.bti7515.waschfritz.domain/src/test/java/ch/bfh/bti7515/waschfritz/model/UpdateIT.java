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
public class UpdateIT {

    @Test
    public void test() {
        EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.bti7515.waschfritz.domain").createEntityManager();

        Query query = em.createQuery("select m from Machine m");

        List<Machine> machineList = query.getResultList();
        Machine machine = machineList.get(0);

        System.out.println(machine.getName());

        em.getTransaction().begin();
        machine.setName("New Machine name");
        em.getTransaction().commit();

        System.out.println(machine.getName());

        assertEquals("New Machine name", machine.getName());
    }
}
