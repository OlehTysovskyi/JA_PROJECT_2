package source.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import source.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
		
	Optional<User> findUserByEmail (String email);
	
}
