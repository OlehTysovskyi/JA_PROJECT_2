package source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import source.dao.UserRepository;
import source.domain.User;
import source.domain.UserRole;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bCryptoPasswordEncoder;
	
	public void save(User user) {
		user.setPassword(bCryptoPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}
	
	public User findByEmail(String email) {
        return userRepository.findUserByEmail(email).get();
    }
	
}
