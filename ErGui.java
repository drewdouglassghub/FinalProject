package finalProject;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import java.awt.List;
import java.awt.Panel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JProgressBar;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JSpinner;

public class ErGui {

	private JFrame frame;
	static JTextField txtLastName;
	static JTextField txtZipcode;
	static JTextField DOB;
	static JTextField txtFirstName;
	static JTextField txtStreetAddress1;
	static JTextField txtStreetAddress2;
	static JTextField txtHomePhone;
	static JTextField txtWorkPhone;
	static JTextField txtCellPhone;
	static JTextField txtEmail;
	static JTextField txtInsuranceName;
	static JTextField txtInsuredFirst;
	static JTextField txtInsuredLast;
	static JTextField txtInsuredStreet;
	static JTextField txtGroupNum;
	static JTextField txtPolicyNum;
	static JTextField txtInsuredZip;
	static JTextField txtInsuredApt;
	static JComboBox comboTriage = new JComboBox();
	static JComboBox comboBoxState = new JComboBox();
	static JComboBox comboGender = new JComboBox();
	static DateFormat dFormat = new SimpleDateFormat("MM/dd/yy");
	static JFormattedTextField txtDOB = new JFormattedTextField(dFormat);
	static JButton btnCreatePatient = new JButton("Create");
	
	static List lstEmergentList = new List();
	static JTextField txtCoPay;
	static JTextField txtHolderDOB;
	static ListSelectionModel selectionModel;
	
	static int dailyPatientCount = 106;
	
	public List getEmergentQueue(java.util.List<Patient> patientList) {
		
		return lstEmergentList;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErGui window = new ErGui();
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
	public ErGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(false);
		frame.setVisible(true);
		frame.setBounds(100, 100, 1080, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, lstEmergentList, 735, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lstEmergentList, -21, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		
		JPanel pnlPatientInfo = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, pnlPatientInfo, 21, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pnlPatientInfo, -289, SpringLayout.SOUTH, frame.getContentPane());
		pnlPatientInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(pnlPatientInfo);
		SpringLayout sl_pnlPatientInfo = new SpringLayout();
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, comboGender, 0, SpringLayout.SOUTH, comboBoxState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, comboBoxState, 245, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, comboGender, 260, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtDOB, 140, SpringLayout.NORTH, pnlPatientInfo);
		pnlPatientInfo.setLayout(sl_pnlPatientInfo);
		
		JLabel lblPatientHeader = new JLabel("Patient Information");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblPatientHeader, 4, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, lblPatientHeader, 10, SpringLayout.WEST, pnlPatientInfo);
		lblPatientHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlPatientInfo.add(lblPatientHeader);
		
		JLabel lblPatientMRN = new JLabel("Patient MRN");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblPatientMRN, 12, SpringLayout.SOUTH, lblPatientHeader);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, lblPatientMRN, 48, SpringLayout.WEST, pnlPatientInfo);
		lblPatientMRN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblPatientMRN);
		
		JLabel lblFirstName = new JLabel("First Name");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblFirstName, 16, SpringLayout.SOUTH, lblPatientMRN);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblLastName, 18, SpringLayout.SOUTH, lblFirstName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblDateOfBirth, 18, SpringLayout.SOUTH, lblLastName);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblDateOfBirth);
		
		JLabel lblStreetAddress1 = new JLabel("Street Address 1");
		lblStreetAddress1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblStreetAddress1);
		
		JLabel lblState = new JLabel("State");
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, comboBoxState, 10, SpringLayout.EAST, lblState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, comboBoxState, 0, SpringLayout.SOUTH, lblState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblState, -55, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblState, -361, SpringLayout.EAST, pnlPatientInfo);
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblState);
		
		txtLastName = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblLastName, -6, SpringLayout.WEST, txtLastName);
		pnlPatientInfo.add(txtLastName);
		txtLastName.setColumns(10);
		
		//Patient DOB setup and layout

		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblDateOfBirth, -6, SpringLayout.WEST, txtDOB);
		TextPrompt tpDate =  new TextPrompt("MM/DD/YYYY", txtDOB);
		tpDate.setHorizontalAlignment(SwingConstants.LEADING);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtLastName, -15, SpringLayout.NORTH, txtDOB);
		pnlPatientInfo.add(txtDOB);
		txtDOB.setColumns(10);
		
		txtZipcode = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtZipcode, -38, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtZipcode, -18, SpringLayout.SOUTH, pnlPatientInfo);
		pnlPatientInfo.add(txtZipcode);
		txtZipcode.setColumns(10);
		
		JLabel lblPatientZipcode = new JLabel("Zip");
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblPatientZipcode, -19, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtZipcode, 70, SpringLayout.EAST, lblPatientZipcode);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblPatientZipcode, -361, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtZipcode, 6, SpringLayout.EAST, lblPatientZipcode);
		lblPatientZipcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblPatientZipcode);
		
		txtFirstName = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblFirstName, -6, SpringLayout.WEST, txtFirstName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtLastName, 15, SpringLayout.SOUTH, txtFirstName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtFirstName, -228, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtFirstName, 70, SpringLayout.NORTH, pnlPatientInfo);
		pnlPatientInfo.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JPanel pnlInsuranceInfo = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, pnlInsuranceInfo, 0, SpringLayout.NORTH, lstEmergentList);
		springLayout.putConstraint(SpringLayout.WEST, pnlInsuranceInfo, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pnlInsuranceInfo, 0, SpringLayout.SOUTH, lstEmergentList);
		pnlInsuranceInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblStreetAddress2 = new JLabel("Street Address 2");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblStreetAddress2, 210, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblStreetAddress2, -19, SpringLayout.NORTH, lblState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblStreetAddress1, -19, SpringLayout.NORTH, lblStreetAddress2);
		lblStreetAddress2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblStreetAddress2);
		
		txtStreetAddress1 = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtDOB, -17, SpringLayout.NORTH, txtStreetAddress1);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblStreetAddress1, -8, SpringLayout.WEST, txtStreetAddress1);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtStreetAddress1, 131, SpringLayout.WEST, pnlPatientInfo);
		pnlPatientInfo.add(txtStreetAddress1);
		txtStreetAddress1.setColumns(10);
		
		txtStreetAddress2 = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtStreetAddress2, 210, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtStreetAddress2, -92, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtStreetAddress1, -17, SpringLayout.NORTH, txtStreetAddress2);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblStreetAddress2, -8, SpringLayout.WEST, txtStreetAddress2);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtStreetAddress2, 131, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtStreetAddress2, -39, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(txtStreetAddress2);
		txtStreetAddress2.setColumns(10);
		comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		pnlPatientInfo.add(comboBoxState);
		
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblPatientMRN, -112, SpringLayout.WEST, lblHomePhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblHomePhone, 38, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblHomePhone, -170, SpringLayout.EAST, pnlPatientInfo);
		lblHomePhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblHomePhone);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtFirstName, -108, SpringLayout.WEST, lblWorkPhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtFirstName, -22, SpringLayout.WEST, lblWorkPhone);
		lblWorkPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblWorkPhone, 3, SpringLayout.NORTH, lblFirstName);
		pnlPatientInfo.add(lblWorkPhone);
		
		JLabel lblCellPhone = new JLabel("Cell Phone");
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtLastName, -122, SpringLayout.WEST, lblCellPhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtLastName, -36, SpringLayout.WEST, lblCellPhone);
		lblCellPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblCellPhone, 3, SpringLayout.NORTH, lblLastName);
		pnlPatientInfo.add(lblCellPhone);
		
		JLabel lblEmail = new JLabel("Email");
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, lblEmail, 282, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtDOB, -151, SpringLayout.WEST, lblEmail);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtDOB, -65, SpringLayout.WEST, lblEmail);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblEmail, 0, SpringLayout.NORTH, lblDateOfBirth);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblEmail);
		
		txtHomePhone = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtHomePhone, 35, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtHomePhone, -164, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtHomePhone, -78, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(txtHomePhone);
		txtHomePhone.setColumns(10);
		
		txtWorkPhone = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtHomePhone, -15, SpringLayout.NORTH, txtWorkPhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblWorkPhone, -6, SpringLayout.WEST, txtWorkPhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtWorkPhone, 70, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtWorkPhone, -164, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtWorkPhone, -78, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(txtWorkPhone);
		txtWorkPhone.setColumns(10);
		
		txtCellPhone = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtCellPhone, 105, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtWorkPhone, -15, SpringLayout.NORTH, txtCellPhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblCellPhone, -6, SpringLayout.WEST, txtCellPhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtCellPhone, -164, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtCellPhone, -78, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(txtCellPhone);
		txtCellPhone.setColumns(10);
		
		txtEmail = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtEmail, 140, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtEmail, -158, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtStreetAddress1, 15, SpringLayout.SOUTH, txtEmail);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtStreetAddress1, 0, SpringLayout.EAST, txtEmail);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtCellPhone, -15, SpringLayout.NORTH, txtEmail);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblEmail, -6, SpringLayout.WEST, txtEmail);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtEmail, 322, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtEmail, -39, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(txtEmail);
		txtEmail.setColumns(10);
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		pnlPatientInfo.add(comboGender);
		
		JLabel lblGender = new JLabel("Gender");
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblGender, -55, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblGender, -6, SpringLayout.WEST, comboGender);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, comboBoxState, -31, SpringLayout.WEST, lblGender);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblGender);
		frame.getContentPane().add(pnlInsuranceInfo);
		SpringLayout sl_pnlInsuranceInfo = new SpringLayout();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, btnCreatePatient, 406, SpringLayout.WEST, pnlInsuranceInfo);
		pnlInsuranceInfo.setLayout(sl_pnlInsuranceInfo);
		
		JLabel lblInsuranceHeader = new JLabel("Insurance Information");
		lblInsuranceHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblInsuranceHeader, 10, SpringLayout.NORTH, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, lblInsuranceHeader, 10, SpringLayout.WEST, pnlInsuranceInfo);
		pnlInsuranceInfo.add(lblInsuranceHeader);
		
		JLabel lblInsuranceCo = new JLabel("Insurance Co.");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblInsuranceCo, 19, SpringLayout.SOUTH, lblInsuranceHeader);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, lblInsuranceCo, 20, SpringLayout.WEST, pnlInsuranceInfo);
		lblInsuranceCo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInsuranceCo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(lblInsuranceCo);
		
		txtInsuranceName = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, btnCreatePatient, 0, SpringLayout.EAST, txtInsuranceName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, btnCreatePatient, 0, SpringLayout.EAST, txtInsuranceName);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuranceName, 8, SpringLayout.EAST, lblInsuranceCo);
		pnlInsuranceInfo.add(txtInsuranceName);
		txtInsuranceName.setColumns(10);
		
		txtInsuredFirst = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtInsuranceName, -11, SpringLayout.NORTH, txtInsuredFirst);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuredFirst, -219, SpringLayout.EAST, pnlInsuranceInfo);
		TextPrompt tpInsuredFirst =  new TextPrompt("First Name", txtInsuredFirst);
		tpInsuredFirst.setHorizontalAlignment(SwingConstants.LEADING);
		tpInsuredFirst.setText("First");
		txtInsuredFirst.setColumns(7);
		pnlInsuranceInfo.add(txtInsuredFirst);
		
		JLabel lblPolicyNum = new JLabel("Policy No.");
		lblPolicyNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPolicyNum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(lblPolicyNum);
		
		JLabel lblGroupNum = new JLabel("Group No.");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, btnCreatePatient, -13, SpringLayout.NORTH, lblGroupNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, lblGroupNum, -13, SpringLayout.SOUTH, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, lblPolicyNum, -22, SpringLayout.NORTH, lblGroupNum);
		lblGroupNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGroupNum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(lblGroupNum);
		
		txtInsuredLast = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuranceName, 0, SpringLayout.EAST, txtInsuredLast);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, txtInsuredLast, 0, SpringLayout.NORTH, txtInsuredFirst);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuredLast, 6, SpringLayout.EAST, txtInsuredFirst);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuredLast, -12, SpringLayout.EAST, pnlInsuranceInfo);
		TextPrompt tpInsuredLast =  new TextPrompt("Last", txtInsuredLast);
		tpInsuredLast.setHorizontalAlignment(SwingConstants.LEADING);
		tpInsuredLast.setText("Last");
		pnlInsuranceInfo.add(txtInsuredLast);
		txtInsuredLast.setColumns(10);
		
		txtInsuredStreet = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtInsuredFirst, -12, SpringLayout.NORTH, txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, tpInsuredFirst, 0, SpringLayout.WEST, txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtInsuredStreet, -116, SpringLayout.SOUTH, pnlInsuranceInfo);
		txtInsuredStreet.setColumns(10);
		pnlInsuranceInfo.add(txtInsuredStreet);
		
		JLabel lblInsuredStreetAddress = new JLabel("Street Address");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuredStreet, 8, SpringLayout.EAST, lblInsuredStreetAddress);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblInsuredStreetAddress, 111, SpringLayout.NORTH, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblInsuredStreetAddress, -398, SpringLayout.EAST, pnlInsuranceInfo);
		lblInsuredStreetAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInsuredStreetAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(lblInsuredStreetAddress);
		
		JLabel lblCoPay = new JLabel("Co-Pay");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, btnCreatePatient, -1, SpringLayout.NORTH, lblCoPay);
		lblCoPay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(lblCoPay);
		
		txtGroupNum = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, btnCreatePatient, -2, SpringLayout.SOUTH, txtGroupNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtGroupNum, 98, SpringLayout.WEST, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblGroupNum, -10, SpringLayout.WEST, txtGroupNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtGroupNum, -4, SpringLayout.SOUTH, pnlInsuranceInfo);
		pnlInsuranceInfo.add(txtGroupNum);
		txtGroupNum.setColumns(10);
		
		JLabel lblNameInsured = new JLabel("Policy Holder");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuredFirst, 8, SpringLayout.EAST, lblNameInsured);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblNameInsured, 18, SpringLayout.SOUTH, lblInsuranceCo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblNameInsured, 0, SpringLayout.EAST, lblInsuranceCo);
		lblNameInsured.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlInsuranceInfo.add(lblNameInsured);
		
		JComboBox comboInsuredState = new JComboBox();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, comboInsuredState, 0, SpringLayout.WEST, txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, comboInsuredState, -341, SpringLayout.EAST, pnlInsuranceInfo);
		comboInsuredState.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		pnlInsuranceInfo.add(comboInsuredState);
		
		txtPolicyNum = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblCoPay, 3, SpringLayout.NORTH, txtPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtPolicyNum, -18, SpringLayout.NORTH, txtGroupNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtPolicyNum, -203, SpringLayout.EAST, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtGroupNum, 0, SpringLayout.EAST, txtPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, comboInsuredState, -18, SpringLayout.NORTH, txtPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblPolicyNum, -10, SpringLayout.WEST, txtPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtPolicyNum, 2, SpringLayout.WEST, txtInsuredStreet);
		pnlInsuranceInfo.add(txtPolicyNum);
		txtPolicyNum.setColumns(10);
		
		txtInsuredZip = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, txtInsuredZip, 0, SpringLayout.NORTH, comboInsuredState);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuredZip, -193, SpringLayout.EAST, pnlInsuranceInfo);
		pnlInsuranceInfo.add(txtInsuredZip);
		txtInsuredZip.setColumns(10);
		
		txtInsuredApt = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuredStreet, -8, SpringLayout.WEST, txtInsuredApt);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, txtInsuredApt, 0, SpringLayout.NORTH, txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuredApt, 424, SpringLayout.WEST, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuredApt, 0, SpringLayout.EAST, txtInsuranceName);
		TextPrompt tpApt =  new TextPrompt("Apt#", txtInsuredApt);
		tpApt.setHorizontalAlignment(SwingConstants.LEADING);
		tpApt.setText("Apt#");
		pnlInsuranceInfo.add(txtInsuredApt);
		txtInsuredApt.setColumns(10);
		
		JLabel lblNewLabel =new JLabel("State");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, lblNewLabel, -20, SpringLayout.NORTH, lblPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblInsuredStreetAddress);
		pnlInsuranceInfo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Zip Code");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblNewLabel_1, -283, SpringLayout.EAST, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuredZip, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, comboInsuredState);
		pnlInsuranceInfo.add(lblNewLabel_1);
		
		frame.getContentPane().add(lstEmergentList);
		
		List lstNonEmergentList = new List();
		springLayout.putConstraint(SpringLayout.EAST, lstEmergentList, -21, SpringLayout.WEST, lstNonEmergentList);
		springLayout.putConstraint(SpringLayout.WEST, lstNonEmergentList, -164, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lstNonEmergentList, -21, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lstNonEmergentList, -10, SpringLayout.EAST, frame.getContentPane());
		
		frame.getContentPane().add(lstNonEmergentList);
		
		JLabel lblEmergencyList = new JLabel("Emergency Wait List");
		springLayout.putConstraint(SpringLayout.WEST, lblEmergencyList, 735, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lstEmergentList, 6, SpringLayout.SOUTH, lblEmergencyList);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmergencyList, -275, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(lblEmergencyList);
		
		JLabel lblNonEmergentList = new JLabel("Non-Emergent Wait List");
		springLayout.putConstraint(SpringLayout.NORTH, lstNonEmergentList, 6, SpringLayout.SOUTH, lblNonEmergentList);
		springLayout.putConstraint(SpringLayout.NORTH, lblNonEmergentList, 0, SpringLayout.NORTH, lblEmergencyList);
		springLayout.putConstraint(SpringLayout.WEST, lblNonEmergentList, 0, SpringLayout.WEST, lstNonEmergentList);
		frame.getContentPane().add(lblNonEmergentList);
		

		
	
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, pnlInsuranceInfo, -17, SpringLayout.WEST, panel);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		txtCoPay = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtCoPay, -97, SpringLayout.EAST, pnlInsuranceInfo);
		pnlInsuranceInfo.add(txtCoPay);
		txtCoPay.setColumns(10);
		
		JLabel lblInsuredDob = new JLabel("DOB");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblCoPay, 0, SpringLayout.EAST, lblInsuredDob);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblInsuredDob, 3, SpringLayout.NORTH, comboInsuredState);
		pnlInsuranceInfo.add(lblInsuredDob);
		
		txtHolderDOB = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblInsuredDob, -6, SpringLayout.WEST, txtHolderDOB);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, txtCoPay, 18, SpringLayout.SOUTH, txtHolderDOB);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtCoPay, 0, SpringLayout.WEST, txtHolderDOB);
		tpDate =  new TextPrompt("MM/DD/YYYY", txtHolderDOB);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtHolderDOB, 340, SpringLayout.WEST, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, txtHolderDOB, 0, SpringLayout.NORTH, comboInsuredState);
		pnlInsuranceInfo.add(txtHolderDOB);
		txtHolderDOB.setColumns(10);
		
		
		springLayout.putConstraint(SpringLayout.EAST, panel, -18, SpringLayout.WEST, lstEmergentList);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 352, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 517, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -21, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblCurrentPatientHeader = new JLabel("Current Patient:");
		lblCurrentPatientHeader.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_panel.putConstraint(SpringLayout.NORTH, lblCurrentPatientHeader, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblCurrentPatientHeader, 10, SpringLayout.WEST, panel);
		panel.add(lblCurrentPatientHeader);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 5, SpringLayout.SOUTH, lblCurrentPatientHeader);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -205, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 88, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -84, SpringLayout.EAST, panel);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Emergency Contact:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -29, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 20, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Chief Complaint:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -76, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -29, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 20, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Trauma Priority:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 29, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 20, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_6);
		
		JLabel lblSelectedPatient = new JLabel("Label");
		sl_panel.putConstraint(SpringLayout.NORTH, lblSelectedPatient, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblSelectedPatient, 10, SpringLayout.WEST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblSelectedPatient, 170, SpringLayout.WEST, lblNewLabel_2);
		panel.add(lblSelectedPatient);
		
		JLabel label = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, label, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -6, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, lblSelectedPatient);
		panel.add(label);
		
		JLabel label_1 = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_1, -6, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.EAST, label_1, 0, SpringLayout.EAST, lblSelectedPatient);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, label_2, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_2, -6, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, label_2, 0, SpringLayout.EAST, lblSelectedPatient);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, label_3, 9, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, label_3, 10, SpringLayout.WEST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, label_3, 0, SpringLayout.EAST, lblSelectedPatient);
		panel.add(label_3);
		
		Button btnExam1Add = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.EAST, pnlPatientInfo, -6, SpringLayout.WEST, btnExam1Add);
		springLayout.putConstraint(SpringLayout.WEST, btnExam1Add, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnExam1Add, -164, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, btnExam1Add, -479, SpringLayout.EAST, frame.getContentPane());
		btnExam1Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnExam1Add);
		
		Button button_1 = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, btnExam1Add);
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 0, SpringLayout.NORTH, btnExam1Add);
		frame.getContentPane().add(button_2);
		
		Canvas Canvas = new Canvas();
		springLayout.putConstraint(SpringLayout.WEST, Canvas, 6, SpringLayout.EAST, pnlPatientInfo);
		springLayout.putConstraint(SpringLayout.NORTH, pnlPatientInfo, 0, SpringLayout.NORTH, Canvas);
		springLayout.putConstraint(SpringLayout.NORTH, btnExam1Add, 6, SpringLayout.SOUTH, Canvas);
		springLayout.putConstraint(SpringLayout.NORTH, Canvas, 10, SpringLayout.NORTH, frame.getContentPane());
		
		JComboBox comboMaritalStatus = new JComboBox();
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, comboMaritalStatus, 370, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, comboMaritalStatus, 0, SpringLayout.SOUTH, comboBoxState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, comboMaritalStatus, -39, SpringLayout.EAST, pnlPatientInfo);
		comboMaritalStatus.setModel(new DefaultComboBoxModel(new String[] {"Single", "Married", "Divorced"}));
		pnlPatientInfo.add(comboMaritalStatus);
		
		JLabel lblNewLabel_7 = new JLabel("Marital");
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, lblNewLabel_7, 322, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, -55, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblNewLabel_7, -6, SpringLayout.WEST, comboMaritalStatus);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, comboGender, -24, SpringLayout.WEST, lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblNewLabel_7);
		springLayout.putConstraint(SpringLayout.SOUTH, Canvas, -474, SpringLayout.SOUTH, frame.getContentPane());
		Canvas.setBackground(new Color(0, 153, 0));
		Canvas.setForeground(new Color(0, 0, 0));
		Canvas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		frame.getContentPane().add(Canvas);
		
		Canvas canvas_1 = new Canvas();
		springLayout.putConstraint(SpringLayout.EAST, Canvas, -26, SpringLayout.WEST, canvas_1);
		springLayout.putConstraint(SpringLayout.NORTH, canvas_1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, canvas_1, 709, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, canvas_1, 0, SpringLayout.SOUTH, Canvas);
		springLayout.putConstraint(SpringLayout.EAST, canvas_1, -199, SpringLayout.EAST, frame.getContentPane());
		canvas_1.setBackground(new Color(0, 153, 0));
		frame.getContentPane().add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		springLayout.putConstraint(SpringLayout.NORTH, canvas_2, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, canvas_2, 16, SpringLayout.EAST, canvas_1);
		springLayout.putConstraint(SpringLayout.SOUTH, canvas_2, 0, SpringLayout.SOUTH, Canvas);
		springLayout.putConstraint(SpringLayout.EAST, canvas_2, -17, SpringLayout.EAST, frame.getContentPane());
		canvas_2.setBackground(new Color(0, 153, 0));
		frame.getContentPane().add(canvas_2);
		
		Button button_3 = new Button("Discharge");
		springLayout.putConstraint(SpringLayout.WEST, button_1, 26, SpringLayout.EAST, button_3);
		springLayout.putConstraint(SpringLayout.NORTH, button_3, 0, SpringLayout.NORTH, btnExam1Add);
		springLayout.putConstraint(SpringLayout.WEST, button_3, 10, SpringLayout.EAST, btnExam1Add);
		springLayout.putConstraint(SpringLayout.EAST, button_3, 0, SpringLayout.EAST, Canvas);
		frame.getContentPane().add(button_3);
		
		Button button_4 = new Button("Discharge");
		springLayout.putConstraint(SpringLayout.WEST, button_2, 16, SpringLayout.EAST, button_4);
		springLayout.putConstraint(SpringLayout.EAST, button_1, -10, SpringLayout.WEST, button_4);
		springLayout.putConstraint(SpringLayout.NORTH, button_4, 0, SpringLayout.NORTH, btnExam1Add);
		springLayout.putConstraint(SpringLayout.WEST, button_4, 797, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_4, 0, SpringLayout.EAST, canvas_1);
		frame.getContentPane().add(button_4);
		
		Button button_5 = new Button("Discharge");
		springLayout.putConstraint(SpringLayout.EAST, button_2, -10, SpringLayout.WEST, button_5);
		springLayout.putConstraint(SpringLayout.NORTH, button_5, 0, SpringLayout.NORTH, btnExam1Add);
		springLayout.putConstraint(SpringLayout.WEST, button_5, 979, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_5, 0, SpringLayout.EAST, canvas_2);
		frame.getContentPane().add(button_5);
		btnCreatePatient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(btnCreatePatient);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, button_5, -36, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_2, -36, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_4, -36, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, -36, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_3, -36, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 224, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -7, SpringLayout.NORTH, lblEmergencyList);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 536, SpringLayout.WEST, panel);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblChiefComplaint = new JLabel("Chief Complaint");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblChiefComplaint, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblChiefComplaint);
		
		JLabel lblTriageRating = new JLabel("Triage Rating (1-5)");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblChiefComplaint, 1, SpringLayout.NORTH, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblChiefComplaint, -280, SpringLayout.WEST, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblTriageRating, 9, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblTriageRating, -10, SpringLayout.EAST, panel_1);
		lblTriageRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblTriageRating);
		
		
		JTextArea txtAreaChiefComplaint = new JTextArea();
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtAreaChiefComplaint, 1, SpringLayout.SOUTH, lblChiefComplaint);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtAreaChiefComplaint, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, txtAreaChiefComplaint, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtAreaChiefComplaint, -122, SpringLayout.EAST, panel_1);
		panel_1.add(txtAreaChiefComplaint);
		
		comboTriage = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboTriage, 6, SpringLayout.SOUTH, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboTriage, 10, SpringLayout.WEST, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboTriage, -66, SpringLayout.EAST, panel_1);
		comboTriage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboTriage.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		panel_1.add(comboTriage);
		
		
		
		
		LinkedList<Patient> currentPatientList = new LinkedList<>();

		PriorityQueue<Patient> emergentQueue = new 
	             PriorityQueue<Patient>(10, new PatientComparator());
		

		Patient ethan = new Patient();
		ethan.setID(102);
		ethan.setFirstName("Ethan");
		ethan.setLastName("Taylor");
		ethan.setTriageRating(3);
		ethan.setEmergent(true);
		
		Patient alexis = new Patient();
		alexis.setID(103);
		alexis.setFirstName("Alexis");
		alexis.setLastName("Snowden");
		alexis.setTriageRating(1);
		alexis.setEmergent(true);
		
		Patient drew = new Patient();
		drew.setID(101);
		drew.setFirstName("Drew");
		drew.setLastName("Douglass");
		drew.setTriageRating(5);
		drew.setEmergent(true);
		
		Patient kali = new Patient();
		kali.setID(104);
		kali.setFirstName("Kali");
		kali.setLastName("Aria");
		kali.setTriageRating(2);
		kali.setEmergent(true);
		
		Patient ted = new Patient();
		ted.setID(105);
		ted.setFirstName("Ted");
		ted.setLastName("Moseby");
		ted.setTriageRating(4);
		
		currentPatientList.add(drew);
		currentPatientList.add(ted);
		currentPatientList.add(ethan);
		currentPatientList.add(kali);
		currentPatientList.add(alexis);	
		
		for(Patient p : currentPatientList)
		{
			lstEmergentList.add(p.toString());
		}
		
		btnCreatePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
									
				currentPatientList.add(createPatient());
			    java.util.Iterator<Patient> itr1 = emergentQueue.iterator();
			    
		        for (Patient p: currentPatientList){
		        	
		        	emergentQueue.add(p);
		        	
		        }
		        lstEmergentList.removeAll();
		        while(itr1.hasNext()){
		       
		        	lstEmergentList.add(emergentQueue.poll().toString());
		        	 
		        }
		        
		        
			}
		});
		
		
		lstEmergentList.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		            
		             getPatient();
		           
		            }
		        
		    }
		});
		
	}



		

	public JFrame getFrame() {
		return frame;
	}
	
	public Patient createPatient()
	{
		int ID;
		String firstName;
		String lastName;
		Date dOB;		
		String streetAddress1;
		String streetAddress2;
		String state;
		String zip = null;
		String homePhone;
		String workPhone;
		String cellPhone;
		String patientEmail;
		String gender;
		String maritalStatus;
		int triageRating;
		
		String company; 
		String planType;
		String policyHolderFirstName;
		String policyHolderLastName;
		String policyHolderAddress;
		String policyHolderAptNum;
		String policyHolderDOB;
		String policyHolderState;
		String policyHolderZip;
		String policyNum, groupNum;
		
		
		Patient newPatient = new Patient();
		
		ID = newPatient.getID(); 
		firstName = newPatient.getFirstName();
		lastName = newPatient.getLastName();
		dOB = newPatient.getDOB();
		streetAddress1 = newPatient.getStreetAddress1();
		streetAddress2 = newPatient.getStreetAddress2();
		state = newPatient.getState();
		zip = newPatient.getZip();
		homePhone = newPatient.getHomePhone();
		workPhone = newPatient.getWorkPhone();
		cellPhone = newPatient.getCellPhone();
		patientEmail = newPatient.getPatientEmail();
		maritalStatus = newPatient.getMaritalStatus();
		gender = newPatient.getGender();
		
		company = newPatient.getCompany();
		planType = newPatient.getPlanType();
		policyHolderFirstName = newPatient.getPolicyHolderFirstName();
		policyHolderLastName = newPatient.getPolicyHolderLastName();
		policyHolderAddress = newPatient.getPolicyHolderAddress();
		policyHolderAptNum = newPatient.getPolicyHolderAptNum();
		policyHolderDOB = newPatient.getPolicyHolderDOB();
		policyHolderState = newPatient.getPolicyHolderState();
		policyHolderZip = newPatient.getPolicyHolderZip();
		policyNum = newPatient.getPolicyNum();
		groupNum = newPatient.getGroupNum();
		triageRating = newPatient.getTriageRating();
		
		
		newPatient.setID(dailyPatientCount);
		newPatient.setFirstName(firstName);
		newPatient.setLastName(lastName);
		newPatient.setDOB(dOB);
		newPatient.setStreetAddress1(streetAddress1);
		newPatient.setStreetAddress2(streetAddress2);
		newPatient.setState(state);
		newPatient.setZip(zip);
		newPatient.setHomePhone(homePhone);
		newPatient.setWorkPhone(workPhone);
		newPatient.setCellPhone(cellPhone);
		newPatient.setPatientEmail(patientEmail);
		newPatient.setMaritalStatus(maritalStatus);
		newPatient.setGender(gender);
		
		newPatient.setCompany(company);
		newPatient.setPlanType(planType);
		newPatient.setPolicyHolderFirstName(policyHolderFirstName);
		newPatient.setPolicyHolderLastName(policyHolderLastName);
		newPatient.setPolicyHolderAddress(policyHolderAddress);
		newPatient.setPolicyHolderAptNum(policyHolderAptNum);
		newPatient.setPolicyHolderState(policyHolderState);
		newPatient.setPolicyHolderZip(policyHolderZip);
		newPatient.setPolicyHolderDOB(policyHolderDOB);
		newPatient.setPolicyNum(policyNum);
		newPatient.setGroupNum(groupNum);
		newPatient.setTriageRating(triageRating);
		
		dailyPatientCount++;
		
		
		
		return newPatient;
		
	}
	
	public void getPatient()
	{
		
		
	}
}
