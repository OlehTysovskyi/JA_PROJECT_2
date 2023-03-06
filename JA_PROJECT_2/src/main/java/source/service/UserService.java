package source.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import source.dao.UserRepository;
import source.domain.User;
import source.domain.UserRole;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bCryptoPasswordEncoder;
	
	public void save(User user) {
		logger.debug("Save a new user " + user);
		user.setPassword(bCryptoPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		logger.debug("Get a user by his email");
        return userRepository.findUserByEmail(email).get();
    }
	
}
