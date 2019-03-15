package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import BusinessLogic.Vizualizare;
import BusinessLogic.vizualizareProduse;
import DataAccess.productOperations;

public class Produs {

	private JFrame frame;
	private JLabel label1,label2, label3;
	private JTextField t1,t2,t3,t4;
	private JButton btn1,btn2,btn3,btn4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produs window = new Produs();
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
	public Produs() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Operatii produs");
		label1=new JLabel();
	label1.setText("Introduceti id-ul: ");
	label1.setBounds(50, 100, 150, 50);
	frame.getContentPane().add(label1);
	t1=new JTextField();
	t1.setBounds(230,115, 100, 20);
	frame.getContentPane().add(t1);
	t4=new JTextField();
	t4.setBounds(230,90, 100, 20);
	
	frame.getContentPane().add(t4);
	label2=new JLabel();
	label2.setText("Introduceti denumirea");
	label2.setBounds(50, 130, 150, 50);
	frame.getContentPane().add(label2);
	t2=new JTextField();
	t2.setBounds(230,145, 100, 20);
	frame.getContentPane().add(t2);
	
	label3=new JLabel();
	label3.setText("Introduceti id-ul vechi");
	label3.setBounds(50, 160, 150, 50);
	frame.getContentPane().add(label3);
	t3=new JTextField();
	t3.setBounds(230,175, 100, 20);
	frame.getContentPane().add(t3);

	btn1= new JButton();
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			productOperations p= new productOperations();
			String id_p=t1.getText();
			String denumire=t2.getText();
			String cantitate=t4.getText();
			p.adaugareProdus(id_p, denumire,cantitate);
		}
	});
	btn1.setText("Adaugare");
	btn1.setBounds(50, 220, 100, 40);
	frame.getContentPane().add(btn1);
	
	btn2= new JButton();
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			productOperations p= new productOperations();
			String id_p=t1.getText();
			p.stergereProdus(id_p);
		}
	});
	btn2.setText("Stergere");
	btn2.setBounds(200, 220, 100, 40);
	frame.getContentPane().add(btn2);
	
	btn3= new JButton();
	btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			productOperations p= new productOperations();
			String id_p=t1.getText();
			String denumire=t2.getText();
			String id_v=t3.getText();
			String cant=t4.getText();
			p.editareProdus(id_p, denumire, id_v,cant);
		}
	});
	btn3.setText("Editare");
	btn3.setBounds(50, 300, 100, 40);
	frame.getContentPane().add(btn3);
	
	btn4= new JButton();
	btn4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vizualizareProduse vp = new vizualizareProduse();
			ArrayList<Model.Produs> lista=new ArrayList<Model.Produs>();
			lista=vp.vizualizareProdus();
			Object [][] data= new Object[100][];
			String [] columnNames= new String [3];
			columnNames[0]="Id";
			columnNames[1]="Nume produs";
			columnNames[2]="Cantitate";
			for(int i=0;i<100;i++)
			{
				data[i]=new Object[100];
			}
			int nr=0;
			
			for(Model.Produs c1:lista)
			{
				int nrField=0;
				data[nr][nrField++]=c1.getId();
				data[nr][nrField++]=c1.getDenumire();
				data[nr][nrField++]=c1.getCantitate();
				nr++;	
			}
	
			JTable tabel=new JTable(data, columnNames);
			JScrollPane scroll= new JScrollPane(tabel);
			scroll.setBounds(350, 150, 250, 100);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			frame.add(scroll, BorderLayout.CENTER);
		    frame.setVisible(true);
		}
	});
	btn4.setText("Vizualizare");
	btn4.setBounds(200, 300, 100, 40);
	frame.getContentPane().add(btn4);
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}