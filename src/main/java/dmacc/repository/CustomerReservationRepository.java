package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.CustomerReservation;
@Repository
public interface CustomerReservationRepository  extends JpaRepository<CustomerReservation, Long>   {

	List<CustomerReservation> findByFlight_Id(long flightId);
}
