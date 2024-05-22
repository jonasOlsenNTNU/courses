package no.ntnu.appdev2024.jolsen.courses.service;

import no.ntnu.appdev2024.jolsen.courses.model.User;
import no.ntnu.appdev2024.jolsen.courses.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}
