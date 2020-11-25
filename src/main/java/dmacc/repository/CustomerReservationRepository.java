package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.CustomerReservation;
@Repository
public interface CustomerReservationRepository  extends JpaRepository<CustomerReservation, Long>   {

}
