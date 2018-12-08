package finalProject;

public class HospitalNode {
	/* FIELDS */

	int nodeID;
	Patient nodePatient = null;
	String decision = null;
	HospitalNode yesBranch = null;
	HospitalNode noBranch = null;

	/* CONSTRUCTOR */
	
	/**
	 * @param newNodeID
	 * @param p
	 * uses newNodeID and patient p to create a new node with that data
	 */
	public HospitalNode(int newNodeID, Patient p)
	{
		nodePatient = p;
		nodeID = newNodeID;
	}

	/**
	 * @param newNodeID
	 * @param condition
	 * uses newNodeID and the string condition to create a node
	 */
	public HospitalNode(int newNodeID, String condition) {
		nodeID = newNodeID;
		decision = condition;
	}

	/**
	 * @param newNode
	 * uses newNode as parameter to set all the properties of the Hospital node
	 */
	public HospitalNode(HospitalNode newNode) {
		nodeID = newNode.nodeID;
		decision = newNode.decision;
		yesBranch = newNode.yesBranch;
		noBranch = newNode.noBranch;
	}

	/**
	 * @param place
	 * prints the node information if passed the parameter of an int that designates the node place
	 */
	public void displayNode(int place) {
		System.out.print("{");
		System.out.print(nodeID);
		System.out.print(", ");
		System.out.print(decision);
		System.out.print("}");
	}

	/**
	 * @param name
	 * prints the node information after being passed the parameter of name
	 */
	public void displayNode(String name) {
		System.out.print("{");
		System.out.print(nodeID);
		System.out.print(", ");
		System.out.print(decision);
		System.out.print("}");
	}

	/**
	 * @param node
	 * prints the node information after being passed the parameter of a formed node
	 */
	public void displayNode(HospitalNode node) {
		System.out.print("{");
		System.out.print(nodeID);
		System.out.print(", ");
		System.out.print(decision);
		System.out.print("}");
		System.out.println(" ");
	}

	/**
	 * blank constructor
	 */
	public HospitalNode() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param newNodeID
	 * creates a node with an integer representing the node id
	 */
	public HospitalNode(int newNodeID) {
		// TODO Auto-generated constructor stub
	}
}
