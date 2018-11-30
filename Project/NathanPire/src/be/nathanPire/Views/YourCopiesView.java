package be.nathanPire.Views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import be.nathanPire.pojo.Game;
import be.nathanPire.pojo.Player;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YourCopiesView extends JFrame {

	private static final long serialVersionUID = 5546651156014597767L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public YourCopiesView(Player p) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i=0;i<p.getCopies().size();i++) {
			listModel.addElement(p.getCopies().get(i).getGame().getName()+" "+p.getCopies().get(i).getGame().getConsole());
		}
		JList list = new JList(listModel);
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	int index = list.locationToIndex(evt.getPoint());
		        	CopyView copyView=new CopyView(p,index);
		        	copyView.setVisible(true);
		            dispose();
		        }
		    }
		});
		list.setBounds(10, 11, 414, 205);
		contentPane.add(list);
		
		JButton btnAddANew = new JButton("Add a new game");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddANewCopyView addCopy=new AddANewCopyView(p);
				addCopy.setVisible(true);
				dispose();
			}
		});
		btnAddANew.setBounds(10, 227, 162, 23);
		contentPane.add(btnAddANew);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeView h=new HomeView(p);
				h.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(335, 227, 89, 23);
		contentPane.add(btnClose);
	}
}
