package Assignment;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DepositFrame {

	private JFrame frame;
	private JLabel lblEnterCustomerID;
	private JTextField textEnterCustomerID;
	private JButton btnSearch;
	private JLabel lblCurrentBalance;
	private JLabel lblOldBalance;
	private static Scanner x;
	private String foundCustNum;
	private String foundOldBalance;
	private JButton btn50;
	private JButton btnCreditAccount;
	private JButton btnSavingsAccount;
	private static String filePath;
	private static String workingFile;
	private JButton btn100;
	private JButton btn150;
	private JLabel lblQuickDeposit;
	private JLabel lblCustomDeposit;
	private JTextField txtValue;
	private JButton btnEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositFrame window = new DepositFrame();
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
	public DepositFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Deposit");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		btnCreditAccount = new JButton("Credit Account");
		btnCreditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filePath = "./src/Assignment/CreditAccount.txt";
				workingFile = "Credit";
				enableSearchButtons(); // Can be removed2
				btnSavingsAccount.setEnabled(false); // Can be removed2
			}
		});
		btnCreditAccount.setBounds(34, 11, 121, 23);
		frame.getContentPane().add(btnCreditAccount);

		btnSavingsAccount = new JButton("Savings Account");
		btnSavingsAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filePath = "./src/Assignment/SavingsAccount.txt";
				workingFile = "Savings";
				enableSearchButtons(); // Can be removed2
				btnCreditAccount.setEnabled(false); // Can be removed3
			}
		});
		btnSavingsAccount.setBounds(177, 11, 135, 23);
		frame.getContentPane().add(btnSavingsAccount);

		// Label for Enter Name
		lblEnterCustomerID = new JLabel("Enter Customer ID:");
		lblEnterCustomerID.setBounds(34, 50, 110, 14);
		frame.getContentPane().add(lblEnterCustomerID);
		// TextField for Enter Name
		textEnterCustomerID = new JTextField();
		textEnterCustomerID.setBounds(154, 47, 173, 20);
		frame.getContentPane().add(textEnterCustomerID);
		textEnterCustomerID.setColumns(10);

		// Button for Search
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Search for Balance
				String searchNum = textEnterCustomerID.getText();
				foundCustNum = "";
				foundOldBalance = "";
				boolean found = false;
				try {
					x = new Scanner(new File(filePath));
					x.useDelimiter("[,\n]");
					while (x.hasNext() && !found) {
						foundCustNum = x.next();
						foundOldBalance = x.next();

						if (foundCustNum.equals(searchNum)) {
							found = true;
						}

					}

					if (found) {
						lblOldBalance.setText(foundOldBalance);
						enableButtons(); // Can be removed1
					} else {
						JOptionPane.showMessageDialog(null, searchNum + " Not Found");
					}

				} catch (Exception e2) {
					System.out.println(e2);
				}
				x.close();
				// End of Search for Balance

			}
		});
		btnSearch.setBounds(337, 46, 89, 23);
		frame.getContentPane().add(btnSearch);

		lblCurrentBalance = new JLabel("Current Balance:");
		lblCurrentBalance.setBounds(34, 86, 101, 14);
		frame.getContentPane().add(lblCurrentBalance);

		lblOldBalance = new JLabel("");
		lblOldBalance.setBounds(154, 86, 81, 14);
		frame.getContentPane().add(lblOldBalance);

		btn50 = new JButton("$50");
		btn50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int oldBalanceInt = Integer.parseInt(foundOldBalance);
				int newBalance = oldBalanceInt + 50;
				String newBalanceS = Integer.toString(newBalance);
				editRecord(foundCustNum, newBalanceS);
				disableButtons(); // Can be removed1
				disableSearchButtons(); // Can be removed2
				enableAccountButtons(); // Can be removed3
				JOptionPane.showMessageDialog(null,
						"Customer Num " + foundCustNum + " " + workingFile + " Account new balance is: " + newBalanceS);

			}
		});
		btn50.setBounds(34, 140, 89, 23);
		frame.getContentPane().add(btn50);

		btn100 = new JButton("$100");
		btn100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int oldBalanceInt = Integer.parseInt(foundOldBalance);
				int newBalance = oldBalanceInt + 100;
				String newBalanceS = Integer.toString(newBalance);
				editRecord(foundCustNum, newBalanceS);
				disableButtons(); // Can be removed1
				disableSearchButtons(); // Can be removed2
				enableAccountButtons(); // Can be removed3
				JOptionPane.showMessageDialog(null,
						"Customer Num " + foundCustNum + " " + workingFile + " Account new balance is: " + newBalanceS);

			}
		});
		btn100.setBounds(156, 140, 89, 23);
		frame.getContentPane().add(btn100);

		btn150 = new JButton("$150");
		btn150.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int oldBalanceInt = Integer.parseInt(foundOldBalance);
				int newBalance = oldBalanceInt + 150;
				String newBalanceS = Integer.toString(newBalance);
				editRecord(foundCustNum, newBalanceS);
				disableButtons(); // Can be removed1
				disableSearchButtons(); // Can be removed2
				enableAccountButtons(); // Can be removed3
				JOptionPane.showMessageDialog(null,
						"Customer Num " + foundCustNum + " " + workingFile + " Account new balance is: " + newBalanceS);

			}
		});
		btn150.setBounds(279, 140, 89, 23);
		frame.getContentPane().add(btn150);

		lblQuickDeposit = new JLabel("Quick Deposit");
		lblQuickDeposit.setBounds(34, 115, 89, 14);
		frame.getContentPane().add(lblQuickDeposit);

		lblCustomDeposit = new JLabel("Custom Deposit");
		lblCustomDeposit.setBounds(34, 185, 101, 14);
		frame.getContentPane().add(lblCustomDeposit);

		txtValue = new JTextField();
		txtValue.setBounds(34, 210, 96, 20);
		frame.getContentPane().add(txtValue);
		txtValue.setColumns(10);

		btnEnter = new JButton("Deposit");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int oldBalanceInt = Integer.parseInt(foundOldBalance);
					int amountToDeposit = Integer.parseInt(txtValue.getText());
					int newBalance = oldBalanceInt + amountToDeposit;
					String newBalanceS = Integer.toString(newBalance);
					editRecord(foundCustNum, newBalanceS);
					disableButtons(); // Can be removed1
					disableSearchButtons(); // Can be removed2
					enableAccountButtons(); // Can be removed3
					JOptionPane.showMessageDialog(null, "Customer Num " + foundCustNum + " " + workingFile
							+ " Account new balance is: " + newBalanceS);
				} catch (Exception e4) {
					JOptionPane.showMessageDialog(null, "Invalid number!");
				}
			}
		});
		btnEnter.setBounds(156, 209, 89, 23);
		frame.getContentPane().add(btnEnter);

		disableButtons(); // Can be removed1
		disableSearchButtons(); // Can be removed2

	}

	private static void editRecord(String CustNum, String Balance) {
		String tempFile = "./src/Assignment/temp3.txt";
		// File oldFile = new File(filePath);
		// File newFile = new File(tempFile);

		String foundCustNum1 = "";
		String foundOldBalance1 = "";
		try {

			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			x = new Scanner(new File(filePath));
			x.useDelimiter("[,\n]");

			String creditInformation = CustNum + "," + Balance + "\n";

			while (x.hasNext()) {
				foundCustNum1 = x.next();
				foundOldBalance1 = x.next();

				if (foundCustNum1.equals(CustNum)) {
					pw.print(creditInformation);
				} else {
					pw.print(foundCustNum1 + "," + foundOldBalance1 + "\n");
				}
			}
			x.close();
			pw.flush();
			pw.close();

			File f1 = new File(filePath);
			f1.delete();
			File f2 = new File("./src/Assignment/temp3.txt");
			File f3 = new File(filePath);
			f2.renameTo(f3);
		} catch (Exception e3) {

		}
	}

	private void enableAccountButtons() {
		btnCreditAccount.setEnabled(true);
		btnSavingsAccount.setEnabled(true);
	}

	private void enableSearchButtons() { // Can be removed2
		lblEnterCustomerID.setEnabled(true);
		textEnterCustomerID.setEnabled(true);
		btnSearch.setEnabled(true);
	}

	private void disableSearchButtons() { // Can be removed2
		lblEnterCustomerID.setEnabled(false);
		textEnterCustomerID.setEnabled(false);
		btnSearch.setEnabled(false);
	}

	private void enableButtons() { // Can be removed1
		btn50.setEnabled(true);
		btn100.setEnabled(true);
		btn150.setEnabled(true);
		txtValue.setEnabled(true);
		btnEnter.setEnabled(true);
	}

	private void disableButtons() { // Can be removed1
		btn50.setEnabled(false);
		btn100.setEnabled(false);
		btn150.setEnabled(false);
		txtValue.setEnabled(false);
		btnEnter.setEnabled(false);
	}
}
