package ch.bfh.bti7515.waschfritz.repository;

import ch.bfh.bti7515.waschfritz.model.Machine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by adrian on 18.11.14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class MachineRepositoryIT {
    @Inject
    private MachineRepository machineRepository;

    @Test
    public void test() {

        //Create
        Machine machine = new Machine();
        machine.setName("Machine 1");
        machine.setType("bla");
        machineRepository.save(machine);

        // Read
        Machine readMachine = machineRepository.findOne(machine.getId());
        assertEquals("Machine 1", readMachine.getName());
        assertEquals("bla", readMachine.getType());

        // Update
        readMachine.setName("New Name");
        readMachine = machineRepository.save(readMachine);
        Machine updatedMachine = machineRepository.findOne(readMachine.getId());
        assertEquals("New Name", updatedMachine.getName());

        // Delete
        machineRepository.delete(updatedMachine);
        Machine deletedMachine = machineRepository.findOne(updatedMachine.getId());
        assertNull(deletedMachine);

    }
}
