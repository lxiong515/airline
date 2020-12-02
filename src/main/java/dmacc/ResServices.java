package dmacc;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dmacc.beans.CustomerReservation;
import dmacc.repository.CustomerReservationRepository;

@Service
@Transactional
public class ResServices {
	
	@Autowired
	CustomerReservationRepository crRepo;
	
	public List<CustomerReservation> listAll(){
		return crRepo.findAll();
	}

}
