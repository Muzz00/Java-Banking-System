package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class UpdateFrame {

	private JFrame frame;
	private JTextField textEnterName;
	private static Scanner a;
	private JLabel lblCustomerNumber1;
	private JTextField txtName1;
	private JTextField txtStreet1;
	private JTextField txtPhoneNumber1;
	private JTextField txtAge1;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private static String filePath;
	private static String foundCustNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame window = new UpdateFrame();
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
	public UpdateFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Update Customer");
		frame.setBounds(100, 100, 450, 333);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		textEnterName = new JTextField();
		textEnterName.setBounds(116, 29, 154, 20);
		frame.getContentPane().add(textEnterName);
		textEnterName.setColumns(10);

		JLabel lblName = new JLabel("Enter Name:");
		lblName.setBounds(34, 32, 72, 14);
		frame.getContentPane().add(lblName);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Searching Customer
				foundCustNum = "";
				String foundName = "";
				String foundStreet = "";
				String foundPhoneNumber = "";
				String foundAge = "";
				String foundGender = "";
				String searchName = textEnterName.getText();
				boolean found = false;

				try {
					a = new Scanner(new File("./src/Assignment/CustomerInformation.txt"));
					a.useDelimiter("[,\n]");

					while (a.hasNext() && !found) {
						foundCustNum = a.next();
						foundName = a.next();
						foundStreet = a.next();
						foundPhoneNumber = a.next();
						foundAge = a.next();
						foundGender = a.next();
						if (foundName.equals(searchName)) {
							found = true;
						}

					}
					if (found) {
						lblCustomerNumber1.setText(foundCustNum);
						txtName1.setText(foundName);
						txtStreet1.setText(foundStreet);
						txtPhoneNumber1.setText(foundPhoneNumber);
						txtAge1.setText(foundAge);
						if (foundGender.equals("M")) {
							rdbtnMale.setSelected(true);
						} else {
							rdbtnFemale.setSelected(false);
						}

					} else {
						JOptionPane.showMessageDialog(null, searchName + " Not Found");
					}
				} catch (Exception e4) {
					System.out.println(e4);

				}
				a.close();

			}
		});
		btnSearch.setBounds(281, 28, 89, 23);
		frame.getContentPane().add(btnSearch);
		frame.setVisible(true);

		// Label for Customer Name
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(34, 107, 105, 14);
		frame.getContentPane().add(lblCustomerName);
		// Label for Output Name
		txtName1 = new JTextField("Name");
		txtName1.setBounds(172, 107, 177, 20);
		frame.getContentPane().add(txtName1);
		// Label for Street
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setBounds(34, 142, 49, 14);
		frame.getContentPane().add(lblStreet);
		// Label for Output Street
		txtStreet1 = new JTextField("Street");
		txtStreet1.setBounds(172, 142, 177, 20);
		frame.getContentPane().add(txtStreet1);
		frame.setVisible(true);
		// Label for Phone Number
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(34, 177, 105, 14);
		frame.getContentPane().add(lblPhoneNumber);
		// Label for Output Phone Number
		txtPhoneNumber1 = new JTextField("Phone Number");
		txtPhoneNumber1.setBounds(172, 177, 177, 20);
		frame.getContentPane().add(txtPhoneNumber1);
		// Label for Age
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(34, 202, 49, 20);
		frame.getContentPane().add(lblAge);
		// Label for Output Age
		txtAge1 = new JTextField("Age");
		txtAge1.setBounds(172, 202, 49, 20);
		frame.getContentPane().add(txtAge1);
		// Label for Gender
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(34, 238, 49, 14);
		frame.getContentPane().add(lblGender);
		// Label for Customer Number
		JLabel lblCustomerNumber = new JLabel("Customer Number: ");
		lblCustomerNumber.setBounds(34, 75, 115, 14);
		frame.getContentPane().add(lblCustomerNumber);
		// Label for Output Customer Number
		lblCustomerNumber1 = new JLabel("Customer Number");
		lblCustomerNumber1.setBounds(172, 75, 105, 20);
		frame.getContentPane().add(lblCustomerNumber1);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtAge1.getText().matches("^[0-9]*$")) {
					JOptionPane.showMessageDialog(null, "Please enter only numbers for Age");
				} else if (txtAge1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "There is an empty field!");
				} else if (!(Integer.parseInt(txtAge1.getText()) > 0 && Integer.parseInt(txtAge1.getText()) < 150)) {
					JOptionPane.showMessageDialog(null, "Please enter an appropriate value for age!");
				} else if (!txtName1.getText().matches("^[a-zA-Z ]*$")) {
					JOptionPane.showMessageDialog(null, "Please enter only alphabhets for name!");
				} else if (!txtPhoneNumber1.getText().matches("^[0-9]*$")) {
					JOptionPane.showMessageDialog(null, "Please enter only numbers for Phone Number");
				} else if (!txtName1.getText().equals("") && !txtStreet1.getText().equals("")
						&& !txtPhoneNumber1.getText().equals("") && !txtAge1.getText().equals("")
						&& (rdbtnMale.isSelected() || rdbtnFemale.isSelected())) {
					
					filePath = "./src/Assignment/CustomerInformation.txt";
					String[] info = new String[5];
					info[0] = txtName1.getText();
					info[1] = txtStreet1.getText();
					info[2] = txtPhoneNumber1.getText();
					info[3] = txtAge1.getText();
					info[4] = "";
					if (rdbtnMale.isSelected()) {
						info[4] = "M";
					} else if (rdbtnFemale.isSelected()) {
						info[4] = "F";
					}
					editRecord(foundCustNum, info);
					JOptionPane.showMessageDialog(null, "The information has been updated");
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "There is an empty field!");
				}
			}
		});
		btnSave.setBounds(337, 262, 89, 23);
		frame.getContentPane().add(btnSave);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFemale.setSelected(false);
			}
		});
		rdbtnMale.setBounds(172, 229, 111, 23);
		frame.getContentPane().add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMale.setSelected(false);
			}
		});
		rdbtnFemale.setBounds(172, 255, 111, 23);
		frame.getContentPane().add(rdbtnFemale);

	}

	private static void editRecord(String CustNum, String[] info) {
		String tempFile = "./src/Assignment/temp1.txt";
		String foundCustNum2 = "";
		String foundName1 = "";
		String foundStreet1 = "";
		String foundPhoneNumber1 = "";
		String foundAge1 = "";
		String foundGender1 = "";
		try {

			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			a = new Scanner(new File(filePath));
			a.useDelimiter("[,\n]");

			String newInformation = CustNum + "," + info[0] + "," + info[1] + "," + info[2] + "," + info[3] + ","
					+ info[4] + "\n";

			while (a.hasNext()) {
				foundCustNum2 = a.next();
				foundName1 = a.next();
				foundStreet1 = a.next();
				foundPhoneNumber1 = a.next();
				foundAge1 = a.next();
				foundGender1 = a.next();

				String oldInformation = foundCustNum2 + "," + foundName1 + "," + foundStreet1 + "," + foundPhoneNumber1
						+ "," + foundAge1 + "," + foundGender1 + "\n";
				if (foundCustNum2.equals(CustNum)) {
					pw.print(newInformation);
				} else {
					pw.print(oldInformation);
				}
			}
			a.close();
			pw.flush();
			pw.close();

			File f1 = new File(filePath);
			f1.delete();
			File f2 = new File("./src/Assignment/temp1.txt");
			File f3 = new File(filePath);
			f2.renameTo(f3);
		} catch (Exception e3) {

		}
	}
}
