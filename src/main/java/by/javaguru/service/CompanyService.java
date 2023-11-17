package by.javaguru.service;

import by.javaguru.model.Company;
import by.javaguru.repository.CompanyRepository;

import java.util.Optional;

public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> findCompanyById(Long id) {
        return companyRepository.findCompanyById(id);
    }
}
