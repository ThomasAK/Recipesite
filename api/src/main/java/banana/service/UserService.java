package banana.service;

import banana.AppProperties;
import banana.entity.User;
import banana.model.UserSignIn;
import banana.model.UserSignUp;
import banana.repository.UserRepository;
import banana.security.JwtTokenProvider;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;

@Service
public class UserService {
    private final AppProperties appProperties;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserService(AppProperties appProperties, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.appProperties = appProperties;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public User signUp(UserSignUp userSignUp) {
        User user = new User();
        user.setEmail(userSignUp.getEmail());
        user.setName(userSignUp.getName());
        user.setPassword(hashPassword(userSignUp.getPassword()));

        return userRepository.save(user);
    }

    private String hashPassword(String password) {
        return Hashing.sha256()
                .hashString(password+appProperties.getPasswordSalt(), StandardCharsets.UTF_8)
                .toString();
    }

    public String signIn(UserSignIn userSignIn){
        User user = userRepository.findByEmail(userSignIn.getEmail());
        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        String hashedPassword = hashPassword(userSignIn.getPassword());
        if(!hashedPassword.equals(user.getPassword())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return jwtTokenProvider.createToken(user.getId());
    }
}
