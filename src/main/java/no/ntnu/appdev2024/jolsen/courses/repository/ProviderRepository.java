package no.ntnu.appdev2024.jolsen.courses.repository;

import no.ntnu.appdev2024.jolsen.courses.model.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Integer> {
}
