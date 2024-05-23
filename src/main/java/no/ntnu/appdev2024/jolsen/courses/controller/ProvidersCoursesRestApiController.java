package no.ntnu.appdev2024.jolsen.courses.controller;


import no.ntnu.appdev2024.jolsen.courses.model.ProvidersCourses;
import no.ntnu.appdev2024.jolsen.courses.service.ProvidersCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/providerscourses")
@RestController
public class ProvidersCoursesRestApiController {

    @Autowired
    ProvidersCoursesService providersCoursesService;



    @PostMapping("/addproviderscourses")
    public ResponseEntity<String> add(@RequestBody ProvidersCourses providersCourses) {
        ResponseEntity<String> response;

        try {
            addProvidersCoursesToDatabase(providersCourses);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    private void addProvidersCoursesToDatabase(ProvidersCourses providersCourses) throws IllegalArgumentException {
        if (!providersCourses.isValid()) {
            throw new IllegalArgumentException("Invalid ProvidersCourses.");
        }

        providersCoursesService.saveProvidersCourses(providersCourses);

    }

    @RequestMapping
    public ResponseEntity<Iterable<ProvidersCourses>> getProvidersCoursesById(@RequestParam Integer courseId) {
        ResponseEntity<Iterable<ProvidersCourses>> response;
        Iterable<ProvidersCourses> providersCourses = providersCoursesService.findProvidersCoursesByCourseId(courseId);
        if(providersCourses != null) {
            response = new ResponseEntity<>(providersCourses, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
