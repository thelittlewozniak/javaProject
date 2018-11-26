package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.PlayerBusiness;
import be.nathanPire.pojo.Player;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7072452054227634098L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblLogin.setBounds(10, 11, 414, 54);
		contentPane.add(lblLogin);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmail.setBounds(10, 76, 149, 54);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(10, 141, 149, 54);
		contentPane.add(lblPassword);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(217, 76, 207, 54);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword.setColumns(10);
		txtPassword.setBounds(217, 141, 207, 54);
		contentPane.add(txtPassword);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtEmail.getText()!=null && txtPassword.getText()!=null) {
					PlayerBusiness p=new PlayerBusiness();
					Player u=p.login(txtEmail.getText(), txtPassword.getText());
					if(u!=null) {
						HomeView home=new HomeView(u);
						home.setVisible(true);
						dispose();
					}
				}
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnConnect.setBounds(10, 206, 207, 44);
		contentPane.add(btnConnect);
		
		JButton btnNoAccount = new JButton("No account?");
		btnNoAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateUserView createUser=new CreateUserView();
				createUser.setVisible(true);
			}
		});
		btnNoAccount.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNoAccount.setBounds(217, 206, 207, 44);
		contentPane.add(btnNoAccount);
	}
}
