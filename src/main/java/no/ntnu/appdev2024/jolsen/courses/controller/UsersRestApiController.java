package no.ntnu.appdev2024.jolsen.courses.controller;

import no.ntnu.appdev2024.jolsen.courses.model.User;
import no.ntnu.appdev2024.jolsen.courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@RestController
public class UsersRestApiController {

    @Autowired
    UserService userService;


    @PostMapping("/users")
    public ResponseEntity<String> add(@RequestBody User user) {
        ResponseEntity<String> response;

        try {
            addUserToDatabase(user);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    private void addUserToDatabase(User user) throws IllegalArgumentException {
        if (!user.isValid()) {
            throw new IllegalArgumentException("Invalid User.");
        }

        userService.saveUser(user);

    }

}
