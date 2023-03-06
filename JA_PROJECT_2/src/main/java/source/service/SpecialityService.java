package source.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.dao.SpecialityRepository;
import source.domain.Speciality;

@Service
public class SpecialityService {
	Logger logger = LoggerFactory.getLogger(SpecialityService.class);
	@Autowired
	private SpecialityRepository specialityRepository;

	public Speciality save(Speciality speciality) {
		logger.debug("Save a new speciality " + speciality);
		return specialityRepository.save(speciality);
	}
	
	public Optional<Speciality> findById(Integer id){
		logger.debug("Get a speciality by it`s id");
		return specialityRepository.findById(id);
	}

	public List<Speciality> getAllSpecialities() {
		logger.debug("Get all specialities");
		return specialityRepository.findAll();
	}
	
}
