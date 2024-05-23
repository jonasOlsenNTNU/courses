package no.ntnu.appdev2024.jolsen.courses.repository;

import no.ntnu.appdev2024.jolsen.courses.model.ProvidersCourses;
import org.springframework.data.repository.CrudRepository;


public interface ProvidersCoursesRepository extends CrudRepository<ProvidersCourses, Integer> {

    Iterable<ProvidersCourses> findByCid(Integer id);
}
