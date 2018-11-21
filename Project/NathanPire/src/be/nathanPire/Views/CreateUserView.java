package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.PlayerBusiness;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUserView extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstname;
	private JTextField txtSurname;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtAddress;
	private JTextField txtBirthday;

	/**
	 * Create the frame.
	 */
	public CreateUserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationOfA = new JLabel("Creation of a new user");
		lblCreationOfA.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreationOfA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCreationOfA.setBounds(10, 11, 409, 42);
		contentPane.add(lblCreationOfA);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstname.setBounds(10, 64, 125, 35);
		contentPane.add(lblFirstname);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSurname.setBounds(10, 110, 125, 35);
		contentPane.add(lblSurname);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(10, 156, 125, 35);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(10, 202, 125, 35);
		contentPane.add(lblPassword);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(10, 248, 125, 35);
		contentPane.add(lblAddress);
		
		JLabel lblBirthday = new JLabel("Birthday:(dd/mm/yyyy)");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBirthday.setBounds(10, 294, 125, 35);
		contentPane.add(lblBirthday);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(145, 64, 274, 35);
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(145, 110, 274, 35);
		contentPane.add(txtSurname);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(145, 156, 274, 35);
		contentPane.add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(145, 202, 274, 35);
		contentPane.add(txtPassword);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(145, 248, 274, 35);
		contentPane.add(txtAddress);
		
		txtBirthday = new JTextField();
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(145, 294, 274, 35);
		contentPane.add(txtBirthday);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerBusiness p=new PlayerBusiness();
				var u=p.Register(txtEmail.getText(), txtPassword.getText(), txtSurname.getText(), txtFirstname.getText(), txtBirthday.getText(), txtAddress.getText());
				if(u) {
					JOptionPane.showMessageDialog(null, "User created");
					dispose();
				}
			}
		});
		btnCreateUser.setBounds(10, 340, 294, 40);
		contentPane.add(btnCreateUser);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(314, 340, 105, 40);
		contentPane.add(btnCancel);
	}

}
