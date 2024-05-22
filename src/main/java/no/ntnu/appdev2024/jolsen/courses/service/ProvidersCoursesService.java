package no.ntnu.appdev2024.jolsen.courses.service;


import no.ntnu.appdev2024.jolsen.courses.model.ProvidersCourses;
import no.ntnu.appdev2024.jolsen.courses.repository.ProvidersCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvidersCoursesService {


    @Autowired
    ProvidersCoursesRepository providersCoursesRepository;
    public void saveProvidersCourses(ProvidersCourses providersCourses) {
        this.providersCoursesRepository.save(providersCourses);
    }
}
