import java.util.*;
public class WeightedGraph {
	HashMap<Node, LinkedHashMap<Node, Integer>> adjList = new LinkedHashMap<Node, LinkedHashMap<Node, Integer>>();

	public void addNode(Node node) {
		adjList.put(node, new LinkedHashMap<Node, Integer>());
	}
	
	public void addWeightedEdge(final Node first, final Node second, final int edgeWeight) {
		if (adjList.containsKey(first) && adjList.containsKey(second)) {			
			adjList.get(first).put(second, edgeWeight);
			first.neighbors.put(second, edgeWeight);
		}
	}
	
	public void removeDirectedEdge(final Node first, final Node second) {
		if (adjList.containsKey(first) && adjList.containsKey(second)) {
			adjList.get(first).remove(second);
			first.neighbors.remove(second);
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
	