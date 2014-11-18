package ch.bfh.bti7515.waschfritz.repository;

import ch.bfh.bti7515.waschfritz.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adrian on 18.11.14.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
