package no.ntnu.appdev2024.jolsen.courses.service;


import no.ntnu.appdev2024.jolsen.courses.model.Category;
import no.ntnu.appdev2024.jolsen.courses.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
