package finalProject;

import java.time.LocalDate;
import java.util.Date;

import java.util.LinkedList;


public class Patient{

	int ID;
	String firstName;
	String lastName;
	LocalDate DOB;
	
	String streetAddress1;
	String streetAddress2;
	String state;
	String zip;
	String homePhone;
	String workPhone;
	String cellPhone;
	String patientEmail;
	String gender;
	String maritalStatus;
	

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

	int triageRating;
	String chiefComplaint;
	String treatmentCategory;
	
	LinkedList<String> medications = new LinkedList<String>();
	LinkedList<String> allergies = new LinkedList<String>();
	LinkedList<String> pastSurgeries = new LinkedList<String>();
	
	boolean emergent;
	

	public int getID() {
		return ID;
	}

	public void setID(int MRN) {
		ID = MRN;
	}

	public String getFirstName() {
		firstName = ErGui.txtFirstName.getText();
		System.out.println(firstName);
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		lastName = ErGui.txtLastName.getText();
		System.out.println(lastName);
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDOB() {
		DOB = (LocalDate) ErGui.txtDOB.getValue();
		System.out.println(DOB);
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getStreetAddress1() {
		streetAddress1 = ErGui.txtStreetAddress1.getText();
		System.out.println(streetAddress1);
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		streetAddress2 = ErGui.txtStreetAddress2.getText();
		System.out.println(streetAddress2);
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getState() {
		state = (String) ErGui.comboBoxState.getSelectedItem();
		System.out.println(state);
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		zip = ErGui.txtZipcode.getText();
		System.out.println(zip);
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getHomePhone() {
		homePhone = ErGui.txtHomePhone.getText();
		System.out.println(homePhone);
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		workPhone = ErGui.txtWorkPhone.getText();
		System.out.println(workPhone);
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	public String getCellPhone() {
		cellPhone = ErGui.txtCellPhone.getText();
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	public String getPatientEmail() {
		patientEmail = ErGui.txtEmail.getText();
		System.out.println(patientEmail);
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getGender() {
		gender = (String) ErGui.comboGender.getSelectedItem();
		System.out.println(gender);
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {

		return maritalStatus;
	}
	
	public String getChiefComplaint()
	{
		chiefComplaint = ErGui.txtAreaChiefComplaint.getText();
		System.out.println(chiefComplaint);
		return chiefComplaint;
	}
	
	public String getTreatmentCategory()
	{
		treatmentCategory = (String) ErGui.comboTreatmentCat.getSelectedItem();
		System.out.println(treatmentCategory);
		return treatmentCategory;
	}
	
	public void setTreatmentCategory(String treatmentCategory)
	{
		this.treatmentCategory = treatmentCategory;
	}
	
	public void setChiefComplaint(String chiefComplaint)
	{
		this.chiefComplaint = chiefComplaint;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getTriageRating() {
		triageRating = Integer.parseInt(ErGui.comboTriage.getSelectedItem().toString());
		return triageRating;
	}

	public void setTriageRating(int triageRating) {
		this.triageRating = triageRating;
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
	public String getCompany() {
		company = ErGui.txtInsuranceName.getText();
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPlanType() {
		return planType;
	}
	
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	public String getPolicyHolderFirstName() {
		policyHolderFirstName = ErGui.txtInsuredFirst.getText();
		return policyHolderFirstName;
	}
	public void setPolicyHolderFirstName(String policyHolderFirstName) {
		this.policyHolderFirstName = policyHolderFirstName;
	}
	public String getPolicyHolderLastName() {
		policyHolderLastName = ErGui.txtInsuredLast.getText();
		return policyHolderLastName;
	}
	public void setPolicyHolderLastName(String policyHolderLastName) {
		this.policyHolderLastName = policyHolderLastName;
	}
	public String getPolicyHolderAddress() {
		policyHolderAddress = ErGui.txtInsuredStreet.getText();
		return policyHolderAddress;
	}
	public void setPolicyHolderAddress(String policyHolderAddress) {
		this.policyHolderAddress = policyHolderAddress;
	}
	public String getPolicyHolderAptNum() {
		policyHolderAptNum = ErGui.txtInsuredApt.getText();
		return policyHolderAptNum;
	}
	public void setPolicyHolderAptNum(String policyHolderAptNum) {
		this.policyHolderAptNum = policyHolderAptNum;
	}
	public String getPolicyHolderDOB() {
		policyHolderDOB = ErGui.txtHolderDOB.getText();
		return policyHolderDOB;
	}
	public void setPolicyHolderDOB(String policyHolderDOB) {
		this.policyHolderDOB = policyHolderDOB;
	}
	public String getPolicyHolderState() {
		policyHolderState = ErGui.txtHolderDOB.getText();
		return policyHolderState;
	}
	public void setPolicyHolderState(String policyHolderState) {
		this.policyHolderState = policyHolderState;
	}
	public String getPolicyHolderZip() {
		policyHolderZip = ErGui.txtInsuredZip.getText();
		return policyHolderZip;
	}
	public void setPolicyHolderZip(String policyHolderZip) {
		this.policyHolderZip = policyHolderZip;
	}
	public String getPolicyNum() {
		policyNum = ErGui.txtPolicyNum.getText();
		return policyNum;
	}
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}
	public String getGroupNum() {
		groupNum = ErGui.txtGroupNum.getText();
		return groupNum;
	}
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}


	
	@Override
	public String toString() {
		return "[" + ID + "] " + firstName + " " + lastName + ", ("
				+ triageRating + ")";
	}

	public void setDOB(int i, int j, int k) {
		
		
	}

	
}

