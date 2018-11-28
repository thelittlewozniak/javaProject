package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.PlayerBusiness;
import be.nathanPire.pojo.Game;
import be.nathanPire.pojo.Player;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MakeReservationView extends JFrame {

	private static final long serialVersionUID = 5591192084584397443L;
	private JPanel contentPane;
	private JTextField txtDate;

	/**
	 * Create the frame.
	 */
	public MakeReservationView(Player p,Game g) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 118);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWichDateYou = new JLabel("Wich date you want? (dd/mm/yyyy)");
		lblWichDateYou.setBounds(10, 11, 194, 14);
		contentPane.add(lblWichDateYou);
		
		txtDate = new JTextField();
		txtDate.setBounds(218, 8, 123, 20);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerBusiness pb=new PlayerBusiness();
				var player=pb.makeAReservation(p, txtDate.getText(), g);
				HomeView h=new HomeView(player);
				h.setVisible(true);
				dispose();
			}
		});
		btnConfirm.setBounds(10, 39, 149, 23);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(190, 39, 149, 23);
		contentPane.add(btnCancel);
	}
}
