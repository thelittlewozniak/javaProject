package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.GameBusiness;
import be.nathanPire.pojo.Game;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateGameView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1679918178074986811L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDevelopers;
	private JTextField txtEditors;
	private JTextField txtUnit;
	private JTextField txtConsole;
	/**
	 * Create the frame.
	 */
	public UpdateGameView(Game g) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 100, 14);
		contentPane.add(lblName);
		
		JLabel lblDevelopers = new JLabel("Developers");
		lblDevelopers.setBounds(10, 36, 100, 14);
		contentPane.add(lblDevelopers);
		
		JLabel lblEditors = new JLabel("Editors:");
		lblEditors.setBounds(10, 61, 100, 14);
		contentPane.add(lblEditors);
		
		JLabel lblUnit = new JLabel("Unit:");
		lblUnit.setBounds(10, 86, 100, 14);
		contentPane.add(lblUnit);
		
		txtName = new JTextField(g.getName());
		txtName.setBounds(120, 8, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtDevelopers = new JTextField(g.getDevelopers());
		txtDevelopers.setColumns(10);
		txtDevelopers.setBounds(120, 33, 86, 20);
		contentPane.add(txtDevelopers);
		
		txtEditors = new JTextField(g.getEditors());
		txtEditors.setColumns(10);
		txtEditors.setBounds(120, 58, 86, 20);
		contentPane.add(txtEditors);
		
		txtUnit = new JTextField(Float.toString(g.getUnit()));
		txtUnit.setColumns(10);
		txtUnit.setBounds(120, 83, 86, 20);
		contentPane.add(txtUnit);
		
		txtConsole = new JTextField(g.getConsole());
		txtConsole.setColumns(10);
		txtConsole.setBounds(120, 108, 86, 20);
		contentPane.add(txtConsole);
		setContentPane(contentPane);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameBusiness gB=new GameBusiness();
				gB.editGame(new Game(g.getID(),txtName.getText(),txtDevelopers.getText(),txtEditors.getText(),Float.parseFloat(txtUnit.getText()),txtConsole.getText()));
				dispose();
			}
		});
		btnUpdate.setBounds(10, 146, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(120, 146, 89, 23);
		contentPane.add(btnClose);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(10, 111, 100, 14);
		contentPane.add(lblConsole);
	}

}
