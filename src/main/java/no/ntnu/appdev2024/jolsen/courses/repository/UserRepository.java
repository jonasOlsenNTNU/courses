package no.ntnu.appdev2024.jolsen.courses.repository;

import no.ntnu.appdev2024.jolsen.courses.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
