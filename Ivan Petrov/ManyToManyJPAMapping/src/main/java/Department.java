import javax.persistence.*;
import java.util.Set;

@Entity
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
    @Id
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
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    //
    /*
     Однонаправленный маппинг

Если сущности типа Department будут иметь ссылки на коллекции сущностей типа Employees,
но сущности типа Employees не будут ссылаться на коллекции сущностей типа Department, то отношения будут однонаправленными.

Для маппинга типа "многие-ко-многим":

    добавим полю employees аннотацию @ManyToMany
    добавим полю employees аннотацию @JoinTable
    добавим элемент аннотации name c указанием имени таблицы, которая содержит данные об отношениях, т.е. EmployeesToDepartments
    добавим элементы аннотации joinColumns и inverseJoinColumns с указанием имен колонок, которые являются внешними ключами, т.е. EmployeesId и DepartmentsId
    */
    //выберем всех сотрудников из Подразделения
    @ManyToMany
    @JoinTable(name = "EmployeesToDepartments",//имя таблицы в базе данных, которая описывает отношение "многие-ко-многим"
            joinColumns = @JoinColumn(name = "EmployeesId"),//имя стоблца в базе данных
            inverseJoinColumns = @JoinColumn(name = "DepartmentsId"))//имя стоблца в базе данных
    private Set<Employee> employees;
}
