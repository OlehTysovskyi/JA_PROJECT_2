package source.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.dao.EntrantRepository;
import source.domain.Entrant;

@Service
public class EntrantService {
	Logger logger = LoggerFactory.getLogger(EntrantService.class);
	@Autowired
	private EntrantRepository entrantRepository;

	public Entrant save(Entrant entrant) {
		logger.debug("Save a new entrant " + entrant);
		return entrantRepository.save(entrant);
	}

	public void updateEntrant(boolean received, Integer id) {
		logger.debug("Update entrant`s id");
		entrantRepository.updateEntrant(received, id);
	}
	
	public void delete(Entrant entrant){
		logger.debug("Delete entrant");
		entrantRepository.delete(entrant);
    }

	public List<Entrant> getAllEntrants() {
		logger.debug("Get all entrants");
		return entrantRepository.findAll();
	}
	
}
