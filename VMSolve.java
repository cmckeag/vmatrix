import java.util.*;

public class VMSolve {
	private VMatrix matrix;
	private int numberOfRepetitions;
	private LinkedList<Integer> desiredSkills;

	public VMSolve(VMatrix matrix, int n, LinkedList<Integer> d) {
		this.matrix = matrix; // The matrix we are trying to solve;
		this.numberOfRepetitions = n; // The number of times we want to see each of the desired
									  // skills in the solution. Either 2 or 3.
		this.desiredSkills = d;		  // A list of the skills we want to appear in the solution
	}

	public LinkedList<VNode> solve() {
		int num = numberOfRepetitions;
		if ( (double)(desiredSkills.size()*numberOfRepetitions)/3 > num) {
			num = (int) Math.ceil((double)(desiredSkills.size()*numberOfRepetitions)/3);
		}
		// num tells us the number of nodes we should return in the LinkedList<VNode> solution.
		LinkedList<VNode> solution = new LinkedList<VNode>();

		// Now we need some type of algorithm to populate this list with "num" nodes such that each
		// of the "desiredSkills" appears exactly "numberOfRepetitions" times.
	}
}