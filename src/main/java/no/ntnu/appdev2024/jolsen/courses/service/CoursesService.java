package no.ntnu.appdev2024.jolsen.courses.service;

import no.ntnu.appdev2024.jolsen.courses.model.Course;
import no.ntnu.appdev2024.jolsen.courses.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

    public Iterable<Course> getAll() {
        return coursesRepository.findAll();
    }

    public Course findCourseById(Integer id) {
        Optional<Course> course = coursesRepository.findById(id);
        return course.orElse(null);
    }

    public void saveCourse(Course course) {
        coursesRepository.save(course);
    }

}
