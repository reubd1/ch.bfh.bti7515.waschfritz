package ch.bfh.bti7515.waschfritz.service;

import ch.bfh.bti7515.waschfritz.service.dto.MachineDTO;
import ch.bfh.bti7515.waschfritz.service.dto.ReservationDTO;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by adrian on 02.12.14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class MachineServiceIT {

    @Inject
    private MachineService machineService;

    @Test
    public void test() {
        MachineDTO machineDTO = new MachineDTO();
        machineDTO.setName("Mach1");
        machineDTO = machineService.create(machineDTO);

        MachineDTO readMachine = machineService.read(machineDTO.getId());
        assertEquals("Mach1", readMachine.getName());

        Collection<MachineDTO> machineDTOs = machineService.list();
        assertFalse(machineDTOs.isEmpty());

        readMachine.setName("New Name");
        readMachine = machineService.update(readMachine);
        MachineDTO updatedMachine = machineService.read(readMachine.getId());
        assertEquals("New Name", readMachine.getName());

        machineService.delete(updatedMachine);
        MachineDTO deletedMachine = machineService.read(readMachine.getId());
        assertNull(deletedMachine);


    }


    /**
     * Created by reubid on 02.12.14.
     */

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("/serviceContext.xml")
    public static class ReservationServiceIT {


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
                assertNull(deleteReservation);

            }



    }
}
