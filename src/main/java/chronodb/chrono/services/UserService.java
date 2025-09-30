package chronodb.chrono.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import chronodb.chrono.models.User;
import chronodb.chrono.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public String registerUser(String name,String email,String userName,String pass,String role)
    {
        if(userRepository.existsByEmail(email) && userRepository.existsByUserName(userName)){
            return "User already registered";
        }

        String password=passwordEncoder.encode(pass);
        User user=new User(name,email,userName,password,role.toUpperCase());
        userRepository.save(user);
        return "User registered successfully";

    }

    public String loginUser(String userName,String pass)
    {
        User user=userRepository.findByUserName(userName).orElse(null);

        if(user==null)
        {
            return "UserName is invalid!";
        }
        if(!passwordEncoder.matches(pass, user.getPassword()))
        {
            return "Invalid password!";
        }

        return "User loged in successfully!";
    }

 







}
