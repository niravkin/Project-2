import java.util.*;
public class GraphSearch {
	private static void DFSRecHelper(final Node start, final Node end, ArrayList<Node> path, HashSet<Node> visited) {
		if (start.val == end.val) {
			path.add(end);
			visited.add(end);
		} else {
			path.add(start);
			visited.add(start);
			for (Node n: start.neighbors) {
				if (!visited.contains(n))
					DFSRecHelper(n, end, path, visited);
				int lastIndex = path.size()-1;
				Node last = path.get(lastIndex);
				if (last != end && last != start) {
					path.remove(lastIndex);
				}
			}
		}
	}
	
	public static ArrayList<Node> DFSRec(final Node start, final Node end) {
		ArrayList<Node> path = new ArrayList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		DFSRecHelper(start, end, path, visited);
		if ((path.get(path.size()-1)) != end) {
			return null;
		}
		return path;
	}
	
	
	public static ArrayList<Node> DFSIter(final Node start, final Node end) {
		ArrayList<Node> path = new ArrayList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		Stack<Node> stack = new Stack<Node>();
		HashMap<Node, Node> parents = new HashMap<Node, Node>();
		stack.push(start);
		visited.add(start);
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			for (Node n: curr.neighbors) {
				if (!visited.contains(n)) {
					stack.push(n);
					parents.put(n, curr);
					visited.add(n);
					if (n == end) {
						break;
					}
				}
			}
		}
		Node c = end;
		if (parents.get(c) == null) {
			return null;
		} else {
			while (c != start) {
				path.add(c);
				c = parents.get(c);
			}
		}
		path.add(start);
		Collections.reverse(path);
		return path;
	}
	
	private static void BFTRecHelper(final Graph graph, ArrayList<Node> path, Queue<Node> queue, HashSet<Node> visited) {
		if (!queue.isEmpty()) {
			Node curr = queue.poll();
			path.add(curr);
			
			for (Node n: curr.neighbors) {
				if (!visited.contains(n)) {
					queue.add(n);
					visited.add(n);
				}
			}
			BFTRecHelper(graph, path, queue, visited);
		}
	}
	
	public static ArrayList<Node> BFTRec(final Graph graph) {
		Queue<Node> queue = new LinkedList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		ArrayList<Node> path = new ArrayList<Node>();
		for (Node n: graph.getAllNodes()) {
			if (!visited.contains(n)) {
				visited.add(n);
				queue.add(n);
				BFTRecHelper(graph, path, queue, visited);
			}
		}
		return path;
	}
	
	
	
	public static ArrayList<Node> BFTIter(final Graph graph) {
		ArrayList<Node> path = new ArrayList<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		for (Node n : graph.getAllNodes()) {
			if (!visited.contains(n)) {
				queue.add(n);
				visited.add(n);
			}
			while (!queue.isEmpty()) {
				Node curr = queue.remove();
				path.add(curr);
				for (Node node: curr.neighbors) {
					if (!visited.contains(node)) {
						queue.add(node);
						visited.add(node);
					}
				}
				
			}
		}
		return path;
	}	
	
}
