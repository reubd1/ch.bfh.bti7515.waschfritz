package ch.bfh.bti7515.waschfritz.service;

import ch.bfh.bti7515.waschfritz.service.dto.ReservationDTO;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by reubid on 02.12.14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class ReservationServiceIT {


        @Inject
        private ReservationService reservationService;

        @Test
        public void test() {

            //create
            ReservationDTO newReservation = new ReservationDTO();
            newReservation.setEndDate(new Date());
            newReservation = reservationService.create(newReservation);

            //read
            ReservationDTO readReservation = reservationService.read(newReservation.getId());
            Assert.assertTrue(newReservation.getEndDate().equals(readReservation.getEndDate()));

            //update
            readReservation.setEndDate(new Date());
            readReservation = reservationService.update(readReservation);
            ReservationDTO updatedReservation = reservationService.read(readReservation.getId());
            Assert.assertTrue(readReservation.getEndDate().equals(updatedReservation.getEndDate()));

            //delete
            reservationService.delete(updatedReservation);
            ReservationDTO deleteReservation = reservationService.read(readReservation.getId());
            Assert.assertNull(deleteReservation);

        }



}
