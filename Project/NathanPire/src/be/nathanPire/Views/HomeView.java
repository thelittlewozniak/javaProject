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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel lblGames = new JLabel("Catalogue");
		lblGames.setBounds(10, 11, 91, 14);
		contentPane.add(lblGames);
		
		var gameBusiness=new GameBusiness();
		var games=gameBusiness.getGames();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i=0;i<games.size();i++) {
			listModel.addElement(games.get(i).getName()+" "+games.get(i).getConsole());
		}
		JList listGames = new JList(listModel);	
		listGames.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	int index = list.locationToIndex(evt.getPoint());
		            Game g=gameBusiness.getGameByName(games.get(index).getName());
		            GameView gameView=new GameView(p,g);
		            gameView.setVisible(true);
		            dispose();
		        }
		    }
		});
		listGames.setBounds(10, 36, 309, 388);
		contentPane.add(listGames);
		
		JButton btnYourReservations = new JButton("Your Reservations");
		btnYourReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReservationView r=new ReservationView(p);
				r.setVisible(true);
				dispose();
			}
		});
		btnYourReservations.setBounds(395, 33, 121, 23);
		contentPane.add(btnYourReservations);
		
		JButton btnYourLoans = new JButton("Your Loans");
		btnYourLoans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoansView l=new LoansView(p);
				l.setVisible(true);
				dispose();
			}
		});
		btnYourLoans.setBounds(395, 67, 121, 23);
		contentPane.add(btnYourLoans);
		
		JButton btnYourGames = new JButton("Your Games");
		btnYourGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YourCopiesView gView=new YourCopiesView(p);
				gView.setVisible(true);
				dispose();
			}
		});
		btnYourGames.setBounds(395, 101, 121, 23);
		contentPane.add(btnYourGames);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginView loginView=new LoginView();
				loginView.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setBounds(427, 401, 89, 23);
		contentPane.add(btnLogOut);
		
		JLabel lblYourUnit = new JLabel("Your unit:");
		lblYourUnit.setBounds(395, 11, 53, 14);
		contentPane.add(lblYourUnit);
		
		JLabel lblSetUnit = new JLabel(Float.toString(p.getAmountUnit()));
		lblSetUnit.setBounds(458, 11, 46, 14);
		contentPane.add(lblSetUnit);
		
		JButton btnAdminPanel = new JButton("Admin Panel");
		btnAdminPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanel a=new AdminPanel();
				a.setVisible(true);
				dispose();
			}
		});
		btnAdminPanel.setBounds(395, 132, 121, 23);
		if(p.getIsAdmin())
			contentPane.add(btnAdminPanel);
	}
}
