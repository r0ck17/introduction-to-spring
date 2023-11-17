package by.javaguru.service;

import by.javaguru.model.Company;
import by.javaguru.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> findCompanyById(Long id) {
        return companyRepository.findCompanyById(id);
    }
}
