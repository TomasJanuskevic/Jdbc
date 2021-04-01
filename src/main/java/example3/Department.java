package example3;

public class Department {
    private int departmentId;
    private String name;


    public Department(int departmentId, String name) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
