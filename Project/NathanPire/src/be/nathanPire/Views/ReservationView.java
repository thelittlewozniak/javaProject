package be.nathanPire.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.pojo.Player;

public class ReservationView extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ReservationView(Player p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i=0;i<p.getReservation().size();i++) {
			listModel.addElement(p.getReservation().get(i).getGameWanted().getName());
		}
		JList list = new JList(listModel);
		list.setBounds(10, 11, 267, 205);
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	int index = list.locationToIndex(evt.getPoint());
		            ReservationViewDetailes r=new ReservationViewDetailes(p,index);
		            r.setVisible(true);
		            dispose();
		        }
		    }
		});
		contentPane.add(list);
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeView h=new HomeView(p);
				h.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(10, 227, 267, 23);
		contentPane.add(btnClose);
			}
}