package by.javaguru.repository;

import by.javaguru.model.Company;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class CompanyRepository {

    private final Connection connection;

    private final String FIND_COMPANY_BY_ID_SQL = """
            SELECT *
            FROM company
            WHERE ID = ?
            """;

    public CompanyRepository(Connection connection) {
        this.connection = connection;
    }

    public Optional<Company> findCompanyById(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_COMPANY_BY_ID_SQL)) {
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            Optional<Company> companyById = Optional.empty();

            if (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getLong(1));
                company.setName(resultSet.getString(2));
                companyById = Optional.of(company);
            }

            return companyById;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
