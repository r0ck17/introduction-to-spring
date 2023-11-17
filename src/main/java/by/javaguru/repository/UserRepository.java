package by.javaguru.repository;

import by.javaguru.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {

    private final Connection connection;
    private final String FIND_USER_BY_ID_SQL = """
            SELECT *
            FROM custom_user
            WHERE ID = ?
            """;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public Optional<User> findUserById(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID_SQL)) {
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            Optional<User> userById = Optional.empty();

            if (resultSet.next()) {
                User company = new User();
                company.setId(resultSet.getLong(1));
                company.setName(resultSet.getString(2));
                userById = Optional.of(company);
            }

            return userById;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
