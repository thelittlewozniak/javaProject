package be.nathanPire.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.PlayerBusiness;
import be.nathanPire.pojo.Player;

public class ReservationViewDetailes extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ReservationViewDetailes(Player p,int index) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 302, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblNameOfThe = new JLabel("Name of the Game:");
		lblNameOfThe.setBounds(10, 36, 125, 14);
		contentPane.add(lblNameOfThe);
		
		JLabel lblUnitPerWeek = new JLabel("Unit per week:");
		lblUnitPerWeek.setBounds(10, 61, 125, 14);
		contentPane.add(lblUnitPerWeek);
		
		JLabel lblDateAsked = new JLabel("Date asked:");
		lblDateAsked.setBounds(10, 86, 125, 14);
		contentPane.add(lblDateAsked);
		
		JButton btnCancelReservation = new JButton("Cancel Reservation");
		btnCancelReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerBusiness pb=new PlayerBusiness();
				var player=pb.removeAReservation(p, p.getReservation().get(index).getID());
				HomeView h=new HomeView(player);
				h.setVisible(true);
				dispose();
			}
		});
		btnCancelReservation.setBounds(10, 111, 125, 23);
		contentPane.add(btnCancelReservation);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReservationView r=new ReservationView(p);
				r.setVisible(true);
				dispose();
				
			}
		});
		btnClose.setBounds(145, 111, 89, 23);
		contentPane.add(btnClose);
				
		JLabel lblSetNameGame = new JLabel(p.getReservation().get(index).getGameWanted().getName());
		lblSetNameGame.setBounds(151, 36, 125, 14);
		contentPane.add(lblSetNameGame);
		
		JLabel lblUnitWeek = new JLabel(Float.toString(p.getReservation().get(index).getGameWanted().getUnit()));
		lblUnitWeek.setBounds(151, 61, 125, 14);
		contentPane.add(lblUnitWeek);
		
		JLabel lblSetDate = new JLabel(p.getReservation().get(index).getBeginDateWanted().toString());
		lblSetDate.setBounds(151, 86, 125, 14);
		contentPane.add(lblSetDate);
	}

}
