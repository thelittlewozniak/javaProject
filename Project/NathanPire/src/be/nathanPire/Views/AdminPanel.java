package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.PlayerBusiness;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMakeTheUnit = new JButton("Make the Unit balance");
		btnMakeTheUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerBusiness pB=new PlayerBusiness();
				pB.MakeCalcul();
			}
		});
		btnMakeTheUnit.setBounds(10, 11, 414, 23);
		contentPane.add(btnMakeTheUnit);
		
		JButton btnAddAGame = new JButton("Add a game");
		btnAddAGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddAGame addG=new AddAGame();
				addG.setVisible(true);
				dispose();
			}
		});
		btnAddAGame.setBounds(10, 45, 414, 23);
		contentPane.add(btnAddAGame);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(10, 79, 414, 23);
		contentPane.add(btnClose);
	}

}
