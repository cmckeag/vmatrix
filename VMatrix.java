import java.util.*;

public class VMatrix {
	private LinkedList<VNode>[] matrix;
	private int totalNumberOfSkills; // This int determines the size of the array.
									 // It is dependent upon the class you are searching for.

	public VMatrix(int tot) {
		// Instantiates the VMatrix, creates every list in the matix.
		totalNumberOfSkills = tot;
		matrix = new LinkedList<VNode>[tot];
		for (int i = 0; i < tot, i++) {
			matrix[i] = new LinkedList<VNode>();
		}
	}

	public void add(int mainSkill, int skill1, int skill2) {
		// Add a node to the matrix.
		VNode v = new VNode(mainSkill, skill1, skill2);
		LinkedList<VNode> currentList = matrix[mainSkill]; // Access the list for this node's main skill
		if (currentList.contains(v)) {
			// We don't want need multiple nodes in the list, so if this node is already
			// in the list, do nothing
			return;
		} 
		currentList.add(v);
		// As a result of the if statement, this method is linear with respect to the length
		// of currentList. Shouldn't be too long though.
	}

}