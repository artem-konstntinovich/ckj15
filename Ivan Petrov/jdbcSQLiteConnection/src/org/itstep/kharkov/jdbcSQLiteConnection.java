package org.itstep.kharkov;

import java.sql.DriverManager;//���������� �������� ���������

import java.sql.Connection;//��������� ���������� ��
import java.sql.Statement;//��� �������� select (update)
import java.sql.CallableStatement;//��� ������ � ��
import java.sql.ResultSet;//��������� ���������� �������
import java.sql.SQLException;

public class jdbcSQLiteConnection {

	public static void main(String[] args){
		System.out.println("Hello from jdbcSQLiteConnection");
		//+��� 0 ����������� �������� - ��� �������, ����
		//+��� 1 ����������� ������� � �������
		//+��� 2 ������������� ���������� Connection (����-����� � ����)
		//+��� 3 ������ ������� Statement ��� ���������� SQL
		//+��� 4 ��������� ���������� (if, while) 
		try {
			Class.forName("org.sqlite.JDBC");//��� 1
			   Connection conn = null;
			   String connTxt = "jdbc:sqlite:C:\\MyData\\test.db";
			   
	           conn = DriverManager.getConnection(connTxt);
	           Statement stm = conn.createStatement();
	             // String selectText = "SELECT NAME, AGE, SALARY FROM EMPLOYEES";
	             String selectText = "SELECT" +
	                                 "  NAME," +
	                                 "  AGE," +
	                                 "  POSITIONS," +
	                                 "  AVG(SALARY * 27.25) AS SALARY" +
	                                 " FROM" +
	                                 "  Employees" +
	                                 " GROUP BY POSITIONS " +
	                                 " ORDER BY POSITIONS ASC, SALARY DESC";
	             ResultSet rs = stm.executeQuery(selectText);
	             int num = 0;
	             //Scanner 
	             while (rs.next())//������������� ��� ������� ����������
	             {
	                double salary = rs.getFloat("SALARY");
	                String str = rs.getString("NAME");
	                int age = rs.getInt("AGE");
	                String position = rs.getString("POSITIONS");
	                System.out.println("��� :" + str);
	                System.out.println("������� = "+age);
	                System.out.println("���������� ����� = "+salary);
	             }
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("������ � ������ ����� ��������");
			e.printStackTrace();
			System.out.println("����� �������� ������");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}

}
