package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Client;

public class Vizualizare {

	private String url;
	private String user;
	private String password;
	private static Connection connection;
	
	public  Vizualizare()
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
	public ArrayList<Client> vizualizareClienti()
	{
		ArrayList<Client> list = new ArrayList<Client>();

		String query = "SELECT * FROM clienti";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement(query);
			rs = st.executeQuery(query);
			//rs.next();

			while (rs.next()) {
				Client client = new Client(rs.getString("id"), rs.getString("nume"), rs.getString("prenume"),rs.getString("id_comanda"));
				list.add(client);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
}
