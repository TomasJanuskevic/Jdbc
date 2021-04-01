package example2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private Connection connection;

    private Company createCompany(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String companyName = resultSet.getString("companyName");
        String address = resultSet.getString("address");
        int budget = resultSet.getInt("budget");
        int employeeCount = resultSet.getInt("employeeCount");

        return new Company(id, companyName, address, budget, employeeCount);
    }

    public List<Company> findAll() throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM company";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Company> companies = new ArrayList<>();

        while (resultSet.next()) {
            Company company = createCompany(resultSet);
            companies.add(company);
        }
        //closing logic here...
        return companies;
    }

    public Company findById(int companyId) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM company WHERE id = " + companyId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            return createCompany(resultSet);
        }
        return null;
    }

    public void save(Company company) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = String.format("INSERT INTO company VALUES(DEFAULT, '%s', '%s', %d, %d);",
                company.getCompanyName(),
                company.getAddress(),
                company.getBudget(),
                company.getEmployeeCount());

        Statement statement = connection.createStatement();
        int insertedRows = statement.executeUpdate(sql);
        System.out.println("Insert statement status: " + (insertedRows == 1 ? "OK" : "No inserted"));
    }

    public void deleteById(int companyId) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "DELETE FROM company WHERE id = " + companyId;
        Statement statement = connection.createStatement();
        int deletedRows = statement.executeUpdate(sql);

        if (deletedRows > 0) {
            System.out.println("Deleted " + deletedRows + " rows");
        } else {
            System.out.println("Nothing was deleted.");
        }
    }

    public List<Company> findByName(String companyName) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM company WHERE companyName = '" + companyName + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Company> companies = new ArrayList<>();
        while (resultSet.next()) {
            Company company = createCompany(resultSet);
            companies.add(company);
        }
        return companies;
    }

    public void update(Company company) throws SQLException {
        connection = DatabaseUtils.getConnection();
        Company existingCompany = findById(company.getId());

        if (existingCompany == null) {
            save(company);
            System.out.println("New company was created, because nothing to update.");
        } else {
            String sql = String.format("UPDATE company SET companyName = '%s', address = '%s', budget = %d, employeeCount = %d WHERE id = %d",
                    company.getCompanyName(),
                    company.getAddress(),
                    company.getBudget(),
                    company.getEmployeeCount(),
                    company.getId());
            Statement statement = connection.createStatement();
            int updatedRows = statement.executeUpdate(sql);
            System.out.println(updatedRows + " were updated");
        }
    }
}
