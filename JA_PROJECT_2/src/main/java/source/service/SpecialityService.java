package source.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.dao.SpecialityRepository;
import source.domain.Speciality;

@Service
public class SpecialityService {

	@Autowired
	private SpecialityRepository specialityRepository;

	public Speciality save(Speciality speciality) {
		return specialityRepository.save(speciality);
	}
	
	public Optional<Speciality> findById(Integer id){
	       return specialityRepository.findById(id);
	}

	public List<Speciality> getAllSpecialities() {
		return specialityRepository.findAll();
	}
	
}
