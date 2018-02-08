import java.util.LinkedList;

public class VMSolve {
	private VMatrix matrix;
	private int numberOfRepetitions;
	private int numberOfNodes;
	private LinkedList<Integer> desiredSkills;
	private LinkedList<LinkedList<VNode>> result;


	public VMSolve(VMatrix matrix, int n, LinkedList<Integer> d) {
		this.matrix = matrix; // The matrix we are trying to solve;
		this.numberOfRepetitions = n; // The number of times we want to see each of the desired
									  // skills in the solution. Either 2 or 3.
		this.desiredSkills = d;		  // A list of the skills we want to appear in the solution\
		// We will assume that the desired skills list is in order, i.e. the first number is smallest
		numberOfNodes = Math.max(n, (int) Math.ceil((double)(d.size()*numberOfRepetitions)/3));
	}

	public LinkedList<LinkedList<VNode>> solve(int numOfClassSkills) {
		// num tells us the number of nodes we should return solution.
		VTree combos = new VTree(numOfClassSkills);
		populate(combos, 1);

		LinkedList<VTree> found = new LinkedList<VTree>();
		combos.getAllAtLevel(desiredSkills.size(), found);
		System.out.println("Generated a total of " + found.size() + " possible solutions");
		this.result = eval(found);

		return this.result;

		// "found" should now contain a list of VTree-nodes that lie at the bottom of the tree
		// Now we just need to check the status of each one and see if it satisfies the conditions


	}

	public void populate(VTree tree, int index) {
		if (index > desiredSkills.size()) {
			return;
		}
		LinkedList<VNode> current = matrix.getNodes(desiredSkills.get(index - 1));
		if (tree.numOfRealNodes() < numberOfNodes) {
			for (VNode v : current) {
				if (v.contains(desiredSkills) || v.hashCode() == 0) {
					tree.addChild(v);
				}
			}
		} else {
			tree.addChild(new VNode(desiredSkills.get(index - 1), 0, 0));
		}
		
		LinkedList<VTree> treeChildren = tree.getChildren();
		for (VTree t : treeChildren) {
			populate(t, index + 1);
		}
	}

	public LinkedList<LinkedList<VNode>> eval(LinkedList<VTree> solutions) {
		LinkedList<LinkedList<VNode>> res = new LinkedList<LinkedList<VNode>>();
		for (VTree t : solutions) {
			boolean valid = true;
			for (Integer skill : desiredSkills) {
				if (t.getStatus()[skill] < numberOfRepetitions && valid) {
					valid = false;
					break;
				}
			}
			if (valid) {
				LinkedList<VNode> combo = new LinkedList<VNode>();
				t.getAllParents(combo);
				res.add(combo);
			}
		}
		return res;
	}
}