package source.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import source.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
		
	List<User> findUserByEmail (String email);
}
