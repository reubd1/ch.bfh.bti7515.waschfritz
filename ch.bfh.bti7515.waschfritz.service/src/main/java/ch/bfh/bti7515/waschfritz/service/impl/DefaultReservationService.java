package ch.bfh.bti7515.waschfritz.service.impl;

import ch.bfh.bti7515.waschfritz.model.Reservation;
import ch.bfh.bti7515.waschfritz.repository.ReservationRepository;
import ch.bfh.bti7515.waschfritz.service.ReservationService;
import ch.bfh.bti7515.waschfritz.service.dto.ReservationDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.ui.ModelMap;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by reubid on 02.12.14.
 */
@Named
public class DefaultReservationService implements ReservationService {

    @Inject
    private ReservationRepository reservationRepository;

    private final ModelMapper mapper = new ModelMapper();


    @Override
    public ReservationDTO create(ReservationDTO reservationDto) {
        Reservation reservation = mapper.map(reservationDto, Reservation.class);
        Reservation persistedReservation = reservationRepository.save(reservation);
        return mapper.map(persistedReservation, ReservationDTO.class);
    }

    @Override
    public ReservationDTO read(Long id) {
        Reservation reservation = reservationRepository.findOne(id);
        if(reservation==null)return null;
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

        Reservation reservation= mapper.map(reservationDto, Reservation.class);
        Reservation updatedReservation = reservationRepository.save(reservation);
        return mapper.map(updatedReservation, ReservationDTO.class);
    }

    @Override
    public void delete(ReservationDTO reservationDto) {
        Reservation reservation = reservationRepository.findOne(reservationDto.getId());
        reservationRepository.delete(reservation);

    }
}
