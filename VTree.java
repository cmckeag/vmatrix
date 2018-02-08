import java.util.LinkedList;

public class VTree {
	private VNode node;
	private int[] status;
	private int level;
	private int numOfRealNodes;
	private VTree parent;
	private LinkedList<VTree> children;

	public VTree(int numOfClassSkills) {
		status = new int[numOfClassSkills+1];
		parent = null;
		level = 0;
		numOfRealNodes = 0;
		node = new VNode(); // initialize the default empty VNode as the root
		children = new LinkedList<VTree>();
	}

	public void addChild(VNode sub) {
		VTree child = new VTree(status.length);
		child.node = sub;
		child.parent = this;
		System.arraycopy(this.status, 0, child.status, 0, status.length);
		child.level = this.level + 1;
		child.numOfRealNodes = this.numOfRealNodes;
		if (sub.hashCode() != 0) {
			child.status[sub.mainSkill()]++;
			child.status[sub.skill1()]++;
			child.status[sub.skill2()]++;
			child.numOfRealNodes++;
		}
		this.children.add(child);
	}

	public VNode node() {
		return this.node;
	}

	public LinkedList<VTree> getChildren() {
		return this.children;
	}

	public int[] getStatus() {
		return this.status;
	}

	public int numOfRealNodes() {
		return this.numOfRealNodes;
	}

	public void getAllAtLevel(int lvl, LinkedList<VTree> carry) {
		if (this.level == lvl) {
			carry.add(this);
			return;
		}
		for (VTree t : children) {
			t.getAllAtLevel(lvl, carry);
		}
	}

	public void getAllParents(LinkedList<VNode> nodes) {
		if (level == 0) {
			return;
		}
		nodes.add(this.node());
		this.parent.getAllParents(nodes);
	}



}