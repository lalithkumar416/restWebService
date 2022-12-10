package com.learning.restWebService.users;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class UsersResource {
    UsersDaoLayer usersDaoLayer;

    @GetMapping("/users")
    public List<UserModel> retrieveAllUsers() {
        return usersDaoLayer.findAll();
    }

    @GetMapping("/users/{userId}")
    public UserModel retrieveSingleUser(@PathVariable int userId) {
        UserModel user = usersDaoLayer.findOne(userId);

        if (user == null) {
            throw new UserException("User not found {id} : " + userId);
        }

        return user;
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        usersDaoLayer.deleteById(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel user) {
        UserModel savedUser = usersDaoLayer.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
