import java.util.Objects;
//
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity; //@Entity
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; //@Id
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//
@Entity
public class Employee {

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 1L;

    private String name;

    //констурктор без параметров нужен для рефлексии, чтобы создавались
    //тексты запросов
    public Employee() {
    }

    //нужен для "ручного создания объекта"
    public Employee(String fname) {
        name = fname;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

