package by.javaguru;

import by.javaguru.model.Company;
import by.javaguru.model.User;
import by.javaguru.service.CompanyService;
import by.javaguru.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

public class SpringRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");

        UserService userService = context.getBean(UserService.class);
        CompanyService companyService = context.getBean(CompanyService.class);

        Optional<User> user = userService.findUserById(1L);
        Optional<Company> company = companyService.findCompanyById(1L);
        System.out.println(user.get());
        System.out.println(company.get());
    }
}
