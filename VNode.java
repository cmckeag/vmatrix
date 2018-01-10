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

	@Override
	public boolean equals(Object other) {
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
		int res = skill1;
		if (res < 10) {
			res += skill2 * 100;
		} else {
			res += skill2 * 1000;
		}
		if (res < 1000) {
			res += mainSkill * 10000;
		} else if (res < 10000) {
			res += mainSkill * 100000
		} else {
			res += mainSkill * 1000000;
		}
	}
}