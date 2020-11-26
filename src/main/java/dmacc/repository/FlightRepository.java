package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>   {
	
}
