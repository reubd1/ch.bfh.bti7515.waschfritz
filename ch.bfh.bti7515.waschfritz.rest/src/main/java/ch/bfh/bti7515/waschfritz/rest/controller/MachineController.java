package ch.bfh.bti7515.waschfritz.rest.controller;


import ch.bfh.bti7515.waschfritz.service.MachineService;
import ch.bfh.bti7515.waschfritz.service.dto.MachineDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public MachineDTO createMachine(MachineDTO machineDTO) {
        MachineDTO createdMachine = machineService.create(machineDTO);
        return createdMachine;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<MachineDTO> getMachines() {
        return machineService.list();
    }
}
