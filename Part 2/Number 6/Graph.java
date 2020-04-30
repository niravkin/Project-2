import java.util.*;
public class Graph {
	HashSet<GridNode> adjList = new HashSet<GridNode>();

	public void addGridNode(final GridNode gridNode) {
		adjList.add(gridNode);
	}
	
	public void addUndirectedEdge(final GridNode first, final GridNode second) {
		if (adjList.contains(first) && adjList.contains(second)) {
			first.neighbors.add(second);
			second.neighbors.add(first);
		}
	}
	
	public void removeUndirectedEdge(final GridNode first, final GridNode second) {
		if (adjList.contains(first) && adjList.contains(second)) {
			first.neighbors.remove(second);
			second.neighbors.remove(first);
			
		}
	}

	public HashSet<GridNode> getAllNodes() {
		return adjList;
	}
}
	