package Presentation;
import BusinessLogic.Vizualizare;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import DataAccess.clientOperations;



/**
 * @author bianca
 *
 */
public class Client {

	public JTable tabel;
	private JFrame frame;
	private JLabel label1,label2, label3, label4, label5;
	private JTextField t1,t2,t3,t4,t5;
	private JButton btn1,btn2,btn3,btn4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
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
	public Client() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Operatii client");
		//sursa d=new sursa();
	//setFrame(new JFrame());
	//getFrame().setBounds(100, 50, 400, 400);
	//getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//getFrame().getContentPane().setLayout(null);
	label1=new JLabel();
	label1.setText("Introduceti id-ul: ");
	label1.setBounds(50, 100, 150, 50);
	frame.getContentPane().add(label1);
	t1=new JTextField();
	t1.setBounds(230,115, 100, 20);
	frame.getContentPane().add(t1);
	
	label2=new JLabel();
	label2.setText("Introduceti numele ");
	label2.setBounds(50, 130, 150, 50);
	frame.getContentPane().add(label2);
	t2=new JTextField();
	t2.setBounds(230,145, 100, 20);
	frame.getContentPane().add(t2);
	
	label3=new JLabel();
	label3.setText("Introduceti prenumele ");
	label3.setBounds(50, 160, 150, 50);
	frame.getContentPane().add(label3);
	t3=new JTextField();
	t3.setBounds(230,175, 100, 20);
	frame.getContentPane().add(t3);
	
	label4=new JLabel();
	label4.setText("Introduceti id comanada ");
	label4.setBounds(50, 190, 150, 50);
	frame.getContentPane().add(label4);
	t4=new JTextField();
	t4.setBounds(230,205, 100, 20);
	frame.getContentPane().add(t4);
	
	label5=new JLabel();
	label5.setText("Introduceti id-ul vechi ");
	label5.setBounds(50, 220, 150, 50);
	frame.getContentPane().add(label5);
	t5=new JTextField();
	t5.setBounds(230,235, 100, 20);
	frame.getContentPane().add(t5);
	
	btn1= new JButton();
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clientOperations c=new clientOperations();
			String id_c=t1.getText();
			String nume=t2.getText();
			String prenume=t3.getText();
			String id_com=t4.getText();
			c.adaugareClient(id_c, nume, prenume, id_com);
		}
	});
	btn1.setText("Adaugare");
	btn1.setBounds(50, 300, 100, 40);
	frame.getContentPane().add(btn1);
	
	btn2= new JButton();
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clientOperations c=new clientOperations();
			String id_c=t1.getText();
			c.stergereClient(id_c);
		}
	});
	btn2.setText("Stergere");
	btn2.setBounds(200, 300, 100, 40);
	frame.getContentPane().add(btn2);
	
	btn3= new JButton();
	btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clientOperations c=new clientOperations();
			String id_c=t1.getText();
			String nume=t2.getText();
			String prenume=t3.getText();
			String id_com=t4.getText();
			String id_v=t5.getText();
			c.editareClient(id_c, nume, prenume, id_com, id_v);
		}
	});
	btn3.setText("Editare");
	btn3.setBounds(50, 380, 100, 40);
	frame.getContentPane().add(btn3);
	
	btn4= new JButton();
	btn4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Vizualizare vc = new Vizualizare();
			ArrayList<Model.Client> lista=new ArrayList<Model.Client>();
			lista=vc.vizualizareClienti();
			Object [][] data= new Object[100][];
			String [] columnNames= new String [4];
			columnNames[0]="Id";
			columnNames[1]="Nume";
			columnNames[2]="Prenume";
			columnNames[3]="Id comanda";
			for(int i=0;i<100;i++)
			{
				data[i]=new Object[100];
			}
			int nr=0;
			for(Model.Client c1:lista)
			{
				int nrField=0;
				data[nr][nrField++]=c1.getId();
				data[nr][nrField++]=c1.getNume();
				data[nr][nrField++]=c1.getPrenume();
				data[nr][nrField++]=c1.getId_comanda();
				nr++;	
			}
	
			tabel=new JTable(data, columnNames);
			JScrollPane scroll= new JScrollPane(tabel);
			scroll.setBounds(350, 150, 300, 100);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			frame.add(scroll, BorderLayout.CENTER);
		    frame.setVisible(true);
		}
	});
	btn4.setText("Vizualizare");
	btn4.setBounds(200, 380, 100, 40);
	frame.getContentPane().add(btn4);
	}
	private ArrayList<Vizualizare> vizualizareClienti() {
		// TODO Auto-generated method stub
		return null;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
