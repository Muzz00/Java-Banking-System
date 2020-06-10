package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankAccount {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccount window = new BankAccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Bank Account");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //CAN BE REMOVED
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFrame addFrame = new AddFrame();
				
			}
		});
		btnAdd.setBounds(62, 54, 105, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchFrame searchFrame = new SearchFrame();
			}
		});
		btnSearch.setBounds(233, 54, 105, 23);
		frame.getContentPane().add(btnSearch);
		
		
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawFrame withdrawFrame = new WithdrawFrame();
			}
		});
		btnWithdraw.setBounds(233, 103, 105, 23);
		frame.getContentPane().add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositFrame depositFrame = new DepositFrame();
			}
		});
		btnDeposit.setBounds(62, 103, 105, 23);
		frame.getContentPane().add(btnDeposit);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateFrame updateFrame = new UpdateFrame();
			}
		});
		btnUpdate.setBounds(62, 154, 105, 23);
		frame.getContentPane().add(btnUpdate);
		
		
	}
}
