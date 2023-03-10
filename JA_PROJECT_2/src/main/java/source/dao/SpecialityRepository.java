package source.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import source.domain.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
		
}
