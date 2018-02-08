import java.util.ArrayList;
import java.util.LinkedList;

public class VMatrix {
	private ArrayList<LinkedList<VNode>> matrix;
	private int totalNumberOfSkills; // This int determines the size of the array.
									 // It is dependent upon the class you are searching for.

	public VMatrix(int tot) {
		// Instantiates the VMatrix, creates every list in the matix.
		totalNumberOfSkills = tot;
		matrix = new ArrayList<LinkedList<VNode>>(tot);
		for (Integer i = 0; i <= tot; i++) {
			LinkedList<VNode> toAdd = new LinkedList<VNode>();
			toAdd.add(new VNode(i, 0, 0));
			matrix.add(toAdd); //populate the VMatrix with empty nodes.
		}
	}

	public void add(int mainSkill, int skill1, int skill2) {
		// Add a node to the matrix.
		VNode v = new VNode(mainSkill, skill1, skill2);
		LinkedList<VNode> currentList = matrix.get(mainSkill); // Access the list for this node's main skill
		if (currentList.contains(v)) {
			// We don't want need multiple nodes in the list, so if this node is already
			// in the list, do nothing
			return;
		} 
		currentList.add(v);
		// As a result of the if statement, this method is linear with respect to the length
		// of currentList. Shouldn't be too long though.
	}

	public LinkedList<VNode> getNodes(int i) {
		if (i >= matrix.size() || i < 0) {
			return new LinkedList<VNode>();
		}
		return matrix.get(i);
	}

}