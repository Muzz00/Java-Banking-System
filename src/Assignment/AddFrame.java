package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AddFrame {

	private JFrame frame;
	private JTextField textName;
	private String[] customer = new String[6];
	private JButton btnSave;
	private JLabel lblStreet;
	private JTextField textStreet;
	private JLabel lblCustomerNumber;
	private JLabel lblCustomerNumber1;
	private JLabel lblAge;
	private JTextField textAge;
	private JLabel lblPhoneNumber;
	private JTextField textPhoneNumber;
	private JLabel lblGender;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	public static int success = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame window = new AddFrame();
					window.frame.setVisible(true);
					// success = 1;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// return success;
	}

	/**
	 * Create the application.
	 */
	public AddFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Customer");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		// Getting Automated Customer Number
		String custNum = "1";
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./src/Assignment/CustomerInformation.txt"));
			String row;
			String[] data;
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			while ((row = csvReader.readLine()) != null) {
				data = row.split(",");
				String numString = data[0];
				int numInt = Integer.parseInt(numString);
				numbers.add(numInt);
			}
			int highestNum = numbers.get(0);
			for (int i = 0; i < numbers.size(); i++) {
				if (numbers.get(i) > highestNum) {
					highestNum = numbers.get(i);
				}
				int custNumInt = highestNum + 1;
				custNum = Integer.toString(custNumInt);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		// END OF Automation for Customer Number

		// Label for Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(59, 40, 49, 14);
		frame.getContentPane().add(lblName);
		// TextField for Name
		textName = new JTextField();
		textName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textName.setBounds(171, 37, 206, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		// Label for Street
		lblStreet = new JLabel("Street:");
		lblStreet.setBounds(59, 73, 49, 14);
		frame.getContentPane().add(lblStreet);
		// TextField for Street
		textStreet = new JTextField();
		textStreet.setBounds(171, 70, 206, 20);
		frame.getContentPane().add(textStreet);
		textStreet.setColumns(10);
		// Label for Customer Number
		lblCustomerNumber = new JLabel("Customer Number:");
		lblCustomerNumber.setBounds(59, 11, 111, 14);
		frame.getContentPane().add(lblCustomerNumber);
		// Label for Customer Number
		lblCustomerNumber1 = new JLabel(custNum);
		lblCustomerNumber1.setBounds(183, 11, 49, 14);
		frame.getContentPane().add(lblCustomerNumber1);
		// Label for Age
		lblAge = new JLabel("Age:");
		lblAge.setBounds(59, 138, 49, 14);
		frame.getContentPane().add(lblAge);
		// TextField for Age
		textAge = new JTextField();
		textAge.setBounds(171, 135, 49, 20);
		frame.getContentPane().add(textAge);
		textAge.setColumns(10);
		// Label for Phone Number
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(59, 104, 89, 14);
		frame.getContentPane().add(lblPhoneNumber);
		// TextField for Phone Number
		textPhoneNumber = new JTextField();
		textPhoneNumber.setBounds(171, 101, 118, 20);
		frame.getContentPane().add(textPhoneNumber);
		textPhoneNumber.setColumns(10);
		// Label for Gender
		lblGender = new JLabel("Gender:");
		lblGender.setBounds(59, 173, 49, 14);
		frame.getContentPane().add(lblGender);
		// RadioButton for Male
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFemale.setSelected(false);
			}
		});
		rdbtnMale.setBounds(171, 169, 111, 23);
		frame.getContentPane().add(rdbtnMale);
		// RadioButton for Female
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMale.setSelected(false);
				// rdbtnMale.setEnabled(false); //CAN BE USED FOR THE SAVE BUTTON
			}
		});
		rdbtnFemale.setBounds(171, 195, 111, 23);
		frame.getContentPane().add(rdbtnFemale);

		// Button for Save
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textAge.getText().matches("^[0-9]*$")) {
					JOptionPane.showMessageDialog(null, "Please enter only numbers for Age");
				} else if (textAge.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "There is an empty field!");
				} else if (!(Integer.parseInt(textAge.getText()) > 0 && Integer.parseInt(textAge.getText()) < 150)) {
					JOptionPane.showMessageDialog(null, "Please enter an appropriate value for age!");
				} else if (!textName.getText().matches("^[a-zA-Z ]*$")) {
					JOptionPane.showMessageDialog(null, "Please enter only alphabhets for name!");
				} else if (!textPhoneNumber.getText().matches("^[0-9]*$")) {
					JOptionPane.showMessageDialog(null, "Please enter only numbers for Phone Number");
				} else if (!textName.getText().equals("") && !textStreet.getText().equals("")
						&& !textPhoneNumber.getText().equals("") && !textAge.getText().equals("")
						&& (rdbtnMale.isSelected() || rdbtnFemale.isSelected())) {

					customer[0] = lblCustomerNumber1.getText();
					customer[1] = textName.getText();
					customer[2] = textStreet.getText();
					customer[3] = textPhoneNumber.getText();
					customer[4] = textAge.getText();

					if (rdbtnMale.isSelected()) {
						customer[5] = "M";
					} else if (rdbtnFemale.isSelected()) {
						customer[5] = "F";
					} else {
						JOptionPane.showMessageDialog(null, "Please select Gender");
					}

					// Writing to CustomerInformation File
					String textToAppend = customer[0] + "," + customer[1] + "," + customer[2] + "," + customer[3] + ","
							+ customer[4] + "," + customer[5] + "\n";
					try {
						File file = new File("./src/Assignment/CustomerInformation.txt");
						FileWriter fr = new FileWriter(file, true);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(textToAppend);
						br.close();
						fr.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Writing to CreditAccount File
					String CreditInformation = customer[0] + "," + "0" + "\n";
					try {
						File file = new File("./src/Assignment/CreditAccount.txt");
						FileWriter fr = new FileWriter(file, true);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(CreditInformation);
						br.close();
						fr.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Writing to SavingsAccount File
					String SavingsInformation = customer[0] + "," + "0" + "\n";
					try {
						File file = new File("./src/Assignment/SavingsAccount.txt");
						FileWriter fr = new FileWriter(file, true);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(SavingsInformation);
						br.close();
						fr.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The new customer has been saved.");

					btnSave.setEnabled(false);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "There is an empty field!");
				}
			}
		});
		btnSave.setBounds(311, 229, 89, 23);
		frame.getContentPane().add(btnSave);

	}
}
