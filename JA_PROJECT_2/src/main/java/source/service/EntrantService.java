package source.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.dao.EntrantRepository;
import source.domain.Entrant;

@Service
public class EntrantService {

	@Autowired
	private EntrantRepository entrantRepository;

	public Entrant save(Entrant entrant) {
		return entrantRepository.save(entrant);
	}

	public void updateEntrant(boolean received, Integer id) {
		entrantRepository.updateEntrant(received, id);
	}
	
	public void delete(Entrant entrant){
		entrantRepository.delete(entrant);
    }

	public List<Entrant> getAllEntrants() {
		return entrantRepository.findAll();
	}
	
}
