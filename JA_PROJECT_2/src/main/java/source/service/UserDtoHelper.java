package source.service;

import org.springframework.web.multipart.MultipartFile;
import source.domain.User;
import source.domain.UserRole;

import java.io.IOException;
import java.util.Base64;

public class UserDtoHelper {
    public static User createUser(MultipartFile file, String email, String firstname, String lastname, String password) throws IOException {
        User user=new User();
        user.setEmail(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPassword(password);
        user.setRole(UserRole.ROLE_USER);
        user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return user;
    }

}
