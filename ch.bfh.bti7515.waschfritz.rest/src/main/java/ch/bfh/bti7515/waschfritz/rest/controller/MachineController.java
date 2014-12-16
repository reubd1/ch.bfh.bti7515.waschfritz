package ch.bfh.bti7515.waschfritz.rest.controller;


import ch.bfh.bti7515.waschfritz.service.MachineService;
import ch.bfh.bti7515.waschfritz.service.dto.MachineDTO;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by adrian on 07.12.14.
 */

@RestController
@RequestMapping("/machines")
public class MachineController {

    @Inject
    private MachineService machineService;

    @RequestMapping(method = RequestMethod.POST)
    public MachineDTO createMachine(@RequestBody MachineDTO reservationDTODTO) {
        MachineDTO createdMachine = machineService.create(reservationDTODTO);
        System.out.println("Created Machine with ID: " + createdMachine.getId());
        return createdMachine;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<MachineDTO> getMachines() {
        Collection<MachineDTO> allMachines = machineService.list();
        System.out.println(String.format("Returning %d machines", allMachines.size()));
        return allMachines;

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public MachineDTO getMachineById(@PathVariable long id) {
        System.out.println("Getting Machine with id " + id);
        return machineService.read(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public MachineDTO updateMachine(@RequestBody MachineDTO reservationDTODTO) {
        System.out.println("Update Machine with id " + reservationDTODTO.getId());
        return machineService.update(reservationDTODTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteMachine(@PathVariable long id) {
        System.out.println("Delete Machine with id " + id);
        MachineDTO reservationDTODTO = machineService.read(id);
        machineService.delete(reservationDTODTO);
    }
}
