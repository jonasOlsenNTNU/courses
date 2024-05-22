package no.ntnu.appdev2024.jolsen.courses.service;


import no.ntnu.appdev2024.jolsen.courses.model.CourseSessionTime;
import no.ntnu.appdev2024.jolsen.courses.repository.CourseSessionTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSessionTimeService {

    @Autowired
    CourseSessionTimeRepository courseSessionTimeRepository;

    public void saveCourseSessionTime(CourseSessionTime courseSessionTime) {
        this.courseSessionTimeRepository.save(courseSessionTime);
    }
}
