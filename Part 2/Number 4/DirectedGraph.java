import java.util.*;
public class DirectedGraph {
	HashMap<Node, ArrayList<Node>> adjList = new LinkedHashMap<Node, ArrayList<Node>>();

	public void addNode(Node node) {
		adjList.put(node, new ArrayList<Node>());
	}
	
	public void addDirectedEdge(final Node first, final Node second) {
		if (adjList.containsKey(first) && adjList.containsKey(second)) {
			adjList.get(first).add(second);
			first.neighbors.add(second);
		}
	}
	
	public void removeDirectedEdge(final Node first, final Node second) {
		if (adjList.containsKey(first) && adjList.containsKey(second)) {
			adjList.get(first).remove(second);
			int firstIndex = first.neighbors.indexOf(second);
			first.neighbors.remove(firstIndex);
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
	