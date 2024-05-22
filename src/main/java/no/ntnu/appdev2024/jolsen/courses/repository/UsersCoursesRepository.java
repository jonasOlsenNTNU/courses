package no.ntnu.appdev2024.jolsen.courses.repository;

import no.ntnu.appdev2024.jolsen.courses.model.UsersCourses;
import org.springframework.data.repository.CrudRepository;

public interface UsersCoursesRepository extends CrudRepository<UsersCourses, Integer> {
}
