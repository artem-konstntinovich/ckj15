import java.util.ArrayList;

//для версии 5+
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//



public class HibernateJpaMavenTest {
    public static void main(String[] args)
    {
        System.out.println("Hello from HibernateJpaMavenTest");
        SessionFactory mFctory;
        try{
            //здесь происходит разбор структуры (парсинг) файла hibernate.cfg.xml
            mFctory = new Configuration().configure().buildSessionFactory();
            //если сессия создана, то соединение с базой установлено
            //драйвер базы данных загружен
            //сама база данных найдена
        }catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = null;
        session = mFctory.openSession();//соединился
        //
        Transaction tx = null;
        Long employeeID = null;
        String fname ="Peter Ivanov";
        try{
            tx = session.beginTransaction();
            Employee employee = new Employee(fname);
            employeeID = (Long) session.save(employee);
            tx.commit();
        }catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        //
        System.out.println("Hibernate test passed");
    }
}
