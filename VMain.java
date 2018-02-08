import java.util.Scanner;
import java.util.LinkedList;

public class VMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("How many skills does your class have?");
		int numOfSkills = 0;
		while (true) {
			try {
				numOfSkills = Integer.parseInt(scan.nextLine());
				if (numOfSkills > 0) {
					break;
				} else {
					System.out.println("You must enter a positive integer");
				}
			} catch (NumberFormatException e) {
				System.out.println("You must enter a valid integer");
			}
		}

		VMatrix matrix = new VMatrix(numOfSkills);

		System.out.println("What nodes do you have?");
		System.out.println("Format: #,#,#");
		System.out.println("The first number is the primary skill in the node.");
		System.out.println("Skill numbers must be at least 1.");
		System.out.println("Enter -1 to stop adding nodes.");

		while (true) {
			String input = scan.nextLine();
			try {
				if (Integer.parseInt(input) == -1) {
					break;
				}
			} catch (NumberFormatException e) {

			}
			int int1 = input.charAt(0) - 48;
			int int2 = input.charAt(2) - 48;
			int int3 = input.charAt(4) - 48;
			if (int1 == int2 || int2 == int3 || int3 == int1) {
				System.out.println("Enter a valid node 1");
			} else if (int1 < 1 || int2 < 1 || int3 < 1) {
				System.out.println("Enter a valid node 2");
			} else if (int1 > numOfSkills || int2 > numOfSkills || int3 > numOfSkills) {
				System.out.println("Enter a valid node 3");
			} else {
				matrix.add(int1, int2, int3);
			}
		}

		System.out.println("What skills do you want in your V Matrix?");
		System.out.println("Enter -1 to stop");
		LinkedList<Integer> desiredSkills = new LinkedList<Integer>();

		while (true) {
			int input = 0;
			try {
				input = Integer.parseInt(scan.nextLine());
				if (input == -1) {
					if (desiredSkills.size() > 0) {
						break;
					} else {
						System.out.println("Pick at least 1 skill");
					}
				} else if (input < 1) {
					System.out.println("You must enter a valid integer");
				} else if (input > numOfSkills) {
					System.out.println("You must enter a valid integer");
				} else if (desiredSkills.contains(input)) {
					System.out.println("You already listed that skill");
				} else {
					desiredSkills.add(input);
				}
			} catch (NumberFormatException e) {
				System.out.println("You must enter a valid integer");
			}
		}

		System.out.println("Do you want each skill to appear 2 times or 3 times?");

		int rep = 0;

		while (true) {
			try {
				rep = Integer.parseInt(scan.nextLine());
				if (rep == 2 || rep == 3) {
					break;
				} else {
					System.out.println("Enter either 2 or 3");
				}
			} catch (NumberFormatException e) {
				System.out.println("You must enter a valid integer");
			}
		}
		System.out.println("Working...");
		VMSolve solver = new VMSolve(matrix, rep, desiredSkills);
		LinkedList<LinkedList<VNode>> result = solver.solve(numOfSkills);

		System.out.println("Found " + result.size() + " optimal combinations.");
		if (result.size() == 0) {return;}
		int index = 1;
		for (LinkedList<VNode> combo : result) {
			System.out.print(index + ": ");
			for (VNode oneNode : combo) {
				if (oneNode.hashCode() != 0) {
					System.out.print("(" + oneNode.mainSkill() + "," + oneNode.skill1() + "," + oneNode.skill2() + ") ");
				}
			}
			System.out.println("");
			index++;
		}

	}


}