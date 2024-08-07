package anzolin.marcelo.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements  UserService {

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        User userExist =  userRepository.findByUserName(user.getUserName());
            if(userExist != null){
                throw new Error("Usuário já existe");
            }
            user.setPassword(passwordEncoder().encode((user.getPassword())));
            User userCreated = userRepository.save(user);
            return userCreated;
    }
}
