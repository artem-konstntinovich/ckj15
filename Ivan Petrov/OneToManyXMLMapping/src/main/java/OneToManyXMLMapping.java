import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class OneToManyXMLMapping {

    public static void main(String[] args)
    {
        System.out.println("Hello from OneToManyXMLMapping");
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
        //
        Session session = null;
        session = mFctory.openSession();//соединился
        Transaction tx = session.beginTransaction();
        try{
            //

            Category category = new Category("Noutes");
            Product laptop = new Product("Lenovo", "For those who do", 2100, category);
            Product mac = new Product("Mac", "Html coder", 3000,category);

            Set<Product> products = new HashSet<Product>();
            products.add(mac);
            products.add(laptop);
            category.setProducts(products);
            session.save(category);
            tx.commit();
            //
        }catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        //
    }

}
