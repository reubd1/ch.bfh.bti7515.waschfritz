package ch.bfh.bti7515.waschfritz.rest.controller;


import ch.bfh.bti7515.waschfritz.service.ReservationService;
import ch.bfh.bti7515.waschfritz.service.dto.ReservationDTO;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by adrian on 07.12.14.
 */

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Inject
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.POST)
    public ReservationDTO createMachineReservation(@RequestBody ReservationDTO reservationDTODTO) {
        ReservationDTO createdReservation = reservationService.create(reservationDTODTO);
        System.out.println("Created Reservation with ID: " + createdReservation.getId());
        return createdReservation;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ReservationDTO> getReservations() {
        Collection<ReservationDTO> allReservations = reservationService.list();
        System.out.println(String.format("Returning %d reservations", allReservations.size()));
        return allReservations;

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ReservationDTO getReservationById(@PathVariable long id) {
        System.out.println("Getting Reservation with id " + id);
        return reservationService.read(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ReservationDTO updateReservation(@RequestBody ReservationDTO reservationDTO) {
        System.out.println("Update Reservation with id " + reservationDTO.getId());
        return reservationService.update(reservationDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteReservation(@PathVariable long id) {
        System.out.println("Delete Reservation with id " + id);
        ReservationDTO reservationDTO = reservationService.read(id);
        reservationService.delete(reservationDTO);
    }
}
