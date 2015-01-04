package ch.bfh.bti7515.waschfritz.service.impl;

import ch.bfh.bti7515.waschfritz.model.Reservation;
import ch.bfh.bti7515.waschfritz.repository.MachineRepository;
import ch.bfh.bti7515.waschfritz.repository.ReservationRepository;
import ch.bfh.bti7515.waschfritz.repository.TenantRepository;
import ch.bfh.bti7515.waschfritz.service.ReservationService;
import ch.bfh.bti7515.waschfritz.service.dto.ReservationDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by reubid on 02.12.14.
 */
@Named
public class DefaultReservationService implements ReservationService {

    private final ModelMapper mapper = new ModelMapper();
    @Inject
    private ReservationRepository reservationRepository;
    @Inject
    private MachineRepository machineRepository;
    @Inject
    private TenantRepository tenantRepository;

    @Override
    public ReservationDTO create(ReservationDTO reservationDto) {
        Reservation reservation = mapper.map(reservationDto, Reservation.class);

        reservation.setMachine(machineRepository.findOne(reservationDto.getMachine().getId()));
        reservation.setTenant(tenantRepository.findOne(reservationDto.getTenant().getId()));

        Reservation persistedReservation = reservationRepository.save(reservation);
        return mapper.map(persistedReservation, ReservationDTO.class);
    }

    @Override
    public ReservationDTO read(Long id) {
        Reservation reservation = reservationRepository.findOne(id);
        if (reservation == null) return null;
        return mapper.map(reservation, ReservationDTO.class);
    }

    @Override
    public Collection<ReservationDTO> list() {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        Type listType = new TypeToken<Collection<ReservationDTO>>() {
        }.getType();
        return mapper.map(reservations, listType);
    }

    @Override
    public ReservationDTO update(ReservationDTO reservationDto) {

        Reservation reservation = mapper.map(reservationDto, Reservation.class);
        Reservation updatedReservation = reservationRepository.save(reservation);
        return mapper.map(updatedReservation, ReservationDTO.class);
    }

    @Override
    public void delete(ReservationDTO reservationDto) {
        Reservation reservation = reservationRepository.findOne(reservationDto.getId());
        reservationRepository.delete(reservation);

    }
}
