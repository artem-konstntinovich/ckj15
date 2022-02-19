import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateQueryLanguageTester {

    private Session session;//отвечает за соединение с базой данных
    private ServiceRegistry serviceRegistry;//

    //
    void openSession() {
        System.out.println("openSession()");
        try {
            //если "эксепшн" здесь - значит
            //внутри hibernate.cfg.xml ошибка синтаксиса
            //например, не закрыты тэги...
            Configuration configuration = new Configuration().configure();
            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            //если ошибка здесь:
            //значит отсутсвуют сами классы для "мэппинга"
            //или jpa-тэги внутри классов
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            // obtains the session
            session = sessionFactory.openSession();
            session.beginTransaction();
        } catch (Exception ex) {
            String errmsg = ex.toString();
            System.out.println("Подробности ошибки: " + errmsg);
        }

    }

    void closeSession() {
        System.out.println("closeSession()");
        session.getTransaction().commit();
        session.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    //
    public void testQuery()
    {
        //HQL
        //Hiиernate
        //Query
        //language
        System.out.println("test select ");
        //String hql = "select c from Category c";//здесь Category
        //select * from Category
        String hql = "from Category";//здесь Category
        Query query = session.createQuery(hql);
        List<Category> categories = query.list();
        for (Category category : categories) {
            System.out.println(category);
        }
    }
    //
    public void testSearch()
    {
        System.out.println("test testSearch ");
        String hql = "select p from Product p where p.category.name = 'Computer'";//здесь Category
        Query query = session.createQuery(hql);
        List<Product> categories = query.list();
        for (Product product : categories) {
            System.out.println(product);
        }
    }
    //
    public void testQueryWithParams()
    {
        try {
            System.out.println("testQueryWithParams()");
            String hql = "from Product where description like :keyword";
            String keyword = "Html";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
            //from Product where description like %New%
            List<Product> listProducts = query.list();
            //всегда создается запрос и данные приходят из БД
            //данные в БД должны быть корректы:
            //все товары должны быть отнесены к существующим категориям
            //иначе не будет создан объект Category для товара
            for (Product aProduct : listProducts) {
                System.out.println(aProduct.getName());
            }
        } catch (Exception e) {
            String errmsg = e.toString();
            System.out.println(errmsg);
        }
    }
    //
    public void testCount()
    {
        System.out.println("test testCount ");
        String hql = "select count(p.name) from Product p";//count sum avg
        Query query = session.createQuery(hql);
        List listResult = query.list();
        Number number = (Number) listResult.get(0);
        System.out.println("select count(p.name) = "+number);
    }
    //
    public void testSum()
    {
        System.out.println("test testCount ");
        String hql = "select sum(p.price) from Product p";//count sum avg
        Query query = session.createQuery(hql);
        List listResult = query.list();
        Number number = (Number) listResult.get(0);
        System.out.println("select sum(p.price) = "+number);
    }
    //
    public void testAVG()
    {
        System.out.println("test testCount ");
        String hql = "select avg(p.price) from Product p";//count sum avg
        Query query = session.createQuery(hql);
        List listResult = query.list();
        Number number = (Number) listResult.get(0);
        System.out.println("select avg(p.price) = "+number);
    }
    //
    public static void main(String[] args)
    {
        HibernateQueryLanguageTester tester = new HibernateQueryLanguageTester();
        try {
            tester.openSession();
            //далее методы, которые создают запросы
            tester.testQuery();
            tester.testSearch();
            tester.testQueryWithParams();
            tester.testCount();
            tester.testSum();
            tester.testAVG();
            tester.testAgregation("avg",
                    "price",
                    "Product");
            tester.testOrderByQuery();
            //далее методы, которые модифицируют данные
            tester.testDeleteQuery(-1);
            tester.testUpdateQuery(27L);
            tester.testJoinQuery();

        } catch (Exception e) {
            e.toString();
        } finally {
            tester.closeSession();
        }
    }//end main
    void testUpdateQuery(long id) {
        System.out.println("testUpdateQuery()");
        String hql = "update Product set price = :price where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("price", 188.88f);
        query.setParameter("id", id);//тут тип long 2L

        int rowsAffected = query.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Updated " + rowsAffected + " rows.");
        }
    }
    void testDeleteQuery(int id) {
        System.out.println("testDeleteQuery()");
        String hql = "delete from Category where id = :catId";
        Query query = session.createQuery(hql);
        query.setParameter("catId", new Long(id));
        int rowsAffected = query.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Deleted " + rowsAffected + " rows.");
        }
        else
        {
            System.out.println("Deleted 0 rows.");
        }
    }
    public void testAgregation(String nameAgregator,
                               String columnName,
                               String tableName)
    {
        System.out.println("test testAgregation ");
        String hql = "select "+nameAgregator+"(p."+columnName+") from "+tableName+" p";//count sum avg
        Query query = session.createQuery(hql);
        List listResult = query.list();
        Number number = (Number) listResult.get(0);
        System.out.printf("select %s(p.%s) = %f",nameAgregator,columnName,number);
    }
    //
    void testOrderByQuery() {
        System.out.println("testOrderByQuery()");
        String hql = "from Product order by price ASC";
        Query query = session.createQuery(hql);
        List<Product> listProducts = query.list();
        for (Product aProduct : listProducts) {
            System.out.println(aProduct.getName() + "\t - " + aProduct.getPrice());
        }
    }
    //
    void testJoinQuery() {
        System.out.println("testJoinQuery()");
        String hql = "from Product p inner join p.category with p.price > 1200";
        Query query = session.createQuery(hql);
        List<Object[]> listResult = query.list();

        for (Object[] aRow : listResult) {
            Product product = (Product) aRow[0];
            Category category = (Category) aRow[1];
            System.out.println(product.getName() + " - " + product.getPrice()
                    + " - " + category.getName());
        }
    }
    //
}
