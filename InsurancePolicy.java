package finalProject;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class InsurancePolicy extends Patient{

	
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
}


