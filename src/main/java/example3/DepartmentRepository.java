package example3;


import example2.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {
    private Connection connection;

    private Department createDepartment(ResultSet resultSet) throws SQLException {
        int departmentId = resultSet.getInt("departmentId");
        String name = resultSet.getString("name");
        return new Department(departmentId, name);
    }

    public List<Department> findAll() throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM department";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Department> departments = new ArrayList<>();

        while (resultSet.next()) {
            departments.add(createDepartment(resultSet));
        }

        resultSet.close();
        statement.close();
        connection.close();
        return departments;
    }

    public Department findById(int departmentId) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM department WHERE departmentId = " + departmentId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            return createDepartment(resultSet);
        }
        return null;
    }

    public void deleteById(int departmentId) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "DELETE FROM department WHERE departmentId = " + departmentId;
        Statement statement = connection.createStatement();
        int deletedRows = statement.executeUpdate(sql);

        if (deletedRows > 0) {
            System.out.println("Deleted " + deletedRows + " rows");
        } else {
            System.out.println("Nothing was deleted");
        }
    }

    public void save(Department department) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = String.format("INSERT INTO department VALUES(DEFAULT, '%s');", department.getName());
        Statement statement = connection.createStatement();
        int insertedRows = statement.executeUpdate(sql);

        if (insertedRows > 0) {
            System.out.println("Department was inserted");
        } else {
            System.out.println("Department wasn't inserted");
        }
    }

}
