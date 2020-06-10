package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class SearchFrame {

	private JFrame frame;
	private JTextField textEnterName;
	private JLabel lblCustomerNumber1;
	private JLabel lblName1;
	private JLabel lblStreet1;
	private JLabel lblPhoneNumber1;
	private JLabel lblAge1;
	private JLabel lblGender1;
	private static Scanner x;
	private JLabel lblCreditBalance;
	private JLabel lblSavingsBalance;
	private static Scanner y;
	private static Scanner z;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame window = new SearchFrame();
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
	public SearchFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Search Customer");
		frame.setBounds(100, 100, 450, 365);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		//Label for Enter Name
		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setBounds(34, 27, 89, 14);
		frame.getContentPane().add(lblEnterName);
		//TextField for Enter Name
		textEnterName = new JTextField();
		textEnterName.setBounds(141, 24, 186, 20);
		frame.getContentPane().add(textEnterName);
		textEnterName.setColumns(10);
		//Button for Search
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Searching for Customer Information
				String foundCustNum = "";
				String foundName = "";
				String foundStreet = "";
				String foundPhoneNumber = "";
				String foundAge = "";
				String foundGender = "";
				String searchName = textEnterName.getText();
				boolean found = false;
				
				try {
					x = new Scanner(new File("./src/Assignment/CustomerInformation.txt"));
					x.useDelimiter("[,\n]");
					while(x.hasNext() && !found) {
						foundCustNum = x.next();
						foundName = x.next();
						foundStreet = x.next();
						foundPhoneNumber = x.next();
						foundAge = x.next();
						foundGender = x.next();
						
						if (foundName.equals(searchName)) {
							found = true;
						}
					}
					if (found) {
						lblCustomerNumber1.setText(foundCustNum);
						lblName1.setText(foundName);
						lblStreet1.setText(foundStreet);
						lblPhoneNumber1.setText(foundPhoneNumber);
						lblAge1.setText(foundAge);
						if (foundGender.equals("M")) {
							lblGender1.setText("Male");
						}else {
							lblGender1.setText("Female");
						}
						x.close();
						//End of search for Customer Information
						//Search for Credit Balance
						String searchNum = foundCustNum;
						String foundCNum = "";
						String foundBalance1 = "";
						boolean found1 = false;
						try {
							y = new Scanner(new File("./src/Assignment/CreditAccount.txt"));
							y.useDelimiter("[,\n]");
							while(y.hasNext() && !found1) {
								foundCNum = y.next();
								foundBalance1 = y.next();
								
								if(foundCNum.equals(searchNum)) {
									found1 = true;
								}
							}
							if (found1) {
								lblCreditBalance.setText(foundBalance1);
							}else {
								JOptionPane.showMessageDialog(null, searchNum + " Not Found");
							}
							
						}catch(Exception e2){
							System.out.println(e2);
						}
						y.close();
						//End of Search for Credit Balance
						
						
						//Search for Savings Balance
						String searchNum2 = foundCustNum;
						String foundCNum2 = "";
						String foundBalance2 = "";
						boolean found2 = false;
						try {
							
							z = new Scanner(new File("./src/Assignment/SavingsAccount.txt"));
							z.useDelimiter("[,\n]");
							while(z.hasNext() && !found2) {
								foundCNum2 = z.next();
								foundBalance2 = z.next();								
								if(foundCNum2.equals(searchNum2)) {
									found2 = true;
								}
							}
							if (found2) {
								lblSavingsBalance.setText(foundBalance2);
							}else {
								JOptionPane.showMessageDialog(null, searchNum + " Not Found");
							}
							
						}catch(Exception e2){
							System.out.println(e2);
						}
						z.close();
						//End of Search for Savings Balance
						
					}else {
						JOptionPane.showMessageDialog(null, searchName + " not found");
					}
				}catch(Exception e2) {
					
				}
				
				}
			});
		btnSearch.setBounds(337, 23, 89, 23);
		frame.getContentPane().add(btnSearch);
		//Label for Customer Name
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(34, 107, 105, 14);
		frame.getContentPane().add(lblCustomerName);
		//Label for Output Name
		lblName1 = new JLabel("Name");
		lblName1.setBounds(172, 107, 177, 14);
		frame.getContentPane().add(lblName1);
		//Label for Street
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setBounds(34, 142, 49, 14);
		frame.getContentPane().add(lblStreet);
		//Label for Output Street
		lblStreet1 = new JLabel("Street");
		lblStreet1.setBounds(172, 142, 177, 14);
		frame.getContentPane().add(lblStreet1);
		frame.setVisible(true);
		//Label for Phone Number
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(34, 177, 105, 14);
		frame.getContentPane().add(lblPhoneNumber);
		//Label for Output Phone Number
		lblPhoneNumber1 = new JLabel("Phone Number");
		lblPhoneNumber1.setBounds(172, 177, 177, 14);
		frame.getContentPane().add(lblPhoneNumber1);
		//Label for Age
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(34, 202, 49, 20);
		frame.getContentPane().add(lblAge);
		//Label for Output Age
		lblAge1 = new JLabel("Age");
		lblAge1.setBounds(172, 202, 49, 14);
		frame.getContentPane().add(lblAge1);
		//Label for Gender
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(34, 238, 49, 14);
		frame.getContentPane().add(lblGender);
		//Label for Output Gender
		lblGender1 = new JLabel("Gender");
		lblGender1.setBounds(172, 238, 49, 14);
		frame.getContentPane().add(lblGender1);
		//Label for Customer Number
		JLabel lblCustomerNumber = new JLabel("Customer Number: ");
		lblCustomerNumber.setBounds(34, 75, 115, 14);
		frame.getContentPane().add(lblCustomerNumber);
		//Label for Output Customer Number
		lblCustomerNumber1 = new JLabel("Customer Number");
		lblCustomerNumber1.setBounds(172, 75, 105, 14);
		frame.getContentPane().add(lblCustomerNumber1);
		//Label for Credit Account Balance
		JLabel lblCreditAccountBalance = new JLabel("Credit Account Balance:");
		lblCreditAccountBalance.setBounds(34, 269, 155, 14);
		frame.getContentPane().add(lblCreditAccountBalance);
		//Label for Output Credit Account Balance
		lblCreditBalance = new JLabel("$0");
		lblCreditBalance.setBounds(205, 269, 49, 14);
		frame.getContentPane().add(lblCreditBalance);
		//Label for Savings Account Balance
		JLabel lblSavingsAccountBalance = new JLabel("Savings Account Balance:");
		lblSavingsAccountBalance.setBounds(34, 295, 155, 22);
		frame.getContentPane().add(lblSavingsAccountBalance);
		//Label for Output Savings Account Balance
		lblSavingsBalance = new JLabel("$0");
		lblSavingsBalance.setBounds(205, 294, 49, 23);
		frame.getContentPane().add(lblSavingsBalance);
		
		
	}
}
