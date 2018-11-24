package finalProject;

public class HospitalNode {
	/* FIELDS */

	int nodeID;
	Patient nodePatient = null;
	String decision = null;
	HospitalNode yesBranch = null;
	HospitalNode noBranch = null;

	/* CONSTRUCTOR */
	
	public HospitalNode(int newNodeID, Patient p)
	{
		nodePatient = p;
		nodeID = newNodeID;
	}

	public HospitalNode(int newNodeID, String condition) {
		nodeID = newNodeID;
		decision = condition;
	}

	public HospitalNode(HospitalNode newNode) {
		nodeID = newNode.nodeID;
		decision = newNode.decision;
		yesBranch = newNode.yesBranch;
		noBranch = newNode.noBranch;
	}

	public void displayNode(int place) {
		System.out.print("{");
		System.out.print(nodeID);
		System.out.print(", ");
		System.out.print(decision);
		System.out.print("}");
	}

	public void displayNode(String name) {
		System.out.print("{");
		System.out.print(nodeID);
		System.out.print(", ");
		System.out.print(decision);
		System.out.print("}");
	}

	public void displayNode(HospitalNode node) {
		System.out.print("{");
		System.out.print(nodeID);
		System.out.print(", ");
		System.out.print(decision);
		System.out.print("}");
		System.out.println(" ");
	}

	public HospitalNode() {
		// TODO Auto-generated constructor stub
	}

	public HospitalNode(int newNodeID) {
		// TODO Auto-generated constructor stub
	}
}
