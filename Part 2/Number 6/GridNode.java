import java.util.*;
public class GridNode {
	public int x;
	public int y;
	public String val;
	public ArrayList<GridNode> neighbors;
	public GridNode(final int xCor, final int yCor, final String nodeVal) {
		val = nodeVal;
		neighbors = new ArrayList<GridNode>();
		x = xCor;
		y = yCor;
	}
}
