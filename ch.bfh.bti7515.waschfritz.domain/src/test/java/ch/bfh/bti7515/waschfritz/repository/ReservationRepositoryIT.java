package ch.bfh.bti7515.waschfritz.repository;

import ch.bfh.bti7515.waschfritz.model.Machine;
import ch.bfh.bti7515.waschfritz.model.Reservation;
import ch.bfh.bti7515.waschfritz.model.Tenant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by adrian on 18.11.14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class ReservationRepositoryIT {
    @Inject
    private ReservationRepository reservationRepository;

    @Test
    public void test() {

        //Create
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

        reservationRepository.save(reservation);

        // Read
        Reservation readReservation = reservationRepository.findOne(reservation.getId());
        assertEquals("Super Machine", readReservation.getMachine().getName());

        // Update
        readReservation.getMachine().setName("New Name");
        readReservation = reservationRepository.save(readReservation);
        Reservation updatedReservation = reservationRepository.findOne(readReservation.getId());
        assertTrue(readReservation.getStartDate().equals(updatedReservation.getStartDate()));

        // Delete
        reservationRepository.delete(updatedReservation);
        Reservation deletedReservation = reservationRepository.findOne(updatedReservation.getId());
        assertNull(deletedReservation);

    }
}
