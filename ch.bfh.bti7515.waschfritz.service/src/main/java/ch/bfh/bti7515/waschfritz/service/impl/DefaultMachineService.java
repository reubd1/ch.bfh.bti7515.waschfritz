package ch.bfh.bti7515.waschfritz.service.impl;

import ch.bfh.bti7515.waschfritz.model.Machine;
import ch.bfh.bti7515.waschfritz.repository.MachineRepository;
import ch.bfh.bti7515.waschfritz.service.MachineService;
import ch.bfh.bti7515.waschfritz.service.dto.MachineDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by adrian on 02.12.14.
 */

@Named
public class DefaultMachineService implements MachineService {

    private final ModelMapper mapper = new ModelMapper();
    @Inject
    private MachineRepository machineRepository;

    @Override
    public MachineDTO create(MachineDTO machineDTO) {
        Machine machine = mapper.map(machineDTO, Machine.class);
        Machine savedMachine = machineRepository.save(machine);
        return mapper.map(savedMachine, MachineDTO.class);
    }

    @Override
    public MachineDTO read(long id) {
        Machine machine = machineRepository.findOne(id);
        if (machine == null) {
            return null;
        }
        return mapper.map(machine, MachineDTO.class);
    }

    @Override
    public Collection<MachineDTO> list() {
        Iterable<Machine> machines = machineRepository.findAll();
        Type listType = new TypeToken<Collection<MachineDTO>>() {
        }.getType();
        return mapper.map(machines, listType);
    }

    @Override
    public MachineDTO update(MachineDTO machineDTO) {
        Machine machine = mapper.map(machineDTO, Machine.class);
        Machine savedMachine = machineRepository.save(machine);
        return mapper.map(savedMachine, MachineDTO.class);
    }

    @Override
    public void delete(MachineDTO machineDTO) {
        Machine machine = machineRepository.findOne(machineDTO.getId());
        machineRepository.delete(machine);

    }
}
