package DataAccess;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

import Model.Client;
//import com.mysql.fabric.xmlrpc.Client;
public class conection {

	private String url;
	private String user;
	private String password;
	private static Connection connection;
	public static void setConnection(Connection connection) {
		conection.connection = connection;
	}
	public  conection()
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

	public String afiseazaProduse()
	{

		String result="";
		try
		{
			Statement myStmt=this.connection.createStatement();
			ResultSet myRes=myStmt.executeQuery("SELECT * FROM produse");
			while(myRes.next())
			{
				result=result+myRes.getString("id_produs")+ " "+myRes.getString("denumire")+"\n";
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return result;
	}
	
	

	
public ArrayList<Client> clientList()
	{
		ArrayList<Client> clientList=new ArrayList<Client>();
		try {
		String query="SELECT * FROM clienti";
		Statement myStmt=this.connection.createStatement();
		ResultSet result=myStmt.executeQuery(query);
		
		//Client client1;
		String a=result.getString("id");
		String b=result.getString("nume");
		String c=result.getString("prenume");
		String d=result.getString("id_comanda");
		while(result.next())
		{
				Client client=new Client(a,b,c,d);	
				clientList.add(client);
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return clientList;
		
	}
	public void show_client()
	{
		ArrayList<Client> list=clientList();
		//DefaultTableMode model= tabe
	}
	
	
	public PreparedStatement prepareStatement(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	
		
}
