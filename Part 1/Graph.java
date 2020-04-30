import java.util.*;
public class Graph {
	HashSet<Node> adjList =  new LinkedHashSet<Node>();

	public void addNode(Node node) {
		adjList.add(node);
	}
	
	public void addUndirectedEdge(final Node first, final Node second) {
		if (adjList.contains(first) && adjList.contains(second)) {
			first.neighbors.add(second);
			second.neighbors.add(first);
		}
	}
	
	public void removeUndirectedEdge(final Node first, final Node second) {
		if (adjList.contains(first) && adjList.contains(second)) {
			first.neighbors.remove(second);
			second.neighbors.remove(first);
		}
	}

	public HashSet<Node> getAllNodes() {
		return adjList;
	}
}
	