package no.ntnu.appdev2024.jolsen.courses.repository;

import no.ntnu.appdev2024.jolsen.courses.model.CourseSessionTime;
import org.springframework.data.repository.CrudRepository;

public interface CourseSessionTimeRepository extends CrudRepository<CourseSessionTime, Integer> {
}
