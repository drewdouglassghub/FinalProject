package finalProject;

import java.awt.EventQueue;
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

public class ErGui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JFormattedTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField textField_3;
	private JTextField textField_16;
	private JTextField textField_2;
	private JTextField textField_14;
	private JTextField textField_15;
	
	private List emergentQueue  = new List();
	

	public List getEmergentQueue() {
		return emergentQueue;
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
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -289, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -574, SpringLayout.EAST, frame.getContentPane());
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("Patient Information");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 4, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 12, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 61, SpringLayout.WEST, panel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		JLabel lblFirstName = new JLabel("First Name");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFirstName, 18, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblFirstName, 0, SpringLayout.EAST, lblNewLabel_1);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		sl_panel.putConstraint(SpringLayout.NORTH, lblLastName, 18, SpringLayout.SOUTH, lblFirstName);
		sl_panel.putConstraint(SpringLayout.EAST, lblLastName, 0, SpringLayout.EAST, lblNewLabel_1);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDateOfBirth, 18, SpringLayout.SOUTH, lblLastName);
		sl_panel.putConstraint(SpringLayout.EAST, lblDateOfBirth, 0, SpringLayout.EAST, lblNewLabel_1);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblDateOfBirth);
		
		JLabel lblStreetAddress = new JLabel("Street Address 1");
		lblStreetAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblStreetAddress);
		
		JLabel lblState = new JLabel("State");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblState, -55, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblState, -361, SpringLayout.EAST, panel);
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblState);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 12, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, textField_1);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		DateFormat dFormat = new SimpleDateFormat("MM/dd/yy");
		JFormattedTextField textField_4 = new JFormattedTextField(dFormat);
		TextPrompt tpDate =  new TextPrompt("MM/DD/YYYY", textField_4);
		tpDate.setHorizontalAlignment(SwingConstants.LEADING);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 140, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -15, SpringLayout.NORTH, textField_4);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_5, -38, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_5, -18, SpringLayout.SOUTH, panel);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Zip");
		sl_panel.putConstraint(SpringLayout.EAST, textField_5, 92, SpringLayout.EAST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, -361, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_5, 6, SpringLayout.EAST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 19, SpringLayout.SOUTH, lblState);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_2);
		
		textField_6 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 15, SpringLayout.SOUTH, textField_6);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_6, -228, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_6, 70, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, -15, SpringLayout.NORTH, textField_6);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 20, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -21, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -361, SpringLayout.EAST, frame.getContentPane());
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel_3 = new JLabel("Street Address 2");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 210, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -19, SpringLayout.NORTH, lblState);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblStreetAddress, -19, SpringLayout.NORTH, lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_3);
		
		textField_7 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_7, 175, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_4, -15, SpringLayout.NORTH, textField_7);
		sl_panel.putConstraint(SpringLayout.EAST, lblStreetAddress, -6, SpringLayout.WEST, textField_7);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_8, 210, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_7, -15, SpringLayout.NORTH, textField_8);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -6, SpringLayout.WEST, textField_8);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_8, -23, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -307, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 249, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.EAST, lblState);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox, -11, SpringLayout.NORTH, textField_5);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		panel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Home Phone");
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, -106, SpringLayout.WEST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -20, SpringLayout.WEST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_4, -170, SpringLayout.EAST, panel);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, lblNewLabel_1);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Work Phone");
		sl_panel.putConstraint(SpringLayout.WEST, textField_6, -108, SpringLayout.WEST, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.EAST, textField_6, -22, SpringLayout.WEST, lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, lblFirstName);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cell Phone");
		sl_panel.putConstraint(SpringLayout.WEST, textField, -122, SpringLayout.WEST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -36, SpringLayout.WEST, lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 3, SpringLayout.NORTH, lblLastName);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 282, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, -151, SpringLayout.WEST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, -65, SpringLayout.WEST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH, lblDateOfBirth);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_7);
		
		textField_9 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_9, 35, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_9, -164, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_9, -78, SpringLayout.EAST, panel);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_9, -15, SpringLayout.NORTH, textField_10);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_5, -6, SpringLayout.WEST, textField_10);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_10, 70, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_10, -164, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_10, -78, SpringLayout.EAST, panel);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_11, 105, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_10, -15, SpringLayout.NORTH, textField_11);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_6, -6, SpringLayout.WEST, textField_11);
		sl_panel.putConstraint(SpringLayout.WEST, textField_11, -164, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_11, -78, SpringLayout.EAST, panel);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_11, -15, SpringLayout.NORTH, textField_12);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_7, -6, SpringLayout.WEST, textField_12);
		sl_panel.putConstraint(SpringLayout.WEST, textField_12, 322, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_12, -39, SpringLayout.EAST, panel);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_12, -14, SpringLayout.NORTH, comboBox_1);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, -109, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_12, -34, SpringLayout.NORTH, comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, 0, SpringLayout.NORTH, lblStreetAddress);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_8, -170, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.WEST, textField_7, -141, SpringLayout.WEST, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.EAST, textField_7, -55, SpringLayout.WEST, lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 0, SpringLayout.NORTH, lblStreetAddress);
		panel.add(lblNewLabel_8);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnSingle, -1, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, rdbtnSingle, -164, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, rdbtnSingle, 0, SpringLayout.EAST, textField_9);
		panel.add(rdbtnSingle);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnMarried, 10, SpringLayout.SOUTH, rdbtnSingle);
		sl_panel.putConstraint(SpringLayout.WEST, rdbtnMarried, 0, SpringLayout.WEST, rdbtnSingle);
		sl_panel.putConstraint(SpringLayout.SOUTH, rdbtnMarried, -53, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, rdbtnMarried, -74, SpringLayout.EAST, panel);
		panel.add(rdbtnMarried);
		
		JRadioButton rdbtnDivorced = new JRadioButton("Divorced");
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnDivorced, 12, SpringLayout.SOUTH, rdbtnMarried);
		sl_panel.putConstraint(SpringLayout.WEST, rdbtnDivorced, 0, SpringLayout.WEST, rdbtnSingle);
		sl_panel.putConstraint(SpringLayout.SOUTH, rdbtnDivorced, -18, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, rdbtnDivorced, -78, SpringLayout.EAST, panel);
		panel.add(rdbtnDivorced);
		
		ButtonGroup Bg = new ButtonGroup();
		
		Bg.add(rdbtnSingle);
		Bg.add(rdbtnMarried);
		Bg.add(rdbtnDivorced);
		
		JLabel lblNewLabel_14 = new JLabel("Marital Status");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_14, -170, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_8, -104, SpringLayout.WEST, lblNewLabel_14);
		sl_panel.putConstraint(SpringLayout.EAST, textField_8, -18, SpringLayout.WEST, lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_14, 0, SpringLayout.SOUTH, lblNewLabel_3);
		panel.add(lblNewLabel_14);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel_9 = new JLabel("Insurance Information");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_9, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Insurance Co.");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_10);
		
		textField_13 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 3, SpringLayout.NORTH, textField_13);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_10, -6, SpringLayout.WEST, textField_13);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_13, 121, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_13, -190, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_13, 16, SpringLayout.SOUTH, lblNewLabel_9);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_11);
		
		txtFirst = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, txtFirst, 121, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtFirst, -403, SpringLayout.EAST, panel_1);
		TextPrompt tpFirst =  new TextPrompt("First Name", txtFirst);
		tpFirst.setHorizontalAlignment(SwingConstants.LEADING);
		tpFirst.setText("First");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 3, SpringLayout.NORTH, txtFirst);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_11, -6, SpringLayout.WEST, txtFirst);
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtFirst, 12, SpringLayout.SOUTH, textField_13);
		txtFirst.setColumns(10);
		panel_1.add(txtFirst);
		
		JLabel lblNewLabel_12 = new JLabel("Policy No.");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_12, 0, SpringLayout.EAST, lblNewLabel_10);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Group No.");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_12, -19, SpringLayout.NORTH, lblNewLabel_13);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_13, 62, SpringLayout.WEST, panel_1);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_13);
		
		txtLast = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.EAST, txtLast, 0, SpringLayout.EAST, textField_13);
		TextPrompt tpLast =  new TextPrompt("Last", txtLast);
		tpLast.setHorizontalAlignment(SwingConstants.LEADING);
		tpLast.setText("Last");
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtLast, 0, SpringLayout.NORTH, txtFirst);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtLast, 6, SpringLayout.EAST, txtFirst);
		panel_1.add(txtLast);
		txtLast.setColumns(10);
		
		textField_3 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_3, -269, SpringLayout.EAST, panel_1);
		textField_3.setColumns(10);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_15 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_15, -48, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_15, -393, SpringLayout.EAST, panel_1);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Street Address");
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_3, 7, SpringLayout.EAST, lblNewLabel_16);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_16, 0, SpringLayout.EAST, lblNewLabel_10);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Co-Pay");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_17, 205, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_17, -100, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_13, 3, SpringLayout.NORTH, lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_17);
		
		textField_16 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_16, -3, SpringLayout.NORTH, lblNewLabel_13);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_16, 6, SpringLayout.EAST, lblNewLabel_13);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_16, -422, SpringLayout.EAST, panel_1);
		panel_1.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblFirstNameOf = new JLabel("Name of Insured");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_16, 14, SpringLayout.SOUTH, lblFirstNameOf);
		lblFirstNameOf.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblFirstNameOf, 0, SpringLayout.SOUTH, txtFirst);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblFirstNameOf, 0, SpringLayout.EAST, lblNewLabel_10);
		panel_1.add(lblFirstNameOf);
		
		JComboBox comboBox_2 = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox_2, 138, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_3, -10, SpringLayout.NORTH, comboBox_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox_2, 162, SpringLayout.WEST, panel_1);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox_2, 120, SpringLayout.WEST, panel_1);
		panel_1.add(comboBox_2);
		
		textField_2 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_2, -3, SpringLayout.NORTH, lblNewLabel_12);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_2, -4, SpringLayout.WEST, textField_13);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField_16);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_14 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_14, 0, SpringLayout.NORTH, comboBox_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_14, 213, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_14, -422, SpringLayout.EAST, panel_1);
		panel_1.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("State");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_20, 3, SpringLayout.NORTH, comboBox_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_20, -51, SpringLayout.WEST, comboBox_2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_20, -20, SpringLayout.NORTH, lblNewLabel_12);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_20, 0, SpringLayout.EAST, lblNewLabel_10);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Zipcode");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_21, 3, SpringLayout.NORTH, comboBox_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_21, -6, SpringLayout.WEST, textField_14);
		panel_1.add(lblNewLabel_21);
		
		textField_15 = new JTextField();
		TextPrompt tpApt =  new TextPrompt("Apt#", textField_15);
		tpApt.setHorizontalAlignment(SwingConstants.LEADING);
		tpApt.setText("Apt#");
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_15, 0, SpringLayout.NORTH, textField_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_15, 11, SpringLayout.EAST, textField_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_15, 0, SpringLayout.EAST, textField_13);
		panel_1.add(textField_15);
		textField_15.setColumns(10);
		

		springLayout.putConstraint(SpringLayout.WEST, emergentQueue, -339, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, emergentQueue, -21, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, emergentQueue, -185, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(emergentQueue);
		
		List nonEmergentQueue = new List();
		springLayout.putConstraint(SpringLayout.WEST, nonEmergentQueue, -164, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, nonEmergentQueue, -21, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, nonEmergentQueue, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(nonEmergentQueue);
		
		JLabel lblNewLabel_18 = new JLabel("Emergency Wait List");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_18, -275, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, emergentQueue, 6, SpringLayout.SOUTH, lblNewLabel_18);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_18, 0, SpringLayout.WEST, emergentQueue);
		frame.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Non-Emergent Wait List");
		springLayout.putConstraint(SpringLayout.NORTH, nonEmergentQueue, 6, SpringLayout.SOUTH, lblNewLabel_19);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_19, 0, SpringLayout.NORTH, lblNewLabel_18);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_19, 0, SpringLayout.WEST, nonEmergentQueue);
		frame.getContentPane().add(lblNewLabel_19);
		
		
	
		
	}

	public JFrame getFrame() {
		return frame;
	}
}
