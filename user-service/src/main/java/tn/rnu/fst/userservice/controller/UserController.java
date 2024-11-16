package tn.rnu.fst.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import tn.rnu.fst.userservice.entity.User;
import tn.rnu.fst.userservice.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Endpoint pour récupérer tous les utilisateurs.
     * Méthode: GET
     * URL: http://localhost:8082/users
     */
    @GetMapping
    @CircuitBreaker(name = "userService")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint pour récupérer un utilisateur par son ID.
     * Méthode: GET
     * URL: http://localhost:8082/users/{id}
     */
    @GetMapping("/{id}")
    @CircuitBreaker(name = "userService")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Endpoint pour créer un nouvel utilisateur.
     * Méthode: POST
     * URL: http://localhost:8082/users
     */
    @PostMapping
    @CircuitBreaker(name = "userService")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Endpoint pour mettre à jour un utilisateur existant.
     * Méthode: PUT
     * URL: http://localhost:8082/users/{id}
     */
    @PutMapping("/{id}")
    @CircuitBreaker(name = "userService")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Endpoint pour supprimer un utilisateur par son ID.
     * Méthode: DELETE
     * URL: http://localhost:8082/users/{id}
     */
    @DeleteMapping("/{id}")
    @CircuitBreaker(name = "userService")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
