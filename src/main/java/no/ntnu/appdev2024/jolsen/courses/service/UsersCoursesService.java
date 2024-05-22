package no.ntnu.appdev2024.jolsen.courses.service;


import no.ntnu.appdev2024.jolsen.courses.model.UsersCourses;
import no.ntnu.appdev2024.jolsen.courses.repository.UsersCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersCoursesService {

    @Autowired
    UsersCoursesRepository usersCoursesRepository;

    public void saveUsersCourses(UsersCourses usersCourses) {
        this.usersCoursesRepository.save(usersCourses);
    }
}
