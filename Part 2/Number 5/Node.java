import java.util.*;
public class Node {
	public String val;
	public LinkedHashMap<Node, Integer> neighbors;
	public Node(final String nodeVal) {
		val = nodeVal;
		neighbors = new LinkedHashMap<Node, Integer>();
	}
}
