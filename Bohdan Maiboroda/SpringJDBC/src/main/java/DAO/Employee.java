

package DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Employee {



    private String newNameParam ; // String variable for method nameScanner
    private String nameParam = "Petriv";
    private double salaryParam = 1111.11;

    //тексты запросов
    public static final String fullSelect = "SELECT NAME, AGE, SALARY FROM EMPLOYEES";
    public static final String salaryFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE SALARY > ?";//символ ? - это параметр
    //который заполяется значением из перемменной правильного типа (соответствующего столбцу SALARY)
    // String nameFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE NAME like \'?%\'";
    // String nameFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE NAME = ?";
    // String nameFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE NAME LIKE '?%'";//ошибка в одинарных кавычках
    public static final String nameFilter = "SELECT NAME, AGE, SALARY FROM EMPLOYEES WHERE NAME LIKE ?";
    //методы получения сотрудников

    /**
     * Method nameScanner returns  String  newNameParam
     * like as param for method getFilteredByName
     * @return
     */
    public String nameScanner(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фильтр для name");
        newNameParam = scanner.nextLine();

        return newNameParam;
    }

    public static List<Employee> getAll(JdbcTemplate jdbcTemplate)
    {
        List<Employee> result = jdbcTemplate.
                query(Employee.fullSelect, //текст запрос
                        new EmployeeRowMapper()
                );
        return result;
    }

    public static List<Employee> getFilteredBySalary(JdbcTemplate jdbcTemplate, double salaryFilter){
        List<Employee> result = jdbcTemplate.
                query(Employee.salaryFilter,
                        new Object[]{salaryFilter},
                        new EmployeeRowMapper());
        return result;
    }

    public static List<Employee> getFilteredByName(JdbcTemplate jdbcTemplate, String a)
    {

        List<Employee> result = jdbcTemplate.
                query(Employee.nameFilter, //текст запрос
                        new Object[]{a}  , //массив параметров для запроса, если они нужны
                        new EmployeeRowMapper()
                );
        return result;
    }


    //описание таблицы в базе данных
    //количество столбцов их названия - все определяет таблица
    //сам класс Employee - описывает одну строку в таблице Employees

    public float salary;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String name;
    public int age;
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Employee() {
    }
    public Employee(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "DAO.Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getNameParam() {
        return nameParam;
    }

    public void setNameParam(String nameParam) {
        this.nameParam = nameParam;
    }

    public double getSalaryParam() {
        return salaryParam;
    }

    public void setSalaryParam(double salaryParam) {
        this.salaryParam = salaryParam;
    }

    public String getNewNameParam() {
        return newNameParam;
    }

    public void setNewNameParam(String newNameParam) {
        this.newNameParam = newNameParam;
    }
}
