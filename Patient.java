package finalProject;

import java.util.Date;
import java.util.LinkedList;

public class Patient {

	int ID;
	String firstName;
	String lastName;
	Date DOB;
	
	String streetAddress;
	String state;
	int phone;
	int traumaRating;
	
	LinkedList<String> medications = new LinkedList<String>();
	LinkedList<String> allergies = new LinkedList<String>();
	LinkedList<String> pastSurgeries = new LinkedList<String>();
	
	boolean emergent;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		firstName = ErGui.txtFirstName.getText();
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		lastName = ErGui.txtLastName.getText();
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public LinkedList<String> getMedications() {
		return medications;
	}

	public void setMedications(LinkedList<String> medications) {
		this.medications = medications;
	}

	public LinkedList<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(LinkedList<String> allergies) {
		this.allergies = allergies;
	}

	public LinkedList<String> getPastSurgeries() {
		return pastSurgeries;
	}

	public void setPastSurgeries(LinkedList<String> pastSurgeries) {
		this.pastSurgeries = pastSurgeries;
	}

	public boolean isEmergent() {
		return emergent;
	}

	public void setEmergent(boolean emergent) {
		this.emergent = emergent;
	}

}
