import java.util.*;
public class GridNode {
	public int x;
	public int y;
	public String val;
	public ArrayList<GridNode> neighbors;
	public GridNode(final int x, final int y, final String nodeVal) {
		val = nodeVal;
		neighbors = new ArrayList<GridNode>();
		this.x = x;
		this.y = y;
	}
}
