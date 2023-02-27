package source.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import source.domain.Speciality;
import source.domain.User;

public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
	
	List<User> findUserBySpecialityNumber (Integer specialityNumber);
	
}
