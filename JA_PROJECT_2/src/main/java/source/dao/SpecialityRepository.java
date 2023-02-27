package source.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import source.domain.Speciality;
import source.domain.User;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
	
	List<User> findUserBySpecialityNumber (Integer specialityNumber);
	
}
