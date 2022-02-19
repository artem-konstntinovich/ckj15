import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManyToManyXMLMapping {
    public static void main(String[] args)
    {
        System.out.println("Hello from ManyToManyXMLMapping");
//
        SessionFactory mFctory;
        try {
            mFctory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            System.err.println("Файл Hibernate.cfg.xml или не найден или некорректной структуры");
            throw new ExceptionInInitializerError(ex);
        }
        //Hibernate Query Language
        System.out.println("--- all employees ---");
        Session session = mFctory.openSession();
        //
        Transaction tx = null;
        Long departmentID = null;
        String name ="Dep#101";
        try{
            tx = session.beginTransaction();
            Department department = new Department(name);
            //
            Set<Employee> empls =  new HashSet<Employee>(2);
            Employee e1 = new Employee("Иванов 1");
            session.save(e1);
            Employee e2 = new Employee("Иванов 2");
            session.save(e2);
            empls.add(e1);
            empls.add(e2);
            department.setEmployees(empls);
            //
            departmentID = (Long) session.save(department);
            tx.commit();
            System.out.println(String.format("Inserted: %s\n", departmentID));
        }catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        //
    }
}
