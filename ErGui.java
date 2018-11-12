package finalProject;

import java.awt.EventQueue;
import java.util.Date;
import java.util.LinkedList;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JProgressBar;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;

public class ErGui {

	private JFrame frame;
	static JTextField txtLastName;
	private JTextField txtPatientID;
	private JFormattedTextField textField_4;
	private JTextField txtZipcode;
	static JTextField txtFirstName;
	private JTextField txtStreetAddress1;
	private JTextField txtStreetAddress2;
	private JTextField txtHomePhone;
	private JTextField txtWorkPhone;
	private JTextField txtCellPhone;
	private JTextField txtEmail;
	private JTextField txtInsuranceName;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtInsuredStreet;
	private JTextField txtGroupNum;
	private JTextField txtPolicyNum;
	private JTextField txtInsuredZip;
	private JTextField txtInsuredApt;
	
	private List lstEmergentQueue  = new List();
	

	public List getEmergentQueue() {
		return lstEmergentQueue;
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
		frame.setBounds(100, 100, 1080, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, lstEmergentQueue, 735, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lstEmergentQueue, -21, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		
		JPanel pnlPatientInfo = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, pnlPatientInfo, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, pnlPatientInfo, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pnlPatientInfo, -289, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, pnlPatientInfo, -574, SpringLayout.EAST, frame.getContentPane());
		pnlPatientInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(pnlPatientInfo);
		SpringLayout sl_pnlPatientInfo = new SpringLayout();
		pnlPatientInfo.setLayout(sl_pnlPatientInfo);
		
		JLabel lblPatientHeader = new JLabel("Patient Information");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblPatientHeader, 4, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, lblPatientHeader, 10, SpringLayout.WEST, pnlPatientInfo);
		lblPatientHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlPatientInfo.add(lblPatientHeader);
		
		JLabel lblPatientMRN = new JLabel("Patient MRN");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblPatientMRN, 12, SpringLayout.SOUTH, lblPatientHeader);
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
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, lblPatientMRN, 0, SpringLayout.WEST, lblDateOfBirth);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblDateOfBirth, 18, SpringLayout.SOUTH, lblLastName);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblDateOfBirth);
		
		JLabel lblStreetAddress1 = new JLabel("Street Address 1");
		lblStreetAddress1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblStreetAddress1);
		
		JLabel lblState = new JLabel("State");
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblState, -55, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblState, -361, SpringLayout.EAST, pnlPatientInfo);
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblState);
		
		txtLastName = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblLastName, -6, SpringLayout.WEST, txtLastName);
		pnlPatientInfo.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtPatientID = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtPatientID, 12, SpringLayout.SOUTH, lblPatientHeader);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblPatientMRN, -6, SpringLayout.WEST, txtPatientID);
		pnlPatientInfo.add(txtPatientID);
		txtPatientID.setColumns(10);
		
		DateFormat dFormat = new SimpleDateFormat("MM/dd/yy");
		JFormattedTextField txtDOB = new JFormattedTextField(dFormat);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblDateOfBirth, -6, SpringLayout.WEST, txtDOB);
		TextPrompt tpDate =  new TextPrompt("MM/DD/YYYY", txtDOB);
		tpDate.setHorizontalAlignment(SwingConstants.LEADING);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtDOB, 140, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtLastName, -15, SpringLayout.NORTH, txtDOB);
		pnlPatientInfo.add(txtDOB);
		txtDOB.setColumns(10);
		
		txtZipcode = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtZipcode, -38, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtZipcode, -18, SpringLayout.SOUTH, pnlPatientInfo);
		pnlPatientInfo.add(txtZipcode);
		txtZipcode.setColumns(10);
		
		JLabel lblPatientZipcode = new JLabel("Zip");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtZipcode, 92, SpringLayout.EAST, lblPatientZipcode);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblPatientZipcode, -361, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtZipcode, 6, SpringLayout.EAST, lblPatientZipcode);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblPatientZipcode, 19, SpringLayout.SOUTH, lblState);
		lblPatientZipcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblPatientZipcode);
		
		txtFirstName = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblFirstName, -6, SpringLayout.WEST, txtFirstName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtLastName, 15, SpringLayout.SOUTH, txtFirstName);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtFirstName, -228, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtFirstName, 70, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtPatientID, -15, SpringLayout.NORTH, txtFirstName);
		pnlPatientInfo.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JPanel pnlInsuranceInfo = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, pnlInsuranceInfo, 0, SpringLayout.NORTH, lstEmergentQueue);
		springLayout.putConstraint(SpringLayout.WEST, pnlInsuranceInfo, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pnlInsuranceInfo, 0, SpringLayout.SOUTH, lstEmergentQueue);
		pnlInsuranceInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblStreetAddress2 = new JLabel("Street Address 2");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblStreetAddress2, 210, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblStreetAddress2, -19, SpringLayout.NORTH, lblState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblStreetAddress1, -19, SpringLayout.NORTH, lblStreetAddress2);
		lblStreetAddress2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPatientInfo.add(lblStreetAddress2);
		
		txtStreetAddress1 = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtStreetAddress1, 175, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtDOB, -15, SpringLayout.NORTH, txtStreetAddress1);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblStreetAddress1, -6, SpringLayout.WEST, txtStreetAddress1);
		pnlPatientInfo.add(txtStreetAddress1);
		txtStreetAddress1.setColumns(10);
		
		txtStreetAddress2 = new JTextField();
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtStreetAddress2, 210, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtStreetAddress1, -15, SpringLayout.NORTH, txtStreetAddress2);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblStreetAddress2, -6, SpringLayout.WEST, txtStreetAddress2);
		pnlPatientInfo.add(txtStreetAddress2);
		txtStreetAddress2.setColumns(10);
		
		JComboBox comboBoxState = new JComboBox();
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtStreetAddress2, -23, SpringLayout.NORTH, comboBoxState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, comboBoxState, -307, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, comboBoxState, 249, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, comboBoxState, 10, SpringLayout.EAST, lblState);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, comboBoxState, -11, SpringLayout.NORTH, txtZipcode);
		comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		pnlPatientInfo.add(comboBoxState);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblHomePhone, 38, SpringLayout.NORTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtPatientID, -106, SpringLayout.WEST, lblHomePhone);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtPatientID, -20, SpringLayout.WEST, lblHomePhone);
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
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtCellPhone, -15, SpringLayout.NORTH, txtEmail);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblEmail, -6, SpringLayout.WEST, txtEmail);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtEmail, 322, SpringLayout.WEST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtEmail, -39, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(txtEmail);
		txtEmail.setColumns(10);
		
		JComboBox comboGender = new JComboBox();
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, txtEmail, -14, SpringLayout.NORTH, comboGender);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, comboGender, -109, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, txtEmail, -34, SpringLayout.NORTH, comboGender);
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, comboGender, 0, SpringLayout.NORTH, lblStreetAddress1);
		pnlPatientInfo.add(comboGender);
		
		JLabel lblGender = new JLabel("Gender");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblGender, -170, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, comboGender, 6, SpringLayout.EAST, lblGender);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtStreetAddress1, -141, SpringLayout.WEST, lblGender);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtStreetAddress1, -55, SpringLayout.WEST, lblGender);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, lblGender, 0, SpringLayout.NORTH, lblStreetAddress1);
		pnlPatientInfo.add(lblGender);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, rdbtnSingle, -1, SpringLayout.NORTH, lblStreetAddress2);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, rdbtnSingle, -164, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, rdbtnSingle, 0, SpringLayout.EAST, txtHomePhone);
		pnlPatientInfo.add(rdbtnSingle);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, rdbtnMarried, 10, SpringLayout.SOUTH, rdbtnSingle);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, rdbtnMarried, 0, SpringLayout.WEST, rdbtnSingle);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, rdbtnMarried, -53, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, rdbtnMarried, -74, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(rdbtnMarried);
		
		JRadioButton rdbtnDivorced = new JRadioButton("Divorced");
		sl_pnlPatientInfo.putConstraint(SpringLayout.NORTH, rdbtnDivorced, 11, SpringLayout.SOUTH, rdbtnMarried);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, rdbtnDivorced, 105, SpringLayout.EAST, txtZipcode);
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, rdbtnDivorced, -19, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, rdbtnDivorced, -97, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(rdbtnDivorced);
		
		ButtonGroup Bg = new ButtonGroup();
		
		Bg.add(rdbtnSingle);
		Bg.add(rdbtnMarried);
		Bg.add(rdbtnDivorced);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status");
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, lblMaritalStatus, -170, SpringLayout.EAST, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.WEST, txtStreetAddress2, -104, SpringLayout.WEST, lblMaritalStatus);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, txtStreetAddress2, -18, SpringLayout.WEST, lblMaritalStatus);
		lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, lblMaritalStatus, 0, SpringLayout.SOUTH, lblStreetAddress2);
		pnlPatientInfo.add(lblMaritalStatus);
		frame.getContentPane().add(pnlInsuranceInfo);
		SpringLayout sl_pnlInsuranceInfo = new SpringLayout();
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
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuranceName, 8, SpringLayout.EAST, lblInsuranceCo);
		pnlInsuranceInfo.add(txtInsuranceName);
		txtInsuranceName.setColumns(10);
		
		txtFirst = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtInsuranceName, -11, SpringLayout.NORTH, txtFirst);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtFirst, -219, SpringLayout.EAST, pnlInsuranceInfo);
		TextPrompt tpFirst =  new TextPrompt("First Name", txtFirst);
		tpFirst.setHorizontalAlignment(SwingConstants.LEADING);
		tpFirst.setText("First");
		txtFirst.setColumns(7);
		pnlInsuranceInfo.add(txtFirst);
		
		JLabel lblPolicyNum = new JLabel("Policy No.");
		lblPolicyNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPolicyNum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(lblPolicyNum);
		
		JLabel lblGroupNum = new JLabel("Group No.");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, lblGroupNum, -13, SpringLayout.SOUTH, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, lblPolicyNum, -22, SpringLayout.NORTH, lblGroupNum);
		lblGroupNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGroupNum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlInsuranceInfo.add(lblGroupNum);
		
		txtLast = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuranceName, 0, SpringLayout.EAST, txtLast);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, txtLast, 0, SpringLayout.NORTH, txtFirst);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtLast, 6, SpringLayout.EAST, txtFirst);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtLast, -12, SpringLayout.EAST, pnlInsuranceInfo);
		TextPrompt tpLast =  new TextPrompt("Last", txtLast);
		tpLast.setHorizontalAlignment(SwingConstants.LEADING);
		tpLast.setText("Last");
		pnlInsuranceInfo.add(txtLast);
		txtLast.setColumns(10);
		
		txtInsuredStreet = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtFirst, -12, SpringLayout.NORTH, txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, tpFirst, 0, SpringLayout.WEST, txtInsuredStreet);
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
		lblCoPay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlInsuranceInfo.add(lblCoPay);
		
		txtGroupNum = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblGroupNum, -8, SpringLayout.WEST, txtGroupNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.NORTH, lblCoPay, 0, SpringLayout.NORTH, txtGroupNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, lblCoPay, 34, SpringLayout.EAST, txtGroupNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtGroupNum, 0, SpringLayout.WEST, txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtGroupNum, -197, SpringLayout.EAST, pnlInsuranceInfo);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtGroupNum, -6, SpringLayout.SOUTH, pnlInsuranceInfo);
		pnlInsuranceInfo.add(txtGroupNum);
		txtGroupNum.setColumns(10);
		
		JLabel lblNameInsured = new JLabel("Policy Holder");
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtFirst, 8, SpringLayout.EAST, lblNameInsured);
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
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblPolicyNum, -8, SpringLayout.WEST, txtPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, comboInsuredState, -16, SpringLayout.NORTH, txtPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtPolicyNum, 0, SpringLayout.WEST, txtInsuredStreet);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtPolicyNum, -18, SpringLayout.NORTH, txtGroupNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtPolicyNum, 0, SpringLayout.EAST, txtGroupNum);
		pnlInsuranceInfo.add(txtPolicyNum);
		txtPolicyNum.setColumns(10);
		
		txtInsuredZip = new JTextField();
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, txtInsuredZip, -16, SpringLayout.NORTH, txtPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, txtInsuredZip, 0, SpringLayout.EAST, txtGroupNum);
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
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -19, SpringLayout.NORTH, txtPolicyNum);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.WEST, txtInsuredZip, 4, SpringLayout.EAST, lblNewLabel_1);
		sl_pnlInsuranceInfo.putConstraint(SpringLayout.EAST, lblNewLabel_1, -285, SpringLayout.EAST, pnlInsuranceInfo);
		pnlInsuranceInfo.add(lblNewLabel_1);
		frame.getContentPane().add(lstEmergentQueue);
		
		List lstNonEmergentQueue = new List();
		springLayout.putConstraint(SpringLayout.EAST, lstEmergentQueue, -21, SpringLayout.WEST, lstNonEmergentQueue);
		springLayout.putConstraint(SpringLayout.WEST, lstNonEmergentQueue, -164, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lstNonEmergentQueue, -21, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lstNonEmergentQueue, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lstNonEmergentQueue);
		
		JLabel lblEmergencyList = new JLabel("Emergency Wait List");
		springLayout.putConstraint(SpringLayout.WEST, lblEmergencyList, 735, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lstEmergentQueue, 6, SpringLayout.SOUTH, lblEmergencyList);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmergencyList, -275, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(lblEmergencyList);
		
		JLabel lblNonEmergentList = new JLabel("Non-Emergent Wait List");
		springLayout.putConstraint(SpringLayout.NORTH, lstNonEmergentQueue, 6, SpringLayout.SOUTH, lblNonEmergentList);
		springLayout.putConstraint(SpringLayout.NORTH, lblNonEmergentList, 0, SpringLayout.NORTH, lblEmergencyList);
		springLayout.putConstraint(SpringLayout.WEST, lblNonEmergentList, 0, SpringLayout.WEST, lstNonEmergentQueue);
		frame.getContentPane().add(lblNonEmergentList);
		
		JButton btnCreatePatient = new JButton("Create");
		btnCreatePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createPatient();
			}
		});
		sl_pnlPatientInfo.putConstraint(SpringLayout.SOUTH, btnCreatePatient, -10, SpringLayout.SOUTH, pnlPatientInfo);
		sl_pnlPatientInfo.putConstraint(SpringLayout.EAST, btnCreatePatient, -10, SpringLayout.EAST, pnlPatientInfo);
		pnlPatientInfo.add(btnCreatePatient);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, pnlInsuranceInfo, -17, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel, -18, SpringLayout.WEST, lstEmergentQueue);
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
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 10, SpringLayout.WEST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_7, 170, SpringLayout.WEST, lblNewLabel_2);
		panel.add(lblNewLabel_7);
		
		JLabel label = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, label, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -6, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, lblNewLabel_7);
		panel.add(label);
		
		JLabel label_1 = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_1, -6, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.EAST, label_1, 0, SpringLayout.EAST, lblNewLabel_7);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, label_2, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_2, -6, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, label_2, 0, SpringLayout.EAST, lblNewLabel_7);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, label_3, 9, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, label_3, 10, SpringLayout.WEST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, label_3, 0, SpringLayout.EAST, lblNewLabel_7);
		panel.add(label_3);
		
		JProgressBar progressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 17, SpringLayout.EAST, pnlPatientInfo);
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar, -351, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, progressBar, -391, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		springLayout.putConstraint(SpringLayout.WEST, progressBar_1, 26, SpringLayout.EAST, progressBar);
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar_1, -351, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, progressBar_1, -199, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		springLayout.putConstraint(SpringLayout.WEST, progressBar_2, 898, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar_2, 0, SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.EAST, progressBar_2, 0, SpringLayout.EAST, lstNonEmergentQueue);
		frame.getContentPane().add(progressBar_2);
		
		Button btnExam1Add = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.NORTH, btnExam1Add, 6, SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.WEST, btnExam1Add, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnExam1Add, -41, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, btnExam1Add, -479, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnExam1Add);
		
		Button button_1 = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 6, SpringLayout.SOUTH, progressBar_1);
		springLayout.putConstraint(SpringLayout.WEST, button_1, 0, SpringLayout.WEST, progressBar_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, -21, SpringLayout.NORTH, lblEmergencyList);
		springLayout.putConstraint(SpringLayout.EAST, button_1, -287, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("Add Patient");
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 6, SpringLayout.SOUTH, progressBar_2);
		springLayout.putConstraint(SpringLayout.WEST, button_2, 0, SpringLayout.WEST, progressBar_2);
		springLayout.putConstraint(SpringLayout.SOUTH, button_2, -21, SpringLayout.NORTH, lblNonEmergentList);
		springLayout.putConstraint(SpringLayout.EAST, button_2, -98, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(button_2);
		
		Canvas Canvas = new Canvas();
		springLayout.putConstraint(SpringLayout.SOUTH, Canvas, -371, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 6, SpringLayout.SOUTH, Canvas);
		springLayout.putConstraint(SpringLayout.NORTH, Canvas, 113, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, Canvas, 17, SpringLayout.EAST, pnlPatientInfo);
		Canvas.setBackground(new Color(0, 153, 0));
		Canvas.setForeground(new Color(0, 0, 0));
		Canvas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		frame.getContentPane().add(Canvas);
		
		Canvas canvas_1 = new Canvas();
		springLayout.putConstraint(SpringLayout.EAST, Canvas, -26, SpringLayout.WEST, canvas_1);
		springLayout.putConstraint(SpringLayout.NORTH, canvas_1, 0, SpringLayout.NORTH, Canvas);
		springLayout.putConstraint(SpringLayout.WEST, canvas_1, 0, SpringLayout.WEST, progressBar_1);
		springLayout.putConstraint(SpringLayout.SOUTH, canvas_1, -6, SpringLayout.NORTH, progressBar_1);
		springLayout.putConstraint(SpringLayout.EAST, canvas_1, -199, SpringLayout.EAST, frame.getContentPane());
		canvas_1.setBackground(new Color(0, 153, 0));
		frame.getContentPane().add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		springLayout.putConstraint(SpringLayout.NORTH, canvas_2, 0, SpringLayout.NORTH, Canvas);
		springLayout.putConstraint(SpringLayout.WEST, canvas_2, -125, SpringLayout.EAST, lblNonEmergentList);
		springLayout.putConstraint(SpringLayout.SOUTH, canvas_2, -371, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, canvas_2, 0, SpringLayout.EAST, lstNonEmergentQueue);
		canvas_2.setBackground(new Color(0, 153, 0));
		frame.getContentPane().add(canvas_2);
		
		Button button_3 = new Button("Discharge");
		springLayout.putConstraint(SpringLayout.NORTH, button_3, 6, SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.WEST, button_3, -78, SpringLayout.EAST, progressBar);
		springLayout.putConstraint(SpringLayout.SOUTH, button_3, 41, SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.EAST, button_3, 0, SpringLayout.EAST, progressBar);
		frame.getContentPane().add(button_3);
		
		Button button_4 = new Button("Discharge");
		springLayout.putConstraint(SpringLayout.NORTH, button_4, 6, SpringLayout.SOUTH, progressBar_1);
		springLayout.putConstraint(SpringLayout.WEST, button_4, 10, SpringLayout.EAST, button_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_4, 0, SpringLayout.SOUTH, btnExam1Add);
		springLayout.putConstraint(SpringLayout.EAST, button_4, 0, SpringLayout.EAST, progressBar_1);
		frame.getContentPane().add(button_4);
		
		Button button_5 = new Button("Discharge");
		springLayout.putConstraint(SpringLayout.NORTH, button_5, 6, SpringLayout.SOUTH, progressBar_2);
		springLayout.putConstraint(SpringLayout.WEST, button_5, -88, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button_5, -21, SpringLayout.NORTH, lblNonEmergentList);
		springLayout.putConstraint(SpringLayout.EAST, button_5, 0, SpringLayout.EAST, lstNonEmergentQueue);
		frame.getContentPane().add(button_5);
		
		
	
		
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void createPatient()
	{
		String firstName;
		String lastName;
		Date dOB;
		String streetAddress;
		String state;
		int zip;
		
		
		Patient newPatient = new Patient();
		
		firstName = newPatient.getFirstName();
		lastName = newPatient.getLastName();
		
		newPatient.setFirstName(firstName);
		newPatient.setLastName(lastName);
		
		System.out.println(newPatient.firstName.toString());
		
		
	}
}
