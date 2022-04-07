
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Employee")
public class Employee {

    public Employee() {
    }

    Employee(String name) {
        this.name = name;//
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 1L;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    String name;

    public Set<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
    /*
     Двунаправленный маппинг many-to-many

Если сущности типов Department и Employees будут иметь ссылки на коллекции друг друга, то отношения будут двунаправленными.
Для этого:
    создадим поле departments типа List<Department> в этом классе Employees
    добавим к этому полю departments аннотацию @ManyToMany
    добавим элемент аннотации mappedBy, который будет указывать на имя поля класса Department,
    которое в том класск имеет аннотации @ManyToMany и @JoinTable, т.е. departments
    */
    @ManyToMany(mappedBy = "employees")//employees - это поле в классе Department
    private Set<Department> departments;


}
