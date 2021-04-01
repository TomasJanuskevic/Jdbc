package example4;

import example2.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String SELECT = "SELECT id, name, email, country FROM user WHERE name = ?;";
    private static final String INSERT = "INSERT INTO user (name, email, country) VALUES (?, ?, ?);";
    private static final String DELETE = "DELETE FROM user WHERE id = ?;";
    private static  final String UPDATE = "UPDATE user SET name = ?, email = ?, country = ? WHERE id = ?;";


    private Connection connection;

    public UserRepository() throws SQLException {
        this.connection = DatabaseUtils.getConnection();
    }

    public List<User> findUsersByName(String name) {
        List<User> users = new ArrayList<>();

        try {
            processUserResult(name, users);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    public void insertUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            int insertedRows = ps.executeUpdate();
            System.out.println("Insert operation returned: " + (insertedRows == 1 ? "OK" : "Nothing was inserted"));
            System.out.println("Inserted object was: " + user);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE);
            ps.setInt(1, id);
            int deletedRows = ps.executeUpdate();
            System.out.println("Delete operation returned: " + (deletedRows == 1 ? "OK" : "Nothing was deleted."));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public void updateUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setInt(4, user.getId());
            int updatedRows = ps.executeUpdate();
            System.out.println("Update operation returned: " + (updatedRows == 1 ? "OK" : "Nothing was updated."));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void processUserResult(String name, List<User> users) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT);
        ps.setString(1, name);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int userId = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String userEmail = resultSet.getString("email");
            String userCountry = resultSet.getString("country");
            users.add(new User(userId, userName, userEmail, userCountry));
        }
    }


}
