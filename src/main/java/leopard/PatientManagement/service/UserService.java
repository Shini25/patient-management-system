package leopard.PatientManagement.service;

import leopard.PatientManagement.model.User_account;
import leopard.PatientManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User_account> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User_account> getUserByUsername(String username) {
        return userRepository.findById(username);
    }

    public User_account saveUser(User_account user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
}