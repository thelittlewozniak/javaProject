package be.nathanPire.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.LoanBusiness;
import be.nathanPire.pojo.Loan;
import be.nathanPire.pojo.Player;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoansView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5156754598740575239L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public LoansView(Player p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		LoanBusiness lB=new LoanBusiness();
		List<Loan> loans=lB.getLoanByPlayer(p);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i=0;i<loans.size();i++) {
			listModel.addElement("Name: "+loans.get(i).getCopy().getGame().getName()+" Begin Date:"+loans.get(i).getBeginDate()+" End date:"+loans.get(i).getEndDate());
		}
		JList list = new JList(listModel);
		list.setBounds(10, 11, 414, 454);
		contentPane.add(list);

		JButton btnClose = new JButton("close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeView h=new HomeView(p);
				h.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(335, 476, 89, 23);
		contentPane.add(btnClose);
	}
}
