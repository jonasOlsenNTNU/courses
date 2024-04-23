package no.ntnu.appdev2024.jolsen.courses.repository;

import no.ntnu.appdev2024.jolsen.courses.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
