package no.ntnu.appdev2024.jolsen.courses.controller;


import no.ntnu.appdev2024.jolsen.courses.model.Category;
import no.ntnu.appdev2024.jolsen.courses.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/categories")
@RestController
@CrossOrigin
public class CategoriesRestApiController {

    @Autowired
    CategoryService categoryService;


    @PostMapping("/addcategory")
    public ResponseEntity<String> add(@RequestBody Category category) {
        ResponseEntity<String> response;

        System.out.println(category.toString());

        try {
            addCategoryToDatabase(category);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    private void addCategoryToDatabase(Category category) throws IllegalArgumentException {
        if (!category.isValid()) {
            throw new IllegalArgumentException("Invalid Category.");
        }

        categoryService.saveCategory(category);

    }


}
