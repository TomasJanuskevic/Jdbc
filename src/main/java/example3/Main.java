package example3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DepartmentRepository departmentRepository = new DepartmentRepository();
        List<Department> departments = new ArrayList<>();
        try {
            departments = departmentRepository.findAll();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        for (Department department : departments) {
            System.out.println(department);
        }

        System.out.println();

        try {
            System.out.println(departmentRepository.findById(2));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        System.out.println();

        try {
            departmentRepository.deleteById(1);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        Department department = new Department("JAVA");
        try {
            departmentRepository.save(department);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
