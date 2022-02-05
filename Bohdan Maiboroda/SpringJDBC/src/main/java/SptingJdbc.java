//jdbc - general
// import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//spring for jdbc
import DAO.Employee;
import Helpers.Creater;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import static DAO.Employee.nameFilter;
import static DAO.Employee.*;
//
/*
public static void main(String[] args)
{

    //Все методы для выборки данных с фильтрацией должны значения
    //для фильтра в параметре
    //Синтаксис передачи параметра в запрос
    //введение шаблона DAO (Data Access Objects (Layer))
    //использование именных параметров
    //работа с файлами свойств (хранилищами настроек соединения)
}
 */
public class SptingJdbc {
    public static void main(String[] args) {

        // Spting
        // источник данных
        // SimpleDatatSource
        // DataSource использовать желательно для конкретной СУБД
        // OracleDataSource, MySQLDataSource, SQLiteDataSource
        // источник резултатов выполненых хапросов - JBDCTamplate


        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource = Creater.createDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Hello from getFilteredByName");
        List<Employee> results = Employee.getFilteredByName(jdbcTemplate);
        results.forEach( e -> System.out.println(e));
        System.out.println("Hello from getAll");
        List<Employee> employees = Employee.getAll(jdbcTemplate);
        employees.forEach( e -> System.out.println(e));
    }
    //Синтаксис вызова параметра в запрос
    //Введение шаблона DAO Data Access Object (Layer)
    //

}
