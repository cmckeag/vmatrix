import java.util.LinkedList;

public class VNode {
	private final int mainSkill;
	private final int skill1;
	private final int skill2;

	// A node consists of 3 items: a main skill, and two sub-skills.

	public VNode(int main, int one, int two) {
		this.mainSkill = main;
		// We're going to store the skills so that skill1 has a smaller skill id than skill2
		// It should never be that skill1 = skill2, since that configuration doesn't exist.
		if (two > one) {
			this.skill1 = one;
			this.skill2 = two;
		} else {
			this.skill1 = two;
			this.skill2 = one;
		}
	}

	public VNode() {
		this(0, 0, 0);
	}

	public int mainSkill() {
		return this.mainSkill;
	}

	public int skill1() {
		return this.skill1;
	}

	public int skill2() {
		return this.skill2;
	}

	public boolean contains(LinkedList<Integer> skills) {
		// skills is a list of integers that represent skills
		// the idea is that if this node contains any of the skills in the list, return true
		for (Integer k : skills) {
			if (skill1 == k || skill2 == k) {
				return true;
			}
		}
		// We would only ever need to check the sub-skills, since the main skill should always
		// Be obvious based on the way we are storing VNodes in the VMatrix.
		return false;
	}

	@Override
	public VNode clone() {
		return new VNode(this.mainSkill, this.skill1, this.skill2);
	}

	@Override
	public boolean equals(Object other) {
		if (this.getClass() != other.getClass()) {
			return false;
		}
		// Two nodes can be equal as long as they contain the same 3 skills, and
		// have the same main skill. Meaning that if one node has subskills (1,3) and
		// another node has subskills (3,1), but they both have main skill 2, they are equal.
		VNode oth = (VNode) other;
		if (this.mainSkill != oth.mainSkill) {
			return false;
		}
		if (this.skill1 == oth.skill1 && this.skill2 == oth.skill2) {
			return true;
		}
		// We don't need to check the other case, in which this.skill1 = oth.skill2, because
		// we have set it upon construction so that skill1 is always the smaller skill in the node.
		
		return false;

	}

	@Override
	public int hashCode() {
		// returns an int in the format: mainSkill 0 skill2 0 skill1
		if (skill1 == 0 && skill2 == 0) {
			// I want to have the concept of empty nodes for my implementation of VMatrix.
			return 0;
		}
		int res = skill1;
		if (res < 10) {
			res += skill2 * 100;
		} else {
			res += skill2 * 1000;
		}
		if (res < 1000) {
			res += mainSkill * 10000;
		} else if (res < 10000) {
			res += mainSkill * 100000;
		} else {
			res += mainSkill * 1000000;
		}
		return res;
	}
}