import java.util.*;
public class TopSort {
	
	public static ArrayList<Node> Kahns(final DirectedGraph graph) {
		ArrayList<Node> topSort = new ArrayList<Node>();
		HashMap<Node, Integer> indegrees = new HashMap<Node, Integer>();
		for (Node n : graph.getAllNodes()) {
			for (Node neighbor : n.neighbors) {
				if (indegrees.containsKey(neighbor)) {
					indegrees.put(neighbor, indegrees.get(neighbor) + 1); 
				} else {
					indegrees.put(neighbor, 1); 
				}
			}
		}
		
		Queue<Node> indegreeOfZero = new LinkedList<Node>();
		for (Node n : graph.getAllNodes()) {
			if (!indegrees.containsKey(n)) {
				indegreeOfZero.add(n);
			}
		}
		
		while (!indegreeOfZero.isEmpty()) {
			Node curr = indegreeOfZero.poll();
			topSort.add(curr);
			for (Node neighbor : curr.neighbors) {
				indegrees.put(neighbor, indegrees.get(neighbor)-1);
			}
			for (Object n : indegrees.keySet().toArray()) {
				if ( indegrees.get((Node)n) == 0) {
					indegreeOfZero.add((Node)n);
					indegrees.remove(n);
				}
			}	
		}
		
		
		return topSort;
	}
	
	public static ArrayList<Node> mDFS(final DirectedGraph graph) {
		Stack<Node> stack = new Stack<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		for (Node n: graph.getAllNodes()) {
			if (!visited.contains(n)) {
				mDFS(n, stack, visited);
			}
		}
		
		ArrayList<Node> topSort = new ArrayList<Node>();
		while(!stack.isEmpty()) {
			topSort.add(stack.pop());
		}
		
		return topSort;
	}
	
	private static void mDFS(final Node node, final Stack<Node> stack, final HashSet<Node> visited) {
		visited.add(node);
		for (Node n : node.neighbors) {
			if (!visited.contains(n)) {
				mDFS(n, stack, visited);
			}
		}
		stack.push(node);
	}
	
}