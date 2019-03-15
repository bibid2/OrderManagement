package DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class productOperations {

	private String url;
	private String user;
	private String password;
	private static Connection connection;
	
	public  productOperations()
	{
		this.url="jdbc:mysql://localhost:3306/tema3" + "?useSSL=false";
		this.user="root";
		this.password="";
		try {
		connection=DriverManager.getConnection(url, user, password);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public void adaugareProdus(String id_p, String nume, String cantitate )
	{
		try {
			CallableStatement myStmt=this.connection.prepareCall("{call adaugare_produs1(?,?,?)}");
			myStmt.setString(1, id_p);
			myStmt.setString(2, nume);
			myStmt.setString(3, cantitate);
			myStmt.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void stergereProdus(String id_p)
	{
		try {
			CallableStatement myStmt=this.connection.prepareCall("{call stergere_produs(?)}");
			myStmt.setString(1, id_p);
			myStmt.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void editareProdus(String id_p, String nume, String id_v, String cantitate )
	{
		try {
			CallableStatement myStmt=this.connection.prepareCall("{call editare_produs2(?,?,?,?)}");
			myStmt.setString(1, id_p);
			myStmt.setString(2, nume);
			myStmt.setString(3, id_v);
			myStmt.setString(4, cantitate);
			myStmt.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
