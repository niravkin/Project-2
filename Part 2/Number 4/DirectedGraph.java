import java.util.*;
public class DirectedGraph {
	HashSet<Node> adjList = new HashSet<Node>();

	public void addNode(Node node) {
		adjList.add(node);
	}
	
	public void addDirectedEdge(final Node first, final Node second) {
		if (adjList.contains(first) && adjList.contains(second)) {
			first.neighbors.add(second);
		}
	}
	
	public void removeDirectedEdge(final Node first, final Node second) {
		if (adjList.contains(first)) {
			first.neighbors.remove(second);
		}
	}

	public HashSet<Node> getAllNodes() {
		return adjList;
	}
}
	