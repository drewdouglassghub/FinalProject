package finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Drew Douglass, amdouglass@dmacc.edu, 12/4/18
 * Hospital tree is an adt that allows a patient node to be sent through the decision tree until it lands in the appropriate unit of the hospital
 *
 */
public class HospitalTree {
	/* CREATE ROOT NODE */
		HospitalNode root = new HospitalNode();

		public void createRoot(int newNodeID) {
			root.nodeID = newNodeID;
			System.out.println("Created root node " + newNodeID);
			
		}
		
		public void createRoot(HospitalNode newNode) {
			root.nodeID = newNode.nodeID;
			root.decision = newNode.decision;
			System.out.println("Created root node " + newNode.nodeID);
			
		}

		/* ADD YES NODE */

		/**
		 * @param existingNodeID
		 * ID for the node
		 * @param newNodeID
		 * new node id
		 * @param condition
		 *            this method uses the parameters of existing node, new node and
		 *            condition to add a new node to a yes slot in a node in the
		 *            tree
		 */
		public void addYesNode(int existingNodeID, HospitalNode node) {
			// If no root node do nothing

			if (root == null) {
				System.out.println("ERROR: No root node!");
				return;
			}

			// Search tree

			if (searchAndAddYes(root, existingNodeID, node)) {
				System.out.println("Added node " + node.nodeID + " onto \"yes\" branch of node " + existingNodeID);
			} else
				System.out.println("Node " + existingNodeID + " not found");
		}

		/**
		 * @param currentNode
		 * @param existingNodeID
		 * @param node
		 * @param newQuestAns
		 * @return this method uses current and existing nodeId parameters to add
		 *         new node to a yes slot in a node in the tree that already has
		 *         some nodes in it
		 */
		private boolean searchAndAddYes(HospitalNode currentNode, int existingNodeID, HospitalNode node) {
			if (currentNode.nodeID == existingNodeID) {		
				if (currentNode.yesBranch == null)						// Found node
					currentNode.yesBranch = new HospitalNode(node);
				else {
					System.out.println("WARNING: Overwriting previous node " + "(id = " + currentNode.yesBranch.nodeID
							+ ") linked to yes branch of node " + existingNodeID);
					currentNode.yesBranch = new HospitalNode(node);
				}
				return (true);
			} else {
				// Try yes branch if it exists
				if (currentNode.yesBranch != null) {
					if (searchAndAddYes(currentNode.yesBranch, existingNodeID, node)) {
						return (true);
					} else {
						// Try no branch if it exists
						if (currentNode.noBranch != null) {
							return (searchAndAddYes(currentNode.noBranch, existingNodeID, node));
						} else
							return (false); // Not found here
					}
				}
				return (false); 			// Not found here
			}
		}

		/**
		 * @param existingNodeID
		 * @param newNodeID
		 * @param condition
		 *            this method uses the parameters of existing node, new node and
		 *            condition to add a new node to a no slot in a node in the tree
		 */
		public void addNoNode(int existingNodeID, HospitalNode node) {	
			if (root == null) {												// If no root node make current root
				System.out.println("Creating root node: ");
				createRoot(node);
				return;
			}
			// Search tree
			if (searchAndAddNo(root, existingNodeID, node)) {
				System.out.println("Added node " + node.nodeID + " onto \"no\" branch of node " + existingNodeID);
			} else
				System.out.println("Node " + existingNodeID + " not found");
		}

		/* SEARCH TREE AND ADD NO NODE */

		/**
		 * @param currentNode
		 * @param existingNodeID
		 * @param node
		 * @param condition
		 * @return this method uses current and existing nodeId parameters to add
		 *         new node to a no slot in a node in the tree that already has some
		 *         nodes in it
		 */
		private boolean searchAndAddNo(HospitalNode currentNode, int existingNodeID, HospitalNode node) {
			if (currentNode.nodeID == existingNodeID) {
				// Found node
				if (currentNode.noBranch == null) {
					currentNode.noBranch = new HospitalNode(node);
				} else {
					currentNode = currentNode.noBranch;
				}
				return (true);
			} else {
				// Try yes branch if it exists
				if (currentNode.yesBranch != null) {
					if (searchAndAddNo(currentNode.yesBranch, existingNodeID, node)) {
						return (true);
					} else {
						// Try no branch if it exists
						if (currentNode.noBranch != null) {
							return (searchAndAddNo(currentNode.noBranch, existingNodeID, node));
						} else
							return (false); // Not found here
					}
				} else
					return (false); // Not found here
			}
		}

		/**
		 * @param currentNode
		 * @throws IOException
		 *             this method uses currentNode to find out what conditions the
		 *             user has for the decision tree
		 */
		void dcopatient(HospitalNode currentNode) throws IOException {
			BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(currentNode.decision + " (enter \"Yes\" or \"No\")");
			String answer = keyboardInput.readLine();

			if (answer.equals("Yes") && currentNode.nodeID < 2) {
				currentNode = this.root.yesBranch;
				dcopatient(currentNode);
			} else if (answer.equals("Yes") && currentNode.nodeID > 1) {
				currentNode = currentNode.yesBranch;
				if (currentNode.noBranch != null && currentNode.yesBranch != null) {
					dcopatient(currentNode);
				} else {
					System.out.println(currentNode.decision);
					return;
				}
			} else if (answer.equals("No") && currentNode.nodeID < 2) {
				currentNode = this.root.noBranch;
				dcopatient(currentNode);
			} else if (answer.equals("No") && currentNode.nodeID > 1) {
				currentNode = currentNode.noBranch;
				if (currentNode.noBranch != null && currentNode.yesBranch != null) {
					dcopatient(currentNode);
				} else {
					System.out.println(currentNode.decision);
					return;
				}
			}
		}

		/**
		 * @param node
		 *            this method uses the parameter node to create a method to
		 *            print out a nodes contents.
		 */
		public void displayNode(HospitalNode node) {
			if (node != null) {
				System.out.print("{");
				System.out.print(node.nodeID);
				System.out.print(", ");
				System.out.print(node.decision);
				System.out.print("}");
			} else {
				System.out.println();
				System.out.print("Sit at home in the dark");
			}
		}
	}
	

