package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.GameBusiness;
import be.nathanPire.BusinessLayer.PlayerBusiness;
import be.nathanPire.pojo.Game;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListModel;

public class AdminPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
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
		btnClose.setBounds(10, 302, 414, 23);
		contentPane.add(btnClose);
		
		var gameBusiness=new GameBusiness();
		var games=gameBusiness.getGames();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i=0;i<games.size();i++) {
			listModel.addElement(games.get(i).getName()+" "+games.get(i).getConsole());
		}
		JList listGames = new JList(listModel);	
		listGames.setBounds(10, 79, 414, 212);
		listGames.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	int index = list.locationToIndex(evt.getPoint());
		            Game g=gameBusiness.getGameByName(games.get(index).getName());
		            UpdateGameView gameView=new UpdateGameView(g);
		            gameView.setVisible(true);
		            dispose();
		        }
		    }
		});
		contentPane.add(listGames);
	}
}
