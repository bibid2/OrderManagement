package DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class orderProduct {
	private String url;
	private String user;
	private String password;
	private static Connection connection;

	public  orderProduct()
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
	public String verificareComanda(String nume)
	{
	/*	try {
			CallableStatement myStmt=this.connection.prepareCall("{call verificare_comanda1(?)}");
			myStmt.setString(1, nume);
			myStmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		
		String result="";
		try
		{
			Statement myStmt=this.connection.createStatement();
			ResultSet myRes=myStmt.executeQuery("select cantitate from produse where denumire='"+nume+"'");
			
			while(myRes.next())
			{
				result=result+myRes.getString("cantitate");
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return result;
	
	}
	
	public void adaugareComanda(String id_c, String nume_p, String cant)
	{
		try {
			CallableStatement myStmt=this.connection.prepareCall("{call adaugare_comanda2(?,?,?)}");
			myStmt.setString(1, id_c);
			myStmt.setString(2, nume_p);
			myStmt.setString(3, cant);
			myStmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
