import java.util.Set;


public class Department {

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentID=" + departmentID + ", name=" + name + '}';
    }
    private long departmentID = 1L;
    private String name;

    public long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    //
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    private Set<Employee> employees;
}
