package finalProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIEmergencyRoom {

	public static void main(String[] args) {
	
		ErGui GUI = new ErGui();
		GUI.getFrame().setVisible(true);

		Patient drew = new Patient();
		drew.setID(1);
		drew.setFirstName("Drew");
		drew.setLastName("Douglass");
		drew.setEmergent(true);
		
		Patient ethan = new Patient();
		ethan.setID(2);
		ethan.setFirstName("Ethan");
		ethan.setLastName("Taylor");
		ethan.setEmergent(true);
		
		Patient alexis = new Patient();
		alexis.setID(3);
		alexis.setFirstName("Alexis");
		alexis.setLastName("Snowden");
		alexis.setEmergent(true);
		
		Patient kali = new Patient();
		kali.setID(4);
		kali.setFirstName("Kali");
		kali.setLastName("Aria");
		kali.setEmergent(true);
		
		Queue<Patient> emergentQueue = new LinkedList<>();
		Queue<Patient> nonEmergentQueue = new LinkedList<>();
		

		emergentQueue.add(drew);
		emergentQueue.add(ethan);
		emergentQueue.add(alexis);
		emergentQueue.add(kali);
		
		GUI.getEmergentQueue().add(drew.firstName + " " + drew.lastName + "  (" + drew.ID + ")");
		GUI.getEmergentQueue().add(ethan.firstName + " " + ethan.lastName + "  (" + ethan.ID + ")");
		GUI.getEmergentQueue().add(alexis.firstName + " " + alexis.lastName + "  (" + alexis.ID + ")");
		GUI.getEmergentQueue().add(kali.firstName + " " + kali.lastName + "  (" + kali.ID + ")");
		
		int size = emergentQueue.size();
		for(int i=0; i<size; i++)
		{
			System.out.println(emergentQueue.poll().firstName);
		}
		
	}
		
	}


