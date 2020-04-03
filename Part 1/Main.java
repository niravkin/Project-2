import java.util.*;
public class Main {
	public static Graph createRandomUnweightedGraphIter(int n) {
		Graph g = new Graph();
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			g.addNode(Integer.toString(i));
		}
		Object[] nodes = g.getAllNodes().toArray();
		for (int i = 0; i < nodes.length; i++) {
			for (int j = i + 1; j < nodes.length; j++) {
				if (rand.nextBoolean()) {
					g.addUndirectedEdge((Node)nodes[i], (Node)nodes[j]);
				}
			}
		}
		return g;
	}
	
	public static Graph createLinkedList(int n) {
		Graph g = new Graph();
		for (int i = 0; i < n; i++) {
			g.addNode(Integer.toString(i));
		}
		Object[] nodes = g.getAllNodes().toArray();
		for (int i = 0; i < nodes.length-1; i++) {
			g.addUndirectedEdge((Node)nodes[i], (Node)nodes[i+1]);
		}
		return g;
	}
	
	public static ArrayList<Node> BFTRecLinkedList(final Graph graph) {
		Graph g = createLinkedList(10000);
		ArrayList<Node> path = GraphSearch.BFTRec(graph);
		return path;
	}
	
	public static ArrayList<Node> BFTIterLinkedList(final Graph graph) {
		ArrayList<Node> path = GraphSearch.BFTIter(graph);
		return path;
	}
	
	public static void main(String[] args) {
		Graph g = createRandomUnweightedGraphIter(10);
		
		Node start, end;
		Object[] nodes = g.getAllNodes().toArray();
		start = (Node)nodes[0];
		end = (Node)nodes[nodes.length-1];
		
		System.out.println("Graph:");
		for (Node n: g.getAllNodes()) {
			System.out.print(n.val + ": ");
			for (Node node: n.neighbors) {
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	
		ArrayList<Node> path = GraphSearch.DFSRec(start, end);
		ArrayList<Node> path2 = GraphSearch.DFSIter(start, end);
		ArrayList<Node> path3 = GraphSearch.BFTIter(g);
		ArrayList<Node> path4 = GraphSearch.BFTRec(g);
		System.out.println("Recursive DFS from: " + start.val + " to " + end.val);
		if (path == null) {
			System.out.print("No path");
		} else {
			for (Node n : path) {
				System.out.print(n.val + " ");
			}
		}
		System.out.println();
		System.out.println("Iterative DFS from: " + start.val + " to " + end.val);
		if (path2 == null) {
			System.out.print("No path");
		} else {
			for (Node n : path2) {
				System.out.print(n.val + " ");
			}
		}
		System.out.println();
		System.out.println("Iterative BFT:");
		for (Node n: path3) {
			System.out.print(n.val + " ");
		}
		
		System.out.println();
		System.out.println("Recursive BFT:");
		for (Node n: path4) {
			System.out.print(n.val + " ");
		}
	}
}
