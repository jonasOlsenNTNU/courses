package no.ntnu.appdev2024.jolsen.courses.controller;


import no.ntnu.appdev2024.jolsen.courses.model.Course;
import no.ntnu.appdev2024.jolsen.courses.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/courses")
@RestController
public class CoursesRestApiController {

    @Autowired
    CoursesService coursesService;

    @GetMapping("/all")
    public Iterable<Course> getAllCourses() {
        return coursesService.getAll();
    }

    @PostMapping("/addcourses")
    public ResponseEntity<String> add(@RequestBody Course course) {
        ResponseEntity<String> response;

        try {
            addCourseToDatabase(course);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    private void addCourseToDatabase(Course course) throws IllegalArgumentException {
        if (!course.isValid()) {
            throw new IllegalArgumentException("Invalid course.");
        }

        coursesService.saveCourse(course);

    }

    @RequestMapping("/coursedetails")
    public ResponseEntity<Course> getCourseByTitle(@RequestParam Integer id) {
        ResponseEntity<Course> response;
        Course course = coursesService.findCourseById(id);
        if(course != null) {
            response = new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
