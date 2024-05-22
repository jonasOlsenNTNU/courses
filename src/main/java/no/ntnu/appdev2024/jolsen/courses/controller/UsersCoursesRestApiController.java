package no.ntnu.appdev2024.jolsen.courses.controller;

import no.ntnu.appdev2024.jolsen.courses.model.UsersCourses;
import no.ntnu.appdev2024.jolsen.courses.service.UsersCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/userscourses")
@RestController
public class UsersCoursesRestApiController {

    @Autowired
    UsersCoursesService usersCoursesService;


    @PostMapping("/adduserscourses")
    public ResponseEntity<String> add(@RequestBody UsersCourses usersCourses) {
        ResponseEntity<String> response;

        try {
            addUsersCoursesToDatabase(usersCourses);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    private void addUsersCoursesToDatabase(UsersCourses usersCourses) throws IllegalArgumentException {
        if (!usersCourses.isValid()) {
            throw new IllegalArgumentException("Invalid UsersCourses.");
        }

        usersCoursesService.saveUsersCourses(usersCourses);

    }

}
