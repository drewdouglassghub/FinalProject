package finalProject;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import decisionTree.Tree;

import java.awt.Component;

/**
 * @author Drew Douglass, amdouglass@dmacc.edu, 12/4/18 This program creates a
 *         GUI that allows the user to enter patient information, admit the
 *         patient to an emergency treatment room based on their placement in
 *         the priority queue, and discharge them to either the community or a
 *         unit in the hospital based on their triage rating and the placement
 *         in the decision tree.
 *
 */
public class ErGui {

	private JFrame frame; // static variables accessible from the entire package
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
	static JTextArea txtAreaChiefComplaint = new JTextArea();
	static JLabel lblSelectedPatientFirst = new JLabel("");
	static JLabel lblSelectedPatientLast = new JLabel("");
	static JLabel lblSelectedPatientTR = new JLabel("");
	static JLabel lblSelectedPatientComp = new JLabel("");
	static JLabel lblSelectedPatientCat = new JLabel("");
	static JLabel lblExam1 = new JLabel("");
	static JLabel lblExam2 = new JLabel("");
	static JLabel lblExam3 = new JLabel("");
	static JLabel lblDCExam1 = new JLabel("");

	static JComboBox comboTreatmentCat = new JComboBox();
	static JComboBox comboTriage = new JComboBox();
	static JComboBox comboBoxState = new JComboBox();
	static JComboBox comboGender = new JComboBox();
	
	
	static JFormattedTextField txtDOB = new JFormattedTextField();
	

	static JButton btnCreatePatient = new JButton("Create");
	static JLabel lblPatientMRN = new JLabel("");
	static List lstEmergentList = new List();
	static List lstNonEmergentList = new List();
	static JTextField txtCoPay;
	static JTextField txtHolderDOB;
	static ListSelectionModel selectionModel;
	static LinkedList<Patient> criticalPatientList = new LinkedList<>(); // lists
																			// for
																			// patients
																			// before
																			// they
																			// get
																			// queued
	static LinkedList<Patient> nonCriticalPatientList = new LinkedList<>(); // linked
																			// lists

	static Patient exam1Patient; // generic patients
	static Patient exam2Patient;
	static Patient exam3Patient;

	static HospitalTree hospitalTree = new HospitalTree(); // decision tree
	PriorityQueue<Patient> emergentQueue = new // priority queue for triage
												// ratings of 3 or more
	PriorityQueue<Patient>(10, new PatientComparator()); // priority queue is
															// cleared before
															// regular queue is
															// started
	Queue<Patient> nonEmergentQueue = new LinkedList<>(); // regular queue for
															// lower rated
															// patients

	static int dailyPatientCount = 106; // starting id # for patient count
	private TextPrompt tpDate_1;

	boolean room1Open = true;
	boolean room2Open = true;
	boolean room3Open = true;

	public List getEmergentQueue(java.util.List<Patient> patientList) { // getter
																		// for
																		// the
																		// list
																		// that
																		// displays
																		// the
																		// queue
																		// in
																		// the
																		// gui
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
		springLayout.putConstraint(SpringLayout.SOUTH, lstEmergentList, -21, SpringLayout.SOUTH,
				frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);

		JPanel pnlPatientInfo = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, pnlPatientInfo, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, pnlPatientInfo, 10, SpringLayout.WEST, frame.getContentPane());
		pnlPatientInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(pnlPatientInfo);
		SpringLayout sl_pnlPatientInfo = new SpringLayout();
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, comboBoxState, 131, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, comboGender, 0, SpringLayout.SOUTH, comboBoxState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtDOB, 140, SpringLayout.NORTH, pnlPatientInfo);
		pnlPatientInfo.setLayout(sl_pnlPatientInfo);

		JLabel lblPatientHeader = new JLabel("Patient Information");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblPatientHeader, 10, SpringLayout.NORTH, pnlPatientInfo);
		lblPatientHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlPatientInfo.add(lblPatientHeader);

		JLabel lblFirstName = new JLabel("First Name");
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblPatientHeader, -22, SpringLayout.NORTH, lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblFirstName, 0, SpringLayout.EAST, lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblLastName);

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblDateOfBirth, 14, SpringLayout.SOUTH, lblLastName);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblDateOfBirth);

		JLabel lblStreetAddress1 = new JLabel("Street Address 1");
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, lblPatientHeader, 2, SpringLayout.WEST, lblStreetAddress1);
		lblStreetAddress1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblStreetAddress1);

		JLabel lblState = new JLabel("State");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblState, -8, SpringLayout.WEST, comboBoxState);
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblState);

		txtLastName = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblLastName, 0, SpringLayout.NORTH, txtLastName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblLastName, -8, SpringLayout.WEST, txtLastName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtLastName, -17, SpringLayout.NORTH, txtDOB);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtLastName, 0, SpringLayout.EAST, lblPatientHeader);
		pnlPatientInfo.add(txtLastName);
		txtLastName.setColumns(10);

		// Patient DOB setup and layout

		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblDateOfBirth, -6, SpringLayout.WEST, txtDOB);
		TextPrompt tpDate;
		tpDate_1 = new TextPrompt("mm/dd/yyyy", txtDOB);
		tpDate_1.setHorizontalAlignment(SwingConstants.LEADING);
		pnlPatientInfo.add(txtDOB);
		txtDOB.setColumns(10);

		txtZipcode = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtZipcode, -291, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, comboBoxState, -17, SpringLayout.NORTH, txtZipcode);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtZipcode, -16, SpringLayout.SOUTH, pnlPatientInfo);
		pnlPatientInfo.add(txtZipcode);
		txtZipcode.setColumns(10);

		JLabel lblPatientZipcode = new JLabel("Zip");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtZipcode, 0, SpringLayout.NORTH, lblPatientZipcode);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtZipcode, 6, SpringLayout.EAST, lblPatientZipcode);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblPatientZipcode, -19, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblPatientZipcode, -361, SpringLayout.EAST, pnlPatientInfo);
		lblPatientZipcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblPatientZipcode);

		txtFirstName = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtFirstName, 8, SpringLayout.EAST, lblFirstName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblFirstName, 0, SpringLayout.NORTH, txtFirstName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtLastName, 13, SpringLayout.SOUTH, txtFirstName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtFirstName, -228, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtFirstName, 70, SpringLayout.NORTH, pnlPatientInfo);
		pnlPatientInfo.add(txtFirstName);
		txtFirstName.requestFocus();
		txtFirstName.setColumns(10);

		JPanel pnlInsuranceInfo = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, pnlPatientInfo, -20, SpringLayout.NORTH, pnlInsuranceInfo);
		springLayout.putConstraint(SpringLayout.NORTH, pnlInsuranceInfo, 0, SpringLayout.NORTH, lstEmergentList);
		springLayout.putConstraint(SpringLayout.WEST, pnlInsuranceInfo, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pnlInsuranceInfo, 0, SpringLayout.SOUTH, lstEmergentList);
		pnlInsuranceInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblStreetAddress2 = new JLabel("Street Address 2");
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblStreetAddress2, -91, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblState, 19, SpringLayout.SOUTH, lblStreetAddress2);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblStreetAddress2, 210, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblStreetAddress1, -19, SpringLayout.NORTH,
				lblStreetAddress2);
		lblStreetAddress2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblStreetAddress2);

		txtStreetAddress1 = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtDOB, -17, SpringLayout.NORTH, txtStreetAddress1);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblStreetAddress1, -8, SpringLayout.WEST, txtStreetAddress1);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtStreetAddress1, 131, SpringLayout.WEST, pnlPatientInfo);
		pnlPatientInfo.add(txtStreetAddress1);
		txtStreetAddress1.setColumns(10);

		txtStreetAddress2 = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, comboBoxState, 21, SpringLayout.SOUTH, txtStreetAddress2);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtStreetAddress2, 210, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtStreetAddress2, -92, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtStreetAddress1, -17, SpringLayout.NORTH,
				txtStreetAddress2);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblStreetAddress2, -8, SpringLayout.WEST, txtStreetAddress2);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtStreetAddress2, 131, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtStreetAddress2, -39, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(txtStreetAddress2);
		txtStreetAddress2.setColumns(10);
		comboBoxState.setModel(new DefaultComboBoxModel(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
				"FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO",
				"MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
				"TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
		pnlPatientInfo.add(comboBoxState);

		JLabel lblHomePhone = new JLabel("Home Phone");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblPatientHeader, -6, SpringLayout.WEST, lblHomePhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblHomePhone, 38, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblHomePhone, -170, SpringLayout.EAST, pnlPatientInfo);
		lblHomePhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblHomePhone);

		JLabel lblWorkPhone = new JLabel("Work Phone");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtFirstName, -8, SpringLayout.WEST, lblWorkPhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblWorkPhone, 0, SpringLayout.NORTH, lblFirstName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblWorkPhone, 0, SpringLayout.EAST, lblHomePhone);
		lblWorkPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblWorkPhone);

		JLabel lblCellPhone = new JLabel("Cell Phone");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblCellPhone, 15, SpringLayout.SOUTH, lblWorkPhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtLastName, -122, SpringLayout.WEST, lblCellPhone);
		lblCellPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		comboGender.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));
		pnlPatientInfo.add(comboGender);

		JLabel lblGender = new JLabel("Gender");
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, comboGender, 7, SpringLayout.EAST, lblGender);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, comboBoxState, -28, SpringLayout.WEST, lblGender);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblGender, 0, SpringLayout.SOUTH, lblState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblGender, -232, SpringLayout.EAST, pnlPatientInfo);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblGender);
		frame.getContentPane().add(pnlInsuranceInfo);
		SpringLayout sl_pnlInsuranceInfo = new SpringLayout();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, btnCreatePatient, 406, SpringLayout.WEST,
				pnlInsuranceInfo);
		pnlInsuranceInfo.setLayout(sl_pnlInsuranceInfo);

		JLabel lblInsuranceHeader = new JLabel("Insurance Information");
		lblInsuranceHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblInsuranceHeader, 10, SpringLayout.NORTH,
				pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, lblInsuranceHeader, 10, SpringLayout.WEST,
				pnlInsuranceInfo);
		pnlInsuranceInfo.add(lblInsuranceHeader);

		JLabel lblInsuranceCo = new JLabel("Insurance Co.");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblInsuranceCo, 19, SpringLayout.SOUTH,
				lblInsuranceHeader);
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
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtInsuranceName, -11, SpringLayout.NORTH,
				txtInsuredFirst);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuredFirst, -219, SpringLayout.EAST,
				pnlInsuranceInfo);
		TextPrompt tpInsuredFirst = new TextPrompt("First Name", txtInsuredFirst);
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
		TextPrompt tpInsuredLast = new TextPrompt("Last", txtInsuredLast);
		tpInsuredLast.setHorizontalAlignment(SwingConstants.LEADING);
		tpInsuredLast.setText("Last");
		pnlInsuranceInfo.add(txtInsuredLast);
		txtInsuredLast.setColumns(10);

		txtInsuredStreet = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtInsuredFirst, -12, SpringLayout.NORTH,
				txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, tpInsuredFirst, 0, SpringLayout.WEST, txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtInsuredStreet, -116, SpringLayout.SOUTH,
				pnlInsuranceInfo);
		txtInsuredStreet.setColumns(10);
		pnlInsuranceInfo.add(txtInsuredStreet);

		JLabel lblInsuredStreetAddress = new JLabel("Street Address");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuredStreet, 8, SpringLayout.EAST,
				lblInsuredStreetAddress);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblInsuredStreetAddress, 111, SpringLayout.NORTH,
				pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblInsuredStreetAddress, -398, SpringLayout.EAST,
				pnlInsuranceInfo);
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
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, comboInsuredState, -341, SpringLayout.EAST,
				pnlInsuranceInfo);
		comboInsuredState.setModel(new DefaultComboBoxModel(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT",
				"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS",
				"MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD",
				"TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
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
		TextPrompt tpApt = new TextPrompt("Apt#", txtInsuredApt);
		tpApt.setHorizontalAlignment(SwingConstants.LEADING);
		tpApt.setText("Apt#");
		pnlInsuranceInfo.add(txtInsuredApt);
		txtInsuredApt.setColumns(10);

		JLabel lblNewLabel = new JLabel("State");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, lblNewLabel, -20, SpringLayout.NORTH, lblPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST,
				lblInsuredStreetAddress);
		pnlInsuranceInfo.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Zip Code");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblNewLabel_1, -283, SpringLayout.EAST, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuredZip, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, comboInsuredState);
		pnlInsuranceInfo.add(lblNewLabel_1);

		frame.getContentPane().add(lstEmergentList);

		springLayout.putConstraint(SpringLayout.EAST, lstEmergentList, -21, SpringLayout.WEST, lstNonEmergentList);
		springLayout.putConstraint(SpringLayout.WEST, lstNonEmergentList, -164, SpringLayout.EAST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lstNonEmergentList, -21, SpringLayout.SOUTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lstNonEmergentList, -10, SpringLayout.EAST,
				frame.getContentPane());

		frame.getContentPane().add(lstNonEmergentList);

		JLabel lblEmergencyList = new JLabel("Emergency Wait List");
		springLayout.putConstraint(SpringLayout.WEST, lblEmergencyList, 735, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lstEmergentList, 6, SpringLayout.SOUTH, lblEmergencyList);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmergencyList, -275, SpringLayout.SOUTH,
				frame.getContentPane());
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
		tpDate = new TextPrompt("MM/DD/YYYY", txtHolderDOB);
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
		sl_panel.putConstraint(SpringLayout.NORTH, lblSelectedPatientCat, 19, SpringLayout.SOUTH,
				lblSelectedPatientComp);
		sl_panel.putConstraint(SpringLayout.NORTH, lblSelectedPatientTR, 20, SpringLayout.SOUTH,
				lblSelectedPatientLast);

		sl_panel.putConstraint(SpringLayout.WEST, lblSelectedPatientComp, -6, SpringLayout.WEST,
				lblSelectedPatientLast);
		sl_panel.putConstraint(SpringLayout.NORTH, lblSelectedPatientLast, 7, SpringLayout.SOUTH,
				lblSelectedPatientFirst);
		sl_panel.putConstraint(SpringLayout.EAST, lblSelectedPatientLast, -12, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblSelectedPatientFirst, 6, SpringLayout.SOUTH, lblPatientMRN);
		sl_panel.putConstraint(SpringLayout.EAST, lblSelectedPatientFirst, -4, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblPatientMRN, -55, SpringLayout.EAST, panel);
		panel.setLayout(sl_panel);

		JLabel lblCurrentPatientHeader = new JLabel("Patient MRN:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblPatientMRN, 0, SpringLayout.NORTH, lblCurrentPatientHeader);
		sl_panel.putConstraint(SpringLayout.WEST, lblPatientMRN, 6, SpringLayout.EAST, lblCurrentPatientHeader);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPatientMRN, 2, SpringLayout.SOUTH, lblCurrentPatientHeader);
		lblCurrentPatientHeader.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_panel.putConstraint(SpringLayout.NORTH, lblCurrentPatientHeader, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblCurrentPatientHeader, 10, SpringLayout.WEST, panel);
		panel.add(lblCurrentPatientHeader);

		JLabel lblPatientCardFirst = new JLabel("First Name:");
		sl_panel.putConstraint(SpringLayout.WEST, lblSelectedPatientFirst, 6, SpringLayout.EAST, lblPatientCardFirst);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSelectedPatientFirst, 0, SpringLayout.SOUTH, lblPatientCardFirst);
		sl_panel.putConstraint(SpringLayout.NORTH, lblPatientCardFirst, 6, SpringLayout.SOUTH, lblCurrentPatientHeader);
		sl_panel.putConstraint(SpringLayout.WEST, lblPatientCardFirst, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblPatientCardFirst, -114, SpringLayout.EAST, panel);
		panel.add(lblPatientCardFirst);

		JLabel lblNewLabel_3 = new JLabel("Last Name:");
		sl_panel.putConstraint(SpringLayout.WEST, lblSelectedPatientLast, 10, SpringLayout.EAST, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSelectedPatientLast, 0, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPatientCardFirst, -6, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -118, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblCurrentPatientHeader);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Category:");
		sl_panel.putConstraint(SpringLayout.WEST, lblSelectedPatientCat, 29, SpringLayout.EAST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.NORTH, lblSelectedPatientComp, -34, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblCurrentPatientHeader);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -26, SpringLayout.SOUTH, panel);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Complaint:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSelectedPatientComp, 0, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 14, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, -96, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -69, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblCurrentPatientHeader);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Triage Rating:");
		sl_panel.putConstraint(SpringLayout.WEST, lblSelectedPatientTR, 28, SpringLayout.EAST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, -35, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 99, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -18, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -6, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblCurrentPatientHeader);
		panel.add(lblNewLabel_6);
		panel.add(lblSelectedPatientLast);

		Button btnExam1Add = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.WEST, btnExam1Add, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnExam1Add, -462, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnExam1Add, -479, SpringLayout.EAST, frame.getContentPane());

		frame.getContentPane().add(btnExam1Add);

		Button btnExam2 = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.SOUTH, btnExam2, -462, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnExam2);

		Button btnExam3 = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.SOUTH, btnExam3, -462, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnExam3);

		Canvas Canvas = new Canvas();
		springLayout.putConstraint(SpringLayout.NORTH, btnExam1Add, 6, SpringLayout.SOUTH, Canvas);
		springLayout.putConstraint(SpringLayout.WEST, Canvas, 517, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, pnlPatientInfo, -17, SpringLayout.WEST, Canvas);
		springLayout.putConstraint(SpringLayout.SOUTH, Canvas, -503, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, Canvas, 10, SpringLayout.NORTH, frame.getContentPane());

		JComboBox comboMaritalStatus = new JComboBox();
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, comboMaritalStatus, 370, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, comboMaritalStatus, 0, SpringLayout.SOUTH, comboBoxState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, comboMaritalStatus, 0, SpringLayout.EAST, txtStreetAddress1);
		comboMaritalStatus.setModel(new DefaultComboBoxModel(new String[] { "Single", "Married", "Divorced" }));
		pnlPatientInfo.add(comboMaritalStatus);

		JLabel lblNewLabel_7 = new JLabel("Marital");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, comboGender, -23, SpringLayout.WEST, lblNewLabel_7);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, lblNewLabel_7, 322, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 0, SpringLayout.SOUTH, lblState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblNewLabel_7, -6, SpringLayout.WEST, comboMaritalStatus);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblNewLabel_7);
		pnlPatientInfo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { txtFirstName, txtLastName,
				txtDOB, tpDate_1, txtStreetAddress1, txtStreetAddress2, comboBoxState, txtZipcode, txtHomePhone,
				txtWorkPhone, txtCellPhone, txtEmail, comboGender, comboMaritalStatus }));
		Canvas.setBackground(new Color(0, 153, 0));
		Canvas.setForeground(new Color(0, 0, 0));
		Canvas.setFont(new Font("Tahoma", Font.PLAIN, 14));

		frame.getContentPane().add(Canvas);

		Canvas canvas_1 = new Canvas();
		springLayout.putConstraint(SpringLayout.NORTH, btnExam2, 6, SpringLayout.SOUTH, canvas_1);
		springLayout.putConstraint(SpringLayout.SOUTH, canvas_1, -503, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, Canvas, -26, SpringLayout.WEST, canvas_1);
		springLayout.putConstraint(SpringLayout.NORTH, canvas_1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, canvas_1, 709, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, canvas_1, -199, SpringLayout.EAST, frame.getContentPane());
		canvas_1.setBackground(new Color(0, 153, 0));
		frame.getContentPane().add(canvas_1);

		Canvas canvas_2 = new Canvas();
		springLayout.putConstraint(SpringLayout.NORTH, btnExam3, 6, SpringLayout.SOUTH, canvas_2);
		springLayout.putConstraint(SpringLayout.SOUTH, canvas_2, -503, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, canvas_2, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, canvas_2, 16, SpringLayout.EAST, canvas_1);
		springLayout.putConstraint(SpringLayout.EAST, canvas_2, -17, SpringLayout.EAST, frame.getContentPane());
		canvas_2.setBackground(new Color(0, 153, 0));
		frame.getContentPane().add(canvas_2);

		Button btnDCExam1 = new Button("Discharge");

		springLayout.putConstraint(SpringLayout.NORTH, btnDCExam1, 6, SpringLayout.SOUTH, Canvas);
		springLayout.putConstraint(SpringLayout.WEST, btnExam2, 26, SpringLayout.EAST, btnDCExam1);
		springLayout.putConstraint(SpringLayout.WEST, btnDCExam1, 6, SpringLayout.EAST, btnExam1Add);
		springLayout.putConstraint(SpringLayout.EAST, btnDCExam1, 0, SpringLayout.EAST, Canvas);
		frame.getContentPane().add(btnDCExam1);

		Button btnDCExam2 = new Button("Discharge");
		springLayout.putConstraint(SpringLayout.NORTH, btnDCExam2, 6, SpringLayout.SOUTH, canvas_1);
		springLayout.putConstraint(SpringLayout.WEST, btnExam3, 16, SpringLayout.EAST, btnDCExam2);
		springLayout.putConstraint(SpringLayout.EAST, btnExam2, -10, SpringLayout.WEST, btnDCExam2);
		springLayout.putConstraint(SpringLayout.WEST, btnDCExam2, 797, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnDCExam2, 0, SpringLayout.EAST, canvas_1);
		frame.getContentPane().add(btnDCExam2);

		Button btnDCExam3 = new Button("Discharge");

		springLayout.putConstraint(SpringLayout.NORTH, btnDCExam3, 6, SpringLayout.SOUTH, canvas_2);
		springLayout.putConstraint(SpringLayout.EAST, btnExam3, -10, SpringLayout.WEST, btnDCExam3);
		springLayout.putConstraint(SpringLayout.WEST, btnDCExam3, 979, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnDCExam3, 0, SpringLayout.EAST, canvas_2);
		frame.getContentPane().add(btnDCExam3);
		btnCreatePatient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(btnCreatePatient);
		pnlInsuranceInfo.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { txtInsuranceName, txtInsuredFirst, tpInsuredFirst,
						txtInsuredLast, tpInsuredLast, txtInsuredStreet, txtInsuredApt, tpApt, comboInsuredState,
						txtInsuredZip, txtHolderDOB, tpDate, txtPolicyNum, txtGroupNum, txtCoPay, btnCreatePatient }));

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 224, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -7, SpringLayout.NORTH, lblEmergencyList);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 536, SpringLayout.WEST, panel);
		panel.add(lblPatientMRN);
		panel.add(lblSelectedPatientFirst);
		panel.add(lblSelectedPatientTR);
		sl_panel.putConstraint(SpringLayout.EAST, lblSelectedPatientComp, -4, SpringLayout.EAST, panel);
		panel.add(lblSelectedPatientComp);
		panel.add(lblSelectedPatientCat);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		sl_panel_1.putConstraint(SpringLayout.EAST, comboTriage, -66, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboTreatmentCat, 38, SpringLayout.EAST, txtAreaChiefComplaint);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboTreatmentCat, -2, SpringLayout.SOUTH, comboTriage);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboTreatmentCat, -160, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtAreaChiefComplaint, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, txtAreaChiefComplaint, -13, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtAreaChiefComplaint, -278, SpringLayout.EAST, panel_1);
		panel_1.setLayout(sl_panel_1);

		JLabel lblChiefComplaint = new JLabel("Chief Complaint");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblChiefComplaint, 3, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtAreaChiefComplaint, 2, SpringLayout.SOUTH, lblChiefComplaint);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblChiefComplaint, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblChiefComplaint);

		JLabel lblTriageRating = new JLabel("Triage Rating (1-5)");
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboTriage, 4, SpringLayout.SOUTH, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboTreatmentCat, 4, SpringLayout.SOUTH, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblTriageRating, 422, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblTriageRating, -80, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblChiefComplaint, 15, SpringLayout.NORTH, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblChiefComplaint, -280, SpringLayout.WEST, lblTriageRating);
		lblTriageRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblTriageRating);
		panel_1.add(txtAreaChiefComplaint);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboTriage, 56, SpringLayout.EAST, comboTreatmentCat);
		comboTriage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboTriage.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		panel_1.add(comboTriage);

		// exam1 label layout
		springLayout.putConstraint(SpringLayout.WEST, lblExam1, 17, SpringLayout.EAST, pnlPatientInfo);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDCExam1, -6, SpringLayout.NORTH, lblExam1);
		springLayout.putConstraint(SpringLayout.NORTH, lblExam1, 6, SpringLayout.SOUTH, btnExam1Add);
		springLayout.putConstraint(SpringLayout.SOUTH, lblExam1, -35, SpringLayout.NORTH, panel_1);
		frame.getContentPane().add(lblExam1);

		// exam2 label layout
		springLayout.putConstraint(SpringLayout.WEST, lblExam2, 709, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblExam1, -26, SpringLayout.WEST, lblExam2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDCExam2, -6, SpringLayout.NORTH, lblExam2);
		springLayout.putConstraint(SpringLayout.NORTH, lblExam2, 6, SpringLayout.SOUTH, btnExam2);
		springLayout.putConstraint(SpringLayout.SOUTH, lblExam2, -35, SpringLayout.NORTH, panel_1);
		frame.getContentPane().add(lblExam2);

		// exam3label layout
		springLayout.putConstraint(SpringLayout.EAST, lblExam2, -20, SpringLayout.WEST, lblExam3);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDCExam3, -6, SpringLayout.NORTH, lblExam3);
		springLayout.putConstraint(SpringLayout.NORTH, lblExam3, 6, SpringLayout.SOUTH, btnExam3);
		springLayout.putConstraint(SpringLayout.WEST, lblExam3, 895, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblExam3, -35, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblExam3, 0, SpringLayout.EAST, canvas_2);
		frame.getContentPane().add(lblExam3);

		JLabel lblTreatmentCat = new JLabel("Treatment Category");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblTreatmentCat, -3, SpringLayout.NORTH, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblTreatmentCat, 267, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblTreatmentCat, 15, SpringLayout.NORTH, lblTriageRating);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblTreatmentCat, 14, SpringLayout.EAST, comboTreatmentCat);
		panel_1.add(lblTreatmentCat);
		panel_1.add(comboTreatmentCat);
		comboTreatmentCat.setModel(new DefaultComboBoxModel(new String[] { "OB", "GENERAL", "CARDIAC", "NEURO" }));

		springLayout.putConstraint(SpringLayout.NORTH, lblDCExam1, 6, SpringLayout.SOUTH, lblExam1);
		springLayout.putConstraint(SpringLayout.WEST, lblDCExam1, 17, SpringLayout.EAST, pnlPatientInfo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDCExam1, 20, SpringLayout.SOUTH, lblExam1);
		springLayout.putConstraint(SpringLayout.EAST, lblDCExam1, 0, SpringLayout.EAST, panel_1);
		frame.getContentPane().add(lblDCExam1);

		// creates a tree that accepts hospital nodes

		HospitalNode node1 = new HospitalNode(1, "Triage Rating > 2"); // creating
																		// nodes
		HospitalNode node2 = new HospitalNode(2, "Discharged home.");
		HospitalNode node3 = new HospitalNode(3, "Patient age > 18");
		HospitalNode node4 = new HospitalNode(4, "Triage Rating = 5");
		HospitalNode node5 = new HospitalNode(5, "Admit to hospital");
		HospitalNode node6 = new HospitalNode(6, "Pediatric general");
		HospitalNode node7 = new HospitalNode(7, "Pediatric Intensive Care");
		HospitalNode node8 = new HospitalNode(8, "Admitted to Medical Unit");

		// create yes/no tree
		hospitalTree.createRoot(node1); // inserting nodes
		hospitalTree.addNoNode(1, node2);
		hospitalTree.addYesNode(1, node3);
		hospitalTree.addNoNode(3, node4);
		hospitalTree.addYesNode(3, node5);
		hospitalTree.addNoNode(4, node6);
		hospitalTree.addYesNode(4, node7);
		hospitalTree.addNoNode(5, node8);

		Patient ethan = new Patient(); // minor with a triage rating of 5 goes
										// into pediatric intensive care
		ethan.setID(106);
		ethan.setFirstName("Ethan");
		ethan.setLastName("Taylor");
		ethan.setDOB(LocalDate.of(2001, Month.JUNE, 27));
		ethan.setTreatmentCategory("PEDS");
		ethan.setTriageRating(5);
		ethan.setEmergent(true);

		Patient drew = new Patient();
		drew.setID(101);
		drew.setFirstName("Drew");
		drew.setLastName("Douglass");
		drew.setDOB(LocalDate.of(1973, Month.JUNE, 27));
		drew.setTreatmentCategory("NEURO");
		drew.setTriageRating(5);
		drew.setEmergent(true);

		Patient john = new Patient(); // minor with triage under 5. goes into
										// pediatric general
		john.setID(107);
		john.setFirstName("John");
		john.setLastName("Doe");
		john.setDOB(LocalDate.of(2001, Month.JUNE, 27));
		john.setTriageRating(4);
		john.setEmergent(true);

		Patient ted = new Patient();
		ted.setID(105);
		ted.setFirstName("Ted");
		ted.setLastName("Moseby");
		ted.setDOB(LocalDate.of(1975, Month.AUGUST, 03));
		ted.setTreatmentCategory("CARDIAC");
		ted.setTriageRating(4);
		ted.setEmergent(true);

		Patient sam = new Patient(); // adult with a rating of 3
		sam.setID(108);
		sam.setFirstName("Sam");
		sam.setLastName("Batterson");
		sam.setDOB(LocalDate.of(1987, Month.JUNE, 27));
		sam.setTreatmentCategory("GENERAL");
		sam.setTriageRating(3);
		sam.setEmergent(true);

		Patient alexis = new Patient();
		alexis.setID(103);
		alexis.setFirstName("Alexis");
		alexis.setLastName("Snowden");
		alexis.setDOB(LocalDate.of(1983, Month.MARCH, 25));
		alexis.setTreatmentCategory("OB");
		alexis.setTriageRating(1);
		alexis.setEmergent(false);

		Patient kali = new Patient();
		kali.setID(104);
		kali.setFirstName("Kali");
		kali.setLastName("Aria");
		kali.setDOB(LocalDate.of(2005, Month.MARCH, 03));
		kali.setTreatmentCategory("PEDS");
		kali.setTriageRating(2);
		kali.setEmergent(false);

		criticalPatientList.add(ethan); // default patients so instructor
										// doesn't have to add a bunch to test
		criticalPatientList.add(drew);
		criticalPatientList.add(ted);
		criticalPatientList.add(john);
		criticalPatientList.add(sam);
		nonCriticalPatientList.add(kali);
		nonCriticalPatientList.add(alexis);

		for (Patient p : criticalPatientList) // adding default patients to
												// queue
		{
			lstEmergentList.add(p.toString());
		}

		for (Patient p : nonCriticalPatientList) // adding default patients to
													// other queue
		{
			lstNonEmergentList.add(p.toString());
		}

		btnCreatePatient.addActionListener(new ActionListener() { // create
																	// patient
																	// button
																	// action
																	// listener
			public void actionPerformed(ActionEvent e) {
				int tempTriage = Integer.parseInt(comboTriage.getSelectedItem().toString());
				if (tempTriage > 2) {
					criticalPatientList.add(createPatient()); // calls method of
																// create
																// patient

					java.util.Iterator<Patient> itr1 = emergentQueue.iterator(); // iterator
																					// for
																					// priority
																					// queue

					for (Patient p : criticalPatientList) { // passing all of
															// the patients on
															// the list back
															// into the queue to
															// be reordered

						emergentQueue.add(p); // adding patients to the queue
												// after reorder

					}
					lstEmergentList.removeAll(); // clear list after getting all
													// of the patients out
					while (itr1.hasNext()) { // while loop that adds the
												// patients back to the list
												// after being ordered in the
												// queue

						lstEmergentList.add(emergentQueue.poll().toString()); // calls
																				// toString
																				// method
																				// for
																				// the
																				// patient
																				// so
																				// they
																				// can
																				// be
																				// displayed
																				// in
																				// the
																				// emergent
																				// patient
																				// gui
																				// list
					}
				} else if (tempTriage <= 2) // if patient is not critical
				{
					nonCriticalPatientList.add(createPatient()); // create
																	// patient
																	// and add
																	// to list

					java.util.Iterator<Patient> itr1 = nonEmergentQueue.iterator(); // create
																					// iterator
																					// for
																					// queue

					for (Patient p : nonCriticalPatientList) {

						nonEmergentQueue.add(p);

					}
					lstNonEmergentList.removeAll();
					while (itr1.hasNext()) { // while loop to display to string
												// of patient to the non
												// critical list in gui

						lstNonEmergentList.add(nonEmergentQueue.poll().toString());
					}
				}
			}
		});

		btnExam1Add.addActionListener(new ActionListener() { 				// Exam 1 button
																			// action
																			// listener
																			// function
			public void actionPerformed(ActionEvent arg0) {
				if (room1Open == true) {
					Canvas.setBackground(new Color(204, 0, 0)); //
					lblExam1.setText("");
					lblDCExam1.setText("");
					room1Open = false;
					if (lstEmergentList.getItemCount() > 0) {

						lblExam1.setText(lstEmergentList.getItem(0));

						int temp = Integer.parseInt(lstEmergentList.getItem(0).substring(1, 4));
						System.out.println(temp);
						for (int i = 0; i < criticalPatientList.size(); i++) {
							if (criticalPatientList.get(i).ID == temp) {
								exam1Patient = criticalPatientList.get(i);
								criticalPatientList.remove(i);
								break;
							}
						}

						java.util.Iterator<Patient> itr1 = emergentQueue.iterator();

						for (Patient p : criticalPatientList) {

							emergentQueue.add(p);

						}
						lstEmergentList.removeAll();
						while (itr1.hasNext()) {

							lstEmergentList.add(emergentQueue.poll().toString());

						}
					} else if (lstEmergentList.getItemCount() == 0 && lstNonEmergentList.getItemCount() > 0) {
						lblExam1.setText(lstNonEmergentList.getItem(0));

						int temp = Integer.parseInt(lstNonEmergentList.getItem(0).substring(1, 4));
						System.out.println(temp);
						for (int i = 0; i < nonCriticalPatientList.size(); i++) {
							if (nonCriticalPatientList.get(i).ID == temp) {
								exam1Patient = nonCriticalPatientList.get(i);
								nonCriticalPatientList.remove(i);
								break;
							}
						}

						java.util.Iterator<Patient> itr1 = nonEmergentQueue.iterator();

						for (Patient p : nonCriticalPatientList) {

							nonEmergentQueue.add(p);

						}
						lstNonEmergentList.removeAll();
						while (itr1.hasNext()) {

							lstNonEmergentList.add(nonEmergentQueue.poll().toString());

						}
					} else {
						lblExam1.setText("Queue is empty!");
						room1Open = true;
						Canvas.setBackground(new Color(0, 153, 0));
					}
				}
			}
		});

		btnExam2.addActionListener(new ActionListener() { // Exam 2 button
															// function
			public void actionPerformed(ActionEvent arg0) {
				if(room2Open == true)
				{
				canvas_1.setBackground(new Color(204, 0, 0));
				if (lstEmergentList.getItemCount() > 0) {
					lblExam2.setText(lstEmergentList.getItem(0));

					int temp = Integer.parseInt(lstEmergentList.getItem(0).substring(1, 4));
					System.out.println(temp);
					for (int i = 0; i < criticalPatientList.size(); i++) {
						if (criticalPatientList.get(i).ID == temp) {
							exam2Patient = criticalPatientList.get(i);
							criticalPatientList.remove(i);
							break;
						}
					}

					java.util.Iterator<Patient> itr1 = emergentQueue.iterator();

					for (Patient p : criticalPatientList) {

						emergentQueue.add(p);

					}
					lstEmergentList.removeAll();
					while (itr1.hasNext()) {

						lstEmergentList.add(emergentQueue.poll().toString());

					}
				} else if (lstEmergentList.getItemCount() == 0 && lstNonEmergentList.getItemCount() > 0) {
					lblExam2.setText(lstNonEmergentList.getItem(0));

					int temp = Integer.parseInt(lstNonEmergentList.getItem(0).substring(1, 4));
					System.out.println(temp);
					for (int i = 0; i < nonCriticalPatientList.size(); i++) {
						if (nonCriticalPatientList.get(i).ID == temp) {
							exam2Patient = nonCriticalPatientList.get(i);
							nonCriticalPatientList.remove(i);
							break;
						}
					}

					java.util.Iterator<Patient> itr1 = nonEmergentQueue.iterator();

					for (Patient p : nonCriticalPatientList) {

						nonEmergentQueue.add(p);

					}
					lstNonEmergentList.removeAll();
					while (itr1.hasNext()) {

						lstNonEmergentList.add(nonEmergentQueue.poll().toString());

					}
				} else {
					lblExam2.setText("Queue is empty!");
					room2Open = true;
					canvas_1.setBackground(new Color(0, 153, 0));
				}
			}
			}
		});

		btnExam3.addActionListener(new ActionListener() { // Exam 3 button
															// function
			public void actionPerformed(ActionEvent e) {
				if(room3Open == true)
				{
				room3Open = false;
				canvas_2.setBackground(new Color(204, 0, 0));
				if (lstEmergentList.getItemCount() > 0) {
					lblExam3.setText(lstEmergentList.getItem(0));

					int temp = Integer.parseInt(lstEmergentList.getItem(0).substring(1, 4));
					System.out.println(temp);
					for (int i = 0; i < criticalPatientList.size(); i++) {
						if (criticalPatientList.get(i).ID == temp) {
							exam3Patient = criticalPatientList.get(i);
							criticalPatientList.remove(i);
							break;
						}
					}

					java.util.Iterator<Patient> itr1 = emergentQueue.iterator();

					for (Patient p : criticalPatientList) {

						emergentQueue.add(p);

					}
					lstEmergentList.removeAll();
					while (itr1.hasNext()) {

						lstEmergentList.add(emergentQueue.poll().toString());

					}
				} else if (lstEmergentList.getItemCount() == 0 && lstNonEmergentList.getItemCount() > 0) {
					lblExam3.setText(lstNonEmergentList.getItem(0));

					int temp = Integer.parseInt(lstNonEmergentList.getItem(0).substring(1, 4));
					System.out.println(temp);
					for (int i = 0; i < nonCriticalPatientList.size(); i++) {
						if (nonCriticalPatientList.get(i).ID == temp) {
							exam3Patient = nonCriticalPatientList.get(i);
							nonCriticalPatientList.remove(i);
							break;
						}
					}

					java.util.Iterator<Patient> itr1 = nonEmergentQueue.iterator();

					for (Patient p : nonCriticalPatientList) {

						nonEmergentQueue.add(p);

					}
					lstNonEmergentList.removeAll();
					while (itr1.hasNext()) {

						lstNonEmergentList.add(nonEmergentQueue.poll().toString());

					}
				} else {
					lblExam3.setText("Queue is empty!");
					room3Open = true;
					canvas_2.setBackground(new Color(0, 153, 0));
				}
			}
			}
		});

		lstEmergentList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					lstNonEmergentList.deselect(lstNonEmergentList.getSelectedIndex());
					;
					getEmergentPatient();

				}

			}
		});

		lstNonEmergentList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					lstEmergentList.deselect(lstEmergentList.getSelectedIndex());
					;
					getNonEmergentPatient();

				}

			}
		});

		btnDCExam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//exam1Patient = null;
				dischargePatient(exam1Patient);
				Canvas.setBackground(new Color(0, 153, 0));
				lblExam1.setText(null);
				exam1Patient = null;
				room1Open = true;
			}
		});

		btnDCExam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dischargePatient(exam2Patient);
				canvas_1.setBackground(new Color(0, 153, 0));
				lblExam2.setText(null);
				exam2Patient = null;
				room2Open = true;
			}
		});

		btnDCExam3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dischargePatient(exam3Patient);
				canvas_2.setBackground(new Color(0, 153, 0));
				lblExam3.setText(null);
				exam3Patient = null;
				room3Open = true;
			}
		});

	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return create a patient from getters and setters
	 */
	public Patient createPatient() { // create patient method
		int ID;
		String firstName;
		String lastName;
		LocalDate dOB;
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
		String chiefComplaint;
		String treatmentCategory;

		String company = null;
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
		treatmentCategory = newPatient.getTreatmentCategory();
		chiefComplaint = newPatient.getChiefComplaint();

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
		newPatient.setChiefComplaint(chiefComplaint);
		newPatient.setTreatmentCategory(treatmentCategory);

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

	/**
	 * takes patient information from variables and displays them in the list
	 */
	public void getEmergentPatient() {
		int temp = Integer.parseInt(lstEmergentList.getSelectedItem().substring(1, 4));
		for (int i = 0; i < criticalPatientList.size(); i++) {
			if (criticalPatientList.get(i).ID == temp) {
				lblPatientMRN.setText(String.valueOf(temp));
				lblSelectedPatientFirst.setText(criticalPatientList.get(i).firstName);
				lblSelectedPatientLast.setText(criticalPatientList.get(i).lastName);
				lblSelectedPatientComp.setText(criticalPatientList.get(i).chiefComplaint);
				lblSelectedPatientCat.setText(criticalPatientList.get(i).treatmentCategory);
				lblSelectedPatientTR.setText(String.valueOf(criticalPatientList.get(i).triageRating));
			}
		}

	}

	/**
	 * takes patient information from vaiables and displays them to the
	 * nonemergent list
	 */
	public void getNonEmergentPatient() {
		int temp = Integer.parseInt(lstNonEmergentList.getSelectedItem().substring(1, 4));
		for (int i = 0; i < nonCriticalPatientList.size(); i++) {
			if (nonCriticalPatientList.get(i).ID == temp) {

				lblPatientMRN.setText(String.valueOf(temp));
				lblSelectedPatientFirst.setText(nonCriticalPatientList.get(i).firstName);
				lblSelectedPatientLast.setText(nonCriticalPatientList.get(i).lastName);
				lblSelectedPatientComp.setText(nonCriticalPatientList.get(i).chiefComplaint);
				lblSelectedPatientCat.setText(nonCriticalPatientList.get(i).treatmentCategory);
				lblSelectedPatientTR.setText(String.valueOf(nonCriticalPatientList.get(i).triageRating));
			}
		}
	}

	/**
	 * @param p
	 *            creates node from patient information and calls the
	 *            placePatient method
	 */
	public void dischargePatient(Patient p) {
		HospitalNode newNode = new HospitalNode(p.ID, p);
		System.out.println("Patient discharged");

		placePatient(newNode, hospitalTree);
	}

	/**
	 * @param currentNode
	 * @param tree
	 *            uses the parameters currentNode and tree to send a patient
	 *            node through the decision tree
	 */
	void placePatient(HospitalNode currentNode, HospitalTree tree) {
		String answer;
		if (currentNode.nodePatient.triageRating < 3) {
			answer = "No";
		} else {
			answer = "Yes";
		}
		if (answer.equals("Yes") && currentNode.nodeID > 100) {
			tree.root.nodePatient = currentNode.nodePatient;
			ZoneId zonedId = ZoneId.of("America/Montreal");
			LocalDate today = LocalDate.now(zonedId);

			if (calculateAge(currentNode.nodePatient.DOB, today) > 18) {
				tree.root.yesBranch.nodePatient = currentNode.nodePatient;
				String category = "";
				category = tree.root.yesBranch.nodePatient.treatmentCategory;
				switch (category) {
				case "OB":
					lblDCExam1.setText("Patient " + tree.root.yesBranch.nodePatient.ID + " discharged " + ": "
							+ "OB/GYN " + today);
					System.out.println("patient discharged to OB/GYN");
					break;
				case "GENERAL":
					lblDCExam1.setText("Patient " + tree.root.yesBranch.nodePatient.ID + " discharged " + ": "
							+ "general surgery " + today);
					System.out.println("patient discharged to general surgery");
					break;
				case "NEURO":
					lblDCExam1.setText("Patient " + tree.root.yesBranch.nodePatient.ID + " discharged " + ": "
							+ "neuro unit " + today);
					System.out.println("patient discharged to neuro unit");
					break;
				case "CARDIAC":
					lblDCExam1.setText("Patient " + tree.root.yesBranch.nodePatient.ID + " discharged " + ": "
							+ "cardiac unit " + today);
					System.out.println("patient discharged to cardiac unit");
					break;
				}
			} else {
				tree.root.yesBranch.noBranch.nodePatient = currentNode.nodePatient; // PEDS
				if (currentNode.nodePatient.triageRating > 4) {
					tree.root.yesBranch.noBranch.yesBranch.nodePatient = currentNode.nodePatient;
					lblDCExam1.setText("Discharged " + ": " + "pediatric intensive care " + today);
					System.out.println(tree.root.yesBranch.noBranch.yesBranch.decision);
				} else if (currentNode.nodePatient.triageRating < 5) {
					tree.root.yesBranch.noBranch.noBranch.nodePatient = currentNode.nodePatient;
					lblDCExam1.setText("Discharged " + ": " + "general pediatrics " + today);
					System.out.println(tree.root.yesBranch.noBranch.noBranch.decision);
				}
			}
		} else if (answer.equals("No")) {
			lblDCExam1.setText("Discharged " + ": " + "to community ");
			System.out.println("patient discharged home");
			return;
		}

	}

	/**
	 * @param dOB2
	 * @param date
	 * @return uses the dob and the current date to figure the age of the
	 *         patient. Patients under 18 are sent to pediatrics
	 */
	public int calculateAge(LocalDate dOB2, LocalDate date) {
		if ((dOB2 != null) && (date != null)) {
			return Period.between(dOB2, date).getYears();
		} else {
			return 0;
		}

	}
}
