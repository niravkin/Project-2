import java.util.*;
public class Main {
	public static DirectedGraph createRandomDAGIter(int n) {
		DirectedGraph dg = new DirectedGraph();
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			dg.addNode(new Node(Integer.toString(i)));
		}
		Object[] nodes = dg.getAllNodes().toArray();
		for (int i = 0; i < nodes.length; i++) {
			for (int j = i + 1; j < nodes.length; j++) {
				if (rand.nextBoolean()) {
					dg.addDirectedEdge((Node)nodes[i], (Node)nodes[j]);
				}
			}
		}
		return dg;
	}
	
	public static void main(String[] args) {
		DirectedGraph dg = createRandomDAGIter(1000);

		ArrayList<Node> mDFSPath = TopSort.mDFS(dg);
		ArrayList<Node> kahnsPath = TopSort.Kahns(dg);
		
		System.out.println("MDFS: ");
		for (Node n : mDFSPath) {
			System.out.print(n.val + " " );
		}
		System.out.println();
		
		System.out.println("Kahns: ");
		for (Node n : kahnsPath) {
			System.out.print(n.val + " " );
		}
		
		System.out.println();
	}
}
