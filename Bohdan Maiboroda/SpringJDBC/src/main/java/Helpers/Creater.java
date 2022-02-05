package Helpers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.Properties;

public class Creater {
    public static SimpleDriverDataSource createDataSource()
    {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        //было Class.forName("org.sqlite.JDBC");//ШАГ 1
        //стало
        dataSource.setDriverClass(org.sqlite.JDBC.class);
        String dbFile = "C:\\MyData\\test.db";
        dataSource.setUrl("jdbc:sqlite:" + dbFile);
        /*
        String connTxt = "jdbc:sqlite:C:\\MyData\\test.db";
            conn = DriverManager.getConnection(connTxt);
         */
        // dataSource.setUsername(); //имя пользователя в кодировке EN (Utf8)
        // dataSource.setPassword(); //имя пользователя в кодировке EN
        return dataSource;
    }
    protected static Properties getLoadedProperties()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("???");
        Properties prop = new Properties();
        //
        //
        return prop;
    }

}
