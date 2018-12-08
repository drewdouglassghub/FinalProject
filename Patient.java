package finalProject;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import java.util.LinkedList;


/**
 * @author Drew Douglass, amdouglass@dmacc.edu, 12/4/18 - this class defines the attributes for patient
 *
 */
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

	int triageRating;				//triage rating variable
	String chiefComplaint;
	String treatmentCategory;
	
	boolean emergent;
	

	/**
	 * @return
	 * returns the patient id number
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param MRN
	 * returns the record number of the patient
	 */
	public void setID(int MRN) {
		ID = MRN;
	}

	/**
	 * @return
	 * returns first name after getting it from txtFirstName
	 */
	public String getFirstName() {
		firstName = ErGui.txtFirstName.getText();
		System.out.println(firstName);
		return firstName;
	}

	/**
	 * @param firstName
	 * uses the parameter firstName to set the firstname of the patient 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 * returns the patient last name
	 */
	public String getLastName() {
		lastName = ErGui.txtLastName.getText();
		System.out.println(lastName);
		return lastName;
	}

	/**
	 * @param lastName
	 * uses the parameter lastName to set the last name of the patient 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 * returns the date of birth
	 */
	public LocalDate getDOB() {
		String str = ErGui.txtDOB.getText();			
		if(str.equals(""))
		{
		DOB = LocalDate.of(1999, Month.MARCH, 03);
		}
		else
		{
			DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			DOB = LocalDate.parse(str, dFormat);
			System.out.println(DOB);
		}
		return DOB;
	}

	/**
	 * @param dOB
	 * uses the parameter dOB to set the DOB of the patient 
	 */
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	/**
	 * @return
	 * returns the patient street address
	 */
	public String getStreetAddress1() {
		streetAddress1 = ErGui.txtStreetAddress1.getText();
		System.out.println(streetAddress1);
		return streetAddress1;
	}

	/**
	 * @param streetAddress1
	 * uses the parameter streetAddress1 to set the streetAddress1 of the patient 
	 */
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	/**
	 * @return
	 * returns the patient street address 2 from the txtStreetAddress2 textbox
	 */
	public String getStreetAddress2() {
		streetAddress2 = ErGui.txtStreetAddress2.getText();
		System.out.println(streetAddress2);
		return streetAddress2;
	}

	/**
	 * @param streetAddress2
	 * uses the parameter streetAddress2 to set the streetAddress2 of the patient 
	 */
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	/**
	 * @return
	 * returns the patient state
	 */
	public String getState() {
		state = (String) ErGui.comboBoxState.getSelectedItem();
		System.out.println(state);
		return state;
	}

	/**
	 * @param state
	 * uses the parameter state to set the state of the patient 
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return
	 * returns the zip of the patient from txtZipcode
	 */
	public String getZip() {
		zip = ErGui.txtZipcode.getText();
		System.out.println(zip);
		return zip;
	}

	/**
	 * @param zip
	 * uses the parameter zip to set the zip of the patient 
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return
	 * returns the patient home phone
	 */
	public String getHomePhone() {
		homePhone = ErGui.txtHomePhone.getText();
		System.out.println(homePhone);
		return homePhone;
	}

	/**
	 * @param homePhone
	 * uses the parameter homePhone to set the homePhone of the patient 
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return
	 * returns the patient work phone
	 */
	public String getWorkPhone() {
		workPhone = ErGui.txtWorkPhone.getText();
		System.out.println(workPhone);
		return workPhone;
	}

	/**
	 * @param workPhone
	 * uses the parameter workPhone to set the workPhone of the patient 
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	/**
	 * @return
	 * returns the patient cell phone
	 */
	public String getCellPhone() {
		cellPhone = ErGui.txtCellPhone.getText();
		return cellPhone;
	}

	/**
	 * @param cellPhone
	 * uses the parameter cellPhone to set the cellPhone of the patient 
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	/**
	 * @return
	 * returns the patient email
	 */
	public String getPatientEmail() {
		patientEmail = ErGui.txtEmail.getText();
		System.out.println(patientEmail);
		return patientEmail;
	}

	/**
	 * @param patientEmail
	 * uses the parameter patientEmail to set the patientEmail of the patient
	 */
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	/**
	 * @return
	 * returns patient gender
	 */
	public String getGender() {
		gender = (String) ErGui.comboGender.getSelectedItem();
		System.out.println(gender);
		return gender;
	}

	/**
	 * @param gender
	 * uses the parameter gender to set the gender of the patient
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return
	 * returns the patient marital status
	 */
	public String getMaritalStatus() {

		return maritalStatus;
	}
	
	/**
	 * @return
	 * returns the patient chief complaint
	 */
	public String getChiefComplaint()
	{
		chiefComplaint = ErGui.txtAreaChiefComplaint.getText();
		System.out.println(chiefComplaint);
		return chiefComplaint;
	}
	
	/**
	 * @return
	 * returns the patient treatment category
	 */
	public String getTreatmentCategory()
	{
		treatmentCategory = (String) ErGui.comboTreatmentCat.getSelectedItem();
		System.out.println(treatmentCategory);
		return treatmentCategory;
	}
	
	/**
	 * @param treatmentCategory
	 */
	public void setTreatmentCategory(String treatmentCategory)
	{
		this.treatmentCategory = treatmentCategory;
	}
	
	/**
	 * @param chiefComplaint
	 * uses the chiefComplaint parameter to set the chiefComplaint of the patient
	 */
	public void setChiefComplaint(String chiefComplaint)
	{
		this.chiefComplaint = chiefComplaint;
	}

	/**
	 * @param maritalStatus
	 * uses the maritalStatus parameter to set the maritalStatus of the patient
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return
	 * returns the patient triage rating
	 */
	public int getTriageRating() {
		triageRating = Integer.parseInt(ErGui.comboTriage.getSelectedItem().toString());
		return triageRating;
	}

	/**
	 * @param triageRating
	 * uses the triageRating parameter to set the triageRating of the patient
	 */
	public void setTriageRating(int triageRating) {
		this.triageRating = triageRating;
	}

	/**
	 * @return
	 * returns the patient emergent boolean
	 */
	public boolean isEmergent() {
		return emergent;
	}

	/**
	 * @param emergent
	 * uses the emergent parameter to set the emergent status of the patient
	 */
	public void setEmergent(boolean emergent) {
		this.emergent = emergent;
	}
	/**
	 * @return
	 * returns the patient company for insurance
	 */
	public String getCompany() {
		company = ErGui.txtInsuranceName.getText();
		return company;
	}
	/**
	 * @param company
	 * uses the company parameter to set the company of the patient
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return
	 * returns the patient insurance plan type
	 */
	public String getPlanType() {
		return planType;
	}
	
	/**
	 * @param planType
	 * uses the planType parameter to set the planType of the patient
	 */
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	/**
	 * @return
	 * returns insurance policy holder first name
	 */
	public String getPolicyHolderFirstName() {
		policyHolderFirstName = ErGui.txtInsuredFirst.getText();
		return policyHolderFirstName;
	}
	/**
	 * @param policyHolderFirstName
	 * uses the policyHolderFirstName parameter to set the policyHolderFirstName of the patient
	 */
	public void setPolicyHolderFirstName(String policyHolderFirstName) {
		this.policyHolderFirstName = policyHolderFirstName;
	}
	/**
	 * @return
	 * returns the patient policy holder last name
	 */
	public String getPolicyHolderLastName() {
		policyHolderLastName = ErGui.txtInsuredLast.getText();
		return policyHolderLastName;
	}
	/**
	 * @param policyHolderLastName
	 * uses the policyHolderLastName parameter to set the policyHolderLastName of the patient
	 */
	public void setPolicyHolderLastName(String policyHolderLastName) {
		this.policyHolderLastName = policyHolderLastName;
	}
	/**
	 * @return
	 * returns the patient policy holder address
	 */
	public String getPolicyHolderAddress() {
		policyHolderAddress = ErGui.txtInsuredStreet.getText();
		return policyHolderAddress;
	}
	/**
	 * @param policyHolderAddress
	 * uses the policyHolderAddress parameter to set the policyHolderAddress of the patient
	 */
	public void setPolicyHolderAddress(String policyHolderAddress) {
		this.policyHolderAddress = policyHolderAddress;
	}
	/**
	 * @return
	 * returns the patient policy holder apt number
	 */
	public String getPolicyHolderAptNum() {
		policyHolderAptNum = ErGui.txtInsuredApt.getText();
		return policyHolderAptNum;
	}
	/**
	 * @param policyHolderAptNum
	 * uses the policyHolderAptNum parameter to set the policyHolderAptNum of the patient
	 */
	public void setPolicyHolderAptNum(String policyHolderAptNum) {
		this.policyHolderAptNum = policyHolderAptNum;
	}
	/**
	 * @return
	 * returns the patient policy holder Date of birth
	 */
	public String getPolicyHolderDOB() {
		policyHolderDOB = ErGui.txtHolderDOB.getText();
		return policyHolderDOB;
	}
	/**
	 * @param policyHolderDOB
	 * uses the policyHolderDOB parameter to set the policyHolderDOB of the patient
	 */
	public void setPolicyHolderDOB(String policyHolderDOB) {
		this.policyHolderDOB = policyHolderDOB;
	}
	/**
	 * @return
	 * returns the patient policy holder state
	 */
	public String getPolicyHolderState() {
		policyHolderState = ErGui.txtHolderDOB.getText();
		return policyHolderState;
	}
	/**
	 * @param policyHolderState
	 * uses the policyHolderState parameter to set the policyHolderState of the patient
	 */
	public void setPolicyHolderState(String policyHolderState) {
		this.policyHolderState = policyHolderState;
	}
	/**
	 * @return
	 * returns the patient policy holder zip
	 */
	public String getPolicyHolderZip() {
		policyHolderZip = ErGui.txtInsuredZip.getText();
		return policyHolderZip;
	}
	/**
	 * @param policyHolderZip
	 * uses the policyHolderZip parameter to set the policyHolderZip of the patient
	 */
	public void setPolicyHolderZip(String policyHolderZip) {
		this.policyHolderZip = policyHolderZip;
	}
	/**
	 * @return
	 * returns the patient policy number
	 */
	public String getPolicyNum() {
		policyNum = ErGui.txtPolicyNum.getText();
		return policyNum;
	}
	/**
	 * @param policyNum
	 *  uses the policyNum parameter to set the policyNum of the patient
	 */
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}
	/**
	 * @return
	 * returns the patient insurance group number
	 */
	public String getGroupNum() {
		groupNum = ErGui.txtGroupNum.getText();
		return groupNum;
	}
	/**
	 * @param groupNum
	 * uses the groupNum parameter to set the groupNum of the patient
	 */
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}


	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + ID + "] " + firstName + " " + lastName + ", ("
				+ triageRating + ")";
	}

	/**
	 * @param i
	 * @param j
	 * @param k
	 */
	public void setDOB(int i, int j, int k) {
		
		
	}

	
}

