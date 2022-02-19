
import java.util.Set;

public class Employee {

    public Employee(String Name, String work_phone, double salary) {
        this.tab_number = Name;
        this.work_phone = work_phone;
        this.salary = salary;
    }

    public Employee() {
    }

    Employee(String name) {
        this.tab_number = tab_number;//
        this.work_phone = "NotDefine";
        this.salary = 0;
    }

    @Override
    public String toString() {
        return "Employee{" + "Name=" + tab_number + ", work_phone=" + work_phone + ", salary=" + salary + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }

    public double getSalary() {
        return salary;
    }

    //
    public void setSalary(double salary) {
        this.salary = salary;
    }
    private long id = 1L;

    public String getTab_number() {
        return tab_number;
    }

    public void setTab_number(String tab_number) {
        this.tab_number = tab_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    String name;
    // Ошибка
    private String tab_number;
    private String work_phone;
    private double salary;

    public Set<Department> getDepartments() {
        return departments;
    }

    //
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
    //Departments
    private Set<Department> departments;


}
