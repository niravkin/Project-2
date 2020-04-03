import java.util.*;
public class Graph {
	HashMap<Node, ArrayList<Node>> adjList = new LinkedHashMap<Node, ArrayList<Node>>();

	public void addNode(final String nodeVal) {
		adjList.put(new Node(nodeVal), new ArrayList<Node>());
	}
	
	public void addUndirectedEdge(final Node first, final Node second) {
		if (adjList.containsKey(first) && adjList.containsKey(second)) {
			adjList.get(first).add(second);
			first.neighbors.add(second);
			adjList.get(second).add(first);
			second.neighbors.add(first);
		}
	}
	
	public void removeUndirectedEdge(final Node first, final Node second) {
		if (adjList.containsKey(first) && adjList.containsKey(second)) {
			adjList.get(first).remove(second);
			int firstIndex = first.neighbors.indexOf(second);
			first.neighbors.remove(firstIndex);
			adjList.get(second).remove(first);
			int secondIndex = second.neighbors.indexOf(first);
			second.neighbors.remove(secondIndex);
			
		}
	}

	public HashSet<Node> getAllNodes() {
		HashSet<Node> ret = new LinkedHashSet<Node>();
		for (Node n : adjList.keySet()) {
			ret.add(n);
		}
		return ret;
	}
}
	