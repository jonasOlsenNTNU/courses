package no.ntnu.appdev2024.jolsen.courses.controller;

import no.ntnu.appdev2024.jolsen.courses.model.Provider;
import no.ntnu.appdev2024.jolsen.courses.service.ProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/provider")
@RestController
public class ProviderRestApiController {

    @Autowired
    ProvidersService providersService;


    @PostMapping("/provider")
    public ResponseEntity<String> add(@RequestBody Provider provider) {
        ResponseEntity<String> response;

        try {
            addProviderToDatabase(provider);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    private void addProviderToDatabase(Provider provider) throws IllegalArgumentException {
        if (!provider.isValid()) {
            throw new IllegalArgumentException("Invalid Provider.");
        }

        providersService.saveProvider(provider);

    }

}
