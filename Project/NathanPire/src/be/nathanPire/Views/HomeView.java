package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.GameBusiness;
import be.nathanPire.pojo.Game;
import be.nathanPire.pojo.Player;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

public class HomeView extends JFrame {

	private JPanel contentPane;
	private Player p;
	 /*
	 * Create the frame.
	 */
	public HomeView(Player p) {
		this.p=p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGames = new JLabel("Games");
		lblGames.setBounds(10, 11, 46, 14);
		contentPane.add(lblGames);
		
		var gameBusiness=new GameBusiness();
		var games=gameBusiness.getGames();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i=0;i<games.size();i++) {
			listModel.addElement(games.get(i).getName());
		}
		JList listGames = new JList(listModel);	
		listGames.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	int index = list.locationToIndex(evt.getPoint());
		        	
		            Game g=gameBusiness.getGameByName(games.get(index).getName());
		        }
		    }
		});
		listGames.setBounds(10, 36, 413, 388);
		contentPane.add(listGames);
	}
}
