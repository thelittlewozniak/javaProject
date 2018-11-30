package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.GameBusiness;
import be.nathanPire.pojo.Game;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6989463283523240348L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDevelopers;
	private JTextField txtEditors;
	private JTextField txtUnit;
	private JTextField txtConsole;
	/**
	 * Create the frame.
	 */
	public AddAGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		JLabel lblConsole = new JLabel("Console:");
		lblConsole.setBounds(10, 111, 46, 14);
		contentPane.add(lblConsole);
		
		txtName = new JTextField();
		txtName.setBounds(120, 8, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtDevelopers = new JTextField();
		txtDevelopers.setColumns(10);
		txtDevelopers.setBounds(120, 33, 86, 20);
		contentPane.add(txtDevelopers);
		
		txtEditors = new JTextField();
		txtEditors.setColumns(10);
		txtEditors.setBounds(120, 58, 86, 20);
		contentPane.add(txtEditors);
		
		txtUnit = new JTextField();
		txtUnit.setColumns(10);
		txtUnit.setBounds(120, 83, 86, 20);
		contentPane.add(txtUnit);
		
		txtConsole = new JTextField();
		txtConsole.setColumns(10);
		txtConsole.setBounds(120, 108, 86, 20);
		contentPane.add(txtConsole);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				var game=new Game(txtName.getText(),txtDevelopers.getText(),txtEditors.getText(),Float.parseFloat(txtUnit.getText()),txtConsole.getText());
				GameBusiness g=new GameBusiness();
				g.AddGame(game);
				dispose();
			}
		});
		btnAdd.setBounds(10, 136, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(117, 136, 89, 23);
		contentPane.add(btnClose);
	}
}
