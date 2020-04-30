import java.util.*;
public class Main {
	public static Graph createRandomUnweightedGraphIter(int n) {
		Graph g = new Graph();
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			g.addNode(new Node(Integer.toString(i)));
		}
		Node[] nodes = g.getAllNodes().toArray(new Node[0]);
		for (int i = 0; i < nodes.length; i++) {
			for (int j = i + 1; j < nodes.length; j++) {
				if (rand.nextBoolean()) {
					g.addUndirectedEdge(nodes[i], nodes[j]);
				}
			}
		}
		return g;
	}
	
	public static Graph createLinkedList(int n) {
		Graph g = new Graph();
		for (int i = 0; i < n; i++) {
			g.addNode(new Node(Integer.toString(i)));
		}
		Object[] nodes = g.getAllNodes().toArray();
		for (int i = 0; i < nodes.length-1; i++) {
			g.addUndirectedEdge((Node)nodes[i], (Node)nodes[i+1]);
		}
		return g;
	}
	
	public static ArrayList<Node> BFTRecLinkedList() {
		int numNodes = 10000;
		Graph g = createLinkedList(numNodes);
		return GraphSearch.BFTRec(g);
	}
	
	public static ArrayList<Node> BFTIterLinkedList() {
		int numNodes = 10000;
		Graph g = createLinkedList(numNodes);
		return GraphSearch.BFTIter(g);
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
	
		ArrayList<Node> DFSRecPath = GraphSearch.DFSRec(start, end);
		ArrayList<Node> DFSIterPath = GraphSearch.DFSIter(start, end);
		ArrayList<Node> BFTIterPath = GraphSearch.BFTIter(g);
		ArrayList<Node> BFTRecPath = GraphSearch.BFTRec(g);
		
		//Testing recursive DFS
		System.out.println("Recursive DFS from: " + start.val + " to " + end.val);
		if (DFSRecPath == null) {
			System.out.println("No path");
		} else {
			System.out.println(DFSRecPath);
		}
		
		//Testing iterative DFS
		System.out.println("Iterative DFS from: " + start.val + " to " + end.val);
		if (DFSIterPath == null) {
			System.out.println("No path");
		} else {
			System.out.println(DFSIterPath);
		}
		
		
		//Testing iterative BFT
		System.out.println("Iterative BFT:");
		System.out.println(BFTIterPath);
		
		
		//Testing Recursive BFT
		System.out.println("Recursive BFT:");
		System.out.println(BFTRecPath);
	}
}
