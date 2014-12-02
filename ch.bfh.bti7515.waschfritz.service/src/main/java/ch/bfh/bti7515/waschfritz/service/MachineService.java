package ch.bfh.bti7515.waschfritz.service;

import ch.bfh.bti7515.waschfritz.service.dto.MachineDTO;

import java.util.Collection;

/**
 * Created by adrian on 02.12.14.
 */
public interface MachineService {

    public MachineDTO create(MachineDTO machineDTO);

    public MachineDTO read(long id);

    public Collection<MachineDTO> list();

    public MachineDTO update(MachineDTO machine);

    public void delete(MachineDTO machine);


}
