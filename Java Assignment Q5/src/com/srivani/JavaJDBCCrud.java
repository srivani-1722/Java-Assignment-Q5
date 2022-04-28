package com.srivani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaJDBCCrud {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String dbURL = "jdbc:mysql://localhost:3306/empdata";
		String username = "root";
		String password = "root";
		 
		Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection(dbURL, username, password);
		 
		    		Statement stmt=con.createStatement();
		//craeting table
		String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "EmployeeData"
        + "  (id  INT PRIMARY KEY,"
        + "   name     VARCHAR(50),"
        + "   position VARCHAR(20))";
        stmt.executeUpdate(sqlCreate);
        //inserting data
        String sql = "INSERT INTO EmployeeData VALUES (1, 'emp1', 'pos1')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO EmployeeData VALUES (2, 'emp2', 'pos2')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO EmployeeData VALUES (3, 'emp3', 'pos3')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO EmployeeData VALUES(4, 'emp4', 'pos4')";
        stmt.executeUpdate(sql);
        //retrieving data
        ResultSet set=stmt.executeQuery("select * from EmployeeData");
		while(set.next()) {
			System.out.println(set.getInt(1)+"  "+set.getString(2)+"  "+set.getString(3));
		}
		//deleting data
		 sql = "DELETE FROM EmployeeData WHERE id=2";
		int rowsDeleted = stmt.executeUpdate(sql);
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}

        



	}

}
