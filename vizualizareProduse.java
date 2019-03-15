package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Produs;

public class vizualizareProduse {

	private String url;
	private String user;
	private String password;
	private static Connection connection;
	
	public  vizualizareProduse()
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
	public ArrayList<Produs> vizualizareProdus()
	{
		ArrayList<Produs> list = new ArrayList<Produs>();

		String query = "SELECT * FROM produse";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement(query);
			rs = st.executeQuery(query);
			//rs.next();

			while (rs.next()) {
				Produs produs = new Produs(rs.getString("id"), rs.getString("denumire"), rs.getString("cantitate"));
				list.add(produs);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
}
