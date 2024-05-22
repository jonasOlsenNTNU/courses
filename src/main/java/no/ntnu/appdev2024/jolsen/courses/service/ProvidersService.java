package no.ntnu.appdev2024.jolsen.courses.service;

import no.ntnu.appdev2024.jolsen.courses.model.Provider;
import no.ntnu.appdev2024.jolsen.courses.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvidersService {

    @Autowired
    ProviderRepository providerRepository;

    public void saveProvider(Provider provider) {
        this.providerRepository.save(provider);
    }
}
