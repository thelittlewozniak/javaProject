package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.GameBusiness;
import be.nathanPire.BusinessLayer.PlayerBusiness;
import be.nathanPire.pojo.Player;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddANewCopyView extends JFrame {

	private static final long serialVersionUID = 6237003903008553443L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public AddANewCopyView(Player p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		var gameBusiness=new GameBusiness();
		var games=gameBusiness.getGames();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i=0;i<games.size();i++) {
			listModel.addElement(games.get(i).getName());
		}
		contentPane.setLayout(null);
		JList listGames = new JList(listModel);	
		listGames.setBounds(10, 11, 246, 520);
		contentPane.add(listGames);
		setContentPane(contentPane);
		
		JButton btnAddCopy = new JButton("Add a Copy of this game");
		btnAddCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listGames.isSelectionEmpty()) {
					PlayerBusiness pB=new PlayerBusiness();
					var game=games.get(listGames.getSelectedIndex());
					var player=pB.addACopy(p,game);
					YourCopyView gView=new YourCopyView(player);
					gView.setVisible(true);
					dispose();
				}
			}
		});
		btnAddCopy.setBounds(266, 11, 158, 23);
		contentPane.add(btnAddCopy);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YourCopyView gView=new YourCopyView(p);
				gView.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(266, 45, 158, 23);
		contentPane.add(btnClose);
	}

}
