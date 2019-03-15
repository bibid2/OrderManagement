package Presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import Model.Produs;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


import DataAccess.conection;
import DataAccess.orderProduct;

public class Comenzi {

	private JFrame frame;
	private JLabel label1,label2, label3;
	private JTextField t1,t2,t3;
	private JButton btn1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comenzi window = new Comenzi();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Comenzi() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Comenzi");

		label3=new JLabel();
		label3.setText("Introduceti id-ul comeznii: ");
		label3.setBounds(50, 60, 200, 50);
		frame.getContentPane().add(label3);
		t3=new JTextField();
		t3.setBounds(300,75, 100, 20);
		frame.getContentPane().add(t3);
		
		label1=new JLabel();
		label1.setText("Introduceti denumirea produsului: ");
		label1.setBounds(50, 100, 200, 50);
		frame.getContentPane().add(label1);
		t1=new JTextField();
		t1.setBounds(300,115, 100, 20);
		frame.getContentPane().add(t1);
		
		label2=new JLabel();
		label2.setText("Introduceti cantitatea dorita: ");
		label2.setBounds(50, 140, 200, 50);
		frame.getContentPane().add(label2);
		t2=new JTextField();
		t2.setBounds(300,155, 100, 20);
		frame.getContentPane().add(t2);
	
		btn1= new JButton("Plasare comanda!");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderProduct c= new orderProduct();
				String denumire=t1.getText();
				String cant=t2.getText();
				String id=t3.getText();
				//System.out.println(denumire+ " "+ cant + " "+ id);
				int x=Integer.parseInt(cant);
				//System.out.println(x);
				
				String cantStoc=c.verificareComanda(t1.getText());
				//System.out.println(cantStoc);
				int y=Integer.parseInt(cantStoc);
				if(y<x)
				{
					JOptionPane.showMessageDialog(null, "Cantitate stoc depasita!");
				}
				else c.adaugareComanda(id,denumire,cant);
				//System.out.println("cant stoc in int: "+ y);
				/*String s = "SELECT cantitate FROM produs where denumire = ?";
				PreparedStatement p= null;
				Statement st1=null;
				ResultSet rs = null;
				String denumire=t1.getText();
				try {
					String s1 = "SELECT cantitate FROM produs where denumire =' "+ denumire+"'";
					p=c.prepareStatement(s1);
					rs = p.executeQuery();
					rs.next();
					//int x=Integer.parseInt(rs);
					System.out.println(x);
				}
				catch(Exception e1)
				{
					e1.getStackTrace();
				}*/
				
				
				//p = c.prepareStatement(s);
					
				
				//String x=c.verificareComanda(t1.getText());
		/*	try {
				String denumire=t1.getText();
				String cant=t2.getText();
				String id=t3.getText();
				String cantStoc=c.verificareComanda("tiramisu");
				int x=Integer.parseInt(cantStoc);
				//if(Integer.parseInt(cant)>Integer.parseInt(cantStoc))
				{
					JOptionPane.showMessageDialog(null,Integer.parseInt(cant));
					//JOptionPane.showMessageDialog(null, "Cantitate stoc depasita!");
					//System.out.println(c.verificareComanda("tiramisu"));
					//System.out.println(cant);
				}
			//}catch (Exception e1)
			//{
			//	e1.getStackTrace();
		//	}
			//	else c.adaugareComanda(id,denumire,cant);*/
				
			}
		});
		btn1.setBounds(150, 225, 150, 50);
		frame.getContentPane().add(btn1);
	
	}
	public JFrame getFrame() {
		return frame;
	}
	public String getTextField() {
		return t1.getText();
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
