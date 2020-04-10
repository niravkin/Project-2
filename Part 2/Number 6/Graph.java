import java.util.*;
public class Graph {
	HashMap<GridNode, ArrayList<GridNode>> adjList = new LinkedHashMap<GridNode, ArrayList<GridNode>>();

	public void addGridNode(final GridNode gridNode) {
		adjList.put(gridNode, new ArrayList<GridNode>());
	}
	
	public void addUndirectedEdge(final GridNode first, final GridNode second) {
		if (adjList.containsKey(first) && adjList.containsKey(second)) {
			adjList.get(first).add(second);
			first.neighbors.add(second);
			adjList.get(second).add(first);
			second.neighbors.add(first);
		}
	}
	
	public void removeUndirectedEdge(final GridNode first, final GridNode second) {
		if (adjList.containsKey(first) && adjList.containsKey(second)) {
			adjList.get(first).remove(second);
			int firstIndex = first.neighbors.indexOf(second);
			first.neighbors.remove(firstIndex);
			adjList.get(second).remove(first);
			int secondIndex = second.neighbors.indexOf(first);
			second.neighbors.remove(secondIndex);
			
		}
	}

	public HashSet<GridNode> getAllNodes() {
		HashSet<GridNode> ret = new LinkedHashSet<GridNode>();
		for (GridNode n : adjList.keySet()) {
			ret.add(n);
		}
		return ret;
	}
}
	