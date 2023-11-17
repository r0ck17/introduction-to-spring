package by.javaguru.service;

import by.javaguru.listener.AccessType;
import by.javaguru.listener.EntityEvent;
import by.javaguru.model.Company;
import by.javaguru.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public CompanyService(CompanyRepository companyRepository,
                          ApplicationEventPublisher applicationEventPublisher) {
        this.companyRepository = companyRepository;
        this.eventPublisher = applicationEventPublisher;
    }

    public Optional<Company> findCompanyById(Long id) {
        eventPublisher.publishEvent(new EntityEvent(Optional.empty(), AccessType.READ));
        Optional<Company> companyById = companyRepository.findCompanyById(id);
        companyById.ifPresent(entity -> eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ, true)));

        return companyById;
    }
}
