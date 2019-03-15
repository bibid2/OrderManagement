package Presentation;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


public class interfata {
	
	public JTable tabel;
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfata window = new interfata();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}

	public interfata() {
		initialize();
	}
	private void initialize() {
	frame = new JFrame();
	frame.setBounds(700, 300, 680, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	
	JButton btnClient = new JButton("Client");
	btnClient.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Client frame1=new Client();
			frame1.getFrame().setVisible(true);
			//frame.setVisible(false);
		}
	});
	btnClient.setBounds(260, 75, 130, 50);
	frame.getContentPane().add(btnClient);
	
	JButton btnProdus = new JButton("Produs");
	btnProdus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Produs frame2=new Produs();
			frame2.getFrame().setVisible(true);
			//frame.setVisible(false);
		}
	});
	btnProdus.setBounds(260, 150, 130, 50);
	frame.getContentPane().add(btnProdus);
	
	JButton btnComenzi = new JButton("Comenzi");
	btnComenzi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Comenzi frame1=new Comenzi();
			frame1.getFrame().setVisible(true);
			//frame.setVisible(false);
		}
	});
	btnComenzi.setBounds(260, 225, 130, 50);
	frame.getContentPane().add(btnComenzi);
	
    frame.setVisible(true);
    
    
	
}}

