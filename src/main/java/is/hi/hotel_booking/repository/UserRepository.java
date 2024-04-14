package is.hi.hotel_booking.repository;

import is.hi.hotel_booking.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO Users(email, name) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.executeUpdate();
        }
    }

    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT email, name FROM Users";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                users.add(new User(email, name));
            }
        }
        return users;
    }

    public User getUserByEmail(String email) {
        User user = null;

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Users WHERE email = ?")) {
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                user = new User(email, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
