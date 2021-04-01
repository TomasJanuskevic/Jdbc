package example2;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompanyRepository companyRepository = new CompanyRepository();

        /**
         * find All
         */
        try {
            List<Company> companies = companyRepository.findAll();
            for (Company company : companies) {
                System.out.println(company);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        System.out.println();

        /**
         * find by Id
         */

        try {
            Company maxima = companyRepository.findById(1);
            System.out.println("Company find by id 1 " + maxima);
            Company hesburger = companyRepository.findById(5);
            System.out.println("Company find by id 5 " + hesburger);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        /**
         * Save company
         */
        Company company = new Company("Circle K", "Lapo g. 5", 15000, 25);
        try {
            companyRepository.save(company);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        System.out.println();

        /**
         * Delete company by id
         */

        try {
            Company company1 = companyRepository.findById(8);
            if (company1 != null) {
                companyRepository.deleteById(7);
            } else {
                System.out.println("Nothing to delete");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        System.out.println();

        /**
         * find by name
         */

        try {
            List<Company> companies = companyRepository.findByName("Hanner");
            for (Company company1 : companies) {
                System.out.println(company1);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        System.out.println();

        /**
         * Update company
         */

        try {
            companyRepository.update(new Company(1, "Maxima XXL", "Naujoji g. 5", 99999, 25));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
