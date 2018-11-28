package be.nathanPire.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.CopyBusiness;
import be.nathanPire.pojo.Game;
import be.nathanPire.pojo.Player;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameView extends JFrame {

	private JPanel contentPane;
	private Player p;
	/**
	 * Create the frame.
	 */
	public GameView(Player p,Game g) {
		this.p=p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGame = new JLabel("Game");
		lblGame.setBounds(10, 11, 46, 14);
		contentPane.add(lblGame);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 36, 80, 14);
		contentPane.add(lblName);
		
		JLabel lblDevelopers = new JLabel("Developers:");
		lblDevelopers.setBounds(10, 61, 80, 14);
		contentPane.add(lblDevelopers);
		
		JLabel lblEditors = new JLabel("Editors:");
		lblEditors.setBounds(10, 86, 80, 14);
		contentPane.add(lblEditors);
		
		JLabel lblUnit = new JLabel("Unit:");
		lblUnit.setBounds(10, 111, 80, 14);
		contentPane.add(lblUnit);
		
		JLabel lblSetName = new JLabel();
		lblSetName.setBounds(100, 36, 174, 14);
		lblSetName.setText(g.getName());
		contentPane.add(lblSetName);
		
		JLabel lblSetDevelopers = new JLabel();
		lblSetDevelopers.setBounds(100, 61, 174, 14);
		lblSetDevelopers.setText(g.getDevelopers());
		contentPane.add(lblSetDevelopers);
		
		JLabel lblSetEditors = new JLabel();
		lblSetEditors.setBounds(100, 86, 174, 14);
		lblSetEditors.setText(g.getEditors());
		contentPane.add(lblSetEditors);
		
		JLabel lblSetUnit = new JLabel();
		lblSetUnit.setBounds(100, 111, 174, 14);
		lblSetUnit.setText(Float.toString(g.getUnit()));
		contentPane.add(lblSetUnit);
		
		JButton btnMakeAReservation = new JButton("Make a reservation");
		btnMakeAReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MakeReservationView mr=new MakeReservationView(p,g);
				mr.setVisible(true);
				dispose();
			}
		});
		btnMakeAReservation.setBounds(10, 238, 174, 23);
		contentPane.add(btnMakeAReservation);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeView h=new HomeView(p);
				h.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(194, 238, 80, 23);
		contentPane.add(btnClose);
		
		JLabel lblNumberAvailable = new JLabel("Available :");
		lblNumberAvailable.setBounds(10, 136, 80, 14);
		contentPane.add(lblNumberAvailable);
		
		JLabel lblSetAvailabe = new JLabel();
		lblSetAvailabe.setBounds(100, 136, 174, 14);
		lblSetAvailabe.setText(Integer.toString(new CopyBusiness().getNumberOfCopy(g)));
		contentPane.add(lblSetAvailabe);
	}
}
