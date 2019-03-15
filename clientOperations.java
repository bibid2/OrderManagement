package DataAccess;

import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Model.Client;


public class clientOperations {

	//private Connection connection=(Connection) conection.getConnection();
	

	private String url;
	private String user;
	private String password;
	private static Connection connection;
	
	public  clientOperations()
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
	public String afiseazaClienti()
	{

		String result="";
		try
		{
			Statement myStmt=this.connection.createStatement();
			ResultSet myRes=myStmt.executeQuery("SELECT * FROM clienti");
			while(myRes.next())
			{
				result=result+myRes.getString("id")+ " "+myRes.getString("nume")+ " "+myRes.getString("Prenume")+"\n";
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return result;
	}
	public void adaugareClient(String id_c, String nume, String prenume, String id_com )
	{
		try {
			CallableStatement myStmt=this.connection.prepareCall("{call adaugare_client(?,?,?,?)}");
			myStmt.setString(1, id_c);
			myStmt.setString(2, nume);
			myStmt.setString(3,prenume);
			myStmt.setString(4,id_com);
			myStmt.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void stergereClient(String id_c)
	{
		try {
			CallableStatement myStmt=this.connection.prepareCall("{call stergere_client(?)}");
			myStmt.setString(1, id_c);
			myStmt.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void editareClient(String id_c, String nume, String prenume, String id_com, String id_vechi )
	{
		try {
			CallableStatement myStmt=this.connection.prepareCall("{call editare_client2(?,?,?,?,?)}");
			myStmt.setString(1, id_c);
			myStmt.setString(2, nume);
			myStmt.setString(3,prenume);
			myStmt.setString(4,id_com);
			myStmt.setString(5, id_vechi);
			myStmt.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}


}
