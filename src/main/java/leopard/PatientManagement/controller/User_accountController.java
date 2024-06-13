package leopard.PatientManagement.controller;

import leopard.PatientManagement.model.User_account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import leopard.PatientManagement.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class User_accountController {

    private final UserService userService;

    @Autowired
    public User_accountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User_account>> getAllUsers() {
        List<User_account> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User_account> getUserByUsername(@PathVariable String username) {
        Optional<User_account> user = userService.getUserByUsername(username);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/adduser")
    public ResponseEntity<User_account> addUser(@RequestBody User_account user) {
        User_account savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User_account> updateUser(@PathVariable String username, @RequestBody User_account user) {
        if (!userService.getUserByUsername(username).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        user.setUsername(username); // Ensure the username is set correctly
        User_account updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        if (!userService.getUserByUsername(username).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
