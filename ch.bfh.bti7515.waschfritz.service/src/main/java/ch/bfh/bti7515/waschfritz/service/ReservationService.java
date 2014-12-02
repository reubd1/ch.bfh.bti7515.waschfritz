package ch.bfh.bti7515.waschfritz.service;

import ch.bfh.bti7515.waschfritz.service.dto.ReservationDTO;

import javax.inject.Named;
import java.lang.Long;
import java.util.Collection;

/**
 * Created by adrian on 02.12.14.
 */

public interface ReservationService {

    public ReservationDTO create(ReservationDTO reservation);

    public  ReservationDTO read(Long id);

    public Collection<ReservationDTO>list();

    public  ReservationDTO update(ReservationDTO reservation);

    public  void delete(ReservationDTO reservation);

}
