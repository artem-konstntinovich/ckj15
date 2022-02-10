import java.sql.*;

public class JdbcMsSQLServerConnectionTest {
    public static void main(String[] args)
    {
        //1 Присоединяю драйвер нужной СУБД +
        //2. регистрирую класс драйвера в проекте
        //3.создаем Connection
        Connection conn = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind","root","1991an09");


            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                Statement stmt = conn.createStatement();
                try {
                    ResultSet rs = stmt.executeQuery("select ProductName, QuantityPerUnit from Products\n" +
                            "order by ProductName");
                    try {
                        while (rs.next()) {
                            String sResult = rs.getString("ProductName");
                            String sResult1 = rs.getString("QuantityPerUnit");


                            System.out.print(sResult);
                            System.out.print(" ");
                            System.out.println(sResult1);
                        }
                    } finally {
                        try {
                            rs.close();
                        } catch (Exception ignore) {
                        }
                    }
                } finally {
                    try {
                        stmt.close();
                    } catch (Exception ignore) {
                    }
                }
                //

            }
        } catch (SQLException ex)
        {
            System.out.println("ошибка с соединением.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //4.из Connection получаем команду (Statement)
        //5.выполняю текст запроса
    }
}
