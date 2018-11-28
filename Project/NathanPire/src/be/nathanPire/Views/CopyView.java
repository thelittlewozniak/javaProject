package be.nathanPire.Views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.BusinessLayer.LoanBusiness;
import be.nathanPire.pojo.Player;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CopyView extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CopyView(Player p,int index) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNameOfThe = new JLabel("Name of the game:");
		lblNameOfThe.setBounds(10, 11, 125, 14);
		contentPane.add(lblNameOfThe);
		
		JLabel lblNewLabel = new JLabel("Date added");
		lblNewLabel.setBounds(10, 36, 125, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCheckIfAvailable = new JButton("check if Reservations available");
		btnCheckIfAvailable.setBounds(10, 153, 200, 23);
		contentPane.add(btnCheckIfAvailable);
		
		JButton btnFinishLoan = new JButton("Finish Loan");
		btnFinishLoan.setBounds(10, 187, 200, 23);
		contentPane.add(btnFinishLoan);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(220, 153, 89, 23);
		contentPane.add(btnClose);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(220, 187, 89, 23);
		contentPane.add(btnRemove);
		
		JLabel lblSetNameOfGame = new JLabel(p.getCopies().get(index).getGame().getName());
		lblSetNameOfGame.setBounds(145, 11, 164, 14);
		contentPane.add(lblSetNameOfGame);
		
		JLabel lblSetDateAdded = new JLabel(p.getCopies().get(index).getAddDate().toString());
		lblSetDateAdded.setBounds(145, 36, 164, 14);
		contentPane.add(lblSetDateAdded);
		
		JLabel lblLeased = new JLabel("Leased:");
		lblLeased.setBounds(10, 61, 125, 14);
		contentPane.add(lblLeased);
		LoanBusiness loanB=new LoanBusiness();
		
		JLabel lblSetLeased = new JLabel(Boolean.toString(loanB.Loaned(p.getCopies().get(index))));
		lblSetLeased.setBounds(145, 61, 164, 14);
		contentPane.add(lblSetLeased);
	}
}
