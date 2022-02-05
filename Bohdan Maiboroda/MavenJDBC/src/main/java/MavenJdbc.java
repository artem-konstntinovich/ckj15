import java.sql.*;

public class MavenJdbc {
    public static void main(String[] args) {
        System.out.println("!");

            StringBuilder sb = new StringBuilder();
            System.out.println("Hello from jdbcSQLiteConnection");
            try {
                Class.forName("org.sqlite.JDBC");//ШАГ 1
                Connection conn = null;
                String connTxt = "jdbc:sqlite:C:\\MyData\\test.db";

                conn = DriverManager.getConnection(connTxt);
                Statement stm = conn.createStatement();
                String selectText = "SELECT" +
                        " ID," +
                        " NAME," +
                        " AGE," +
                        " POSITIONS," +
                        " AVG(SALARY * 27.25) AS SALARY" +
                        " FROM" +
                        " Employees" +
                        " GROUP BY POSITIONS " +
                        " ORDER BY POSITIONS ASC, SALARY DESC";
                ResultSet rs = stm.executeQuery(selectText);
                int num = 0;
                while (rs.next())
                {
                    double salary = rs.getFloat("SALARY");
                    String str = rs.getString("NAME");
                    int age = rs.getInt("AGE");
                    String position = rs.getString("POSITIONS");

                    sb.append(" Имя : " + str +"\n");
                    sb.append(" Возраст : "   + age+"\n");
                    sb.append(" Зарплата : " + salary+"\n");
                    sb.append(" Должность : " + position+"\n");

                    System.out.println("Имя :" + str);
                    System.out.println(" Возраст = " + age);
                    System.out.println(" Заработная плата = " + salary);
                }


            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("Ошибка с именем файла драйвера");
                e.printStackTrace();
                System.out.println("Класс драйвера найден");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        System.out.println(sb.toString());
        }

    }

