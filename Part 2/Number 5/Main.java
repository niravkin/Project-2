import java.util.*;
public class Main {
	public static class Distance {
		Node node;
		int distance;
		public Distance(Node n, int d) {
			node = n;
			distance = d;
		}
	}
	
	public static class DistanceComparator implements Comparator<Distance> {
		public int compare(Distance d1, Distance d2) {
			if (d1.distance < d2.distance) {
				return -1;
			} else if (d2.distance < d1.distance) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public static WeightedGraph createRandomCompleteWeightedGraph(final int n) {
		WeightedGraph wg = new WeightedGraph();
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			wg.addNode(new Node(Integer.toString(i)));
		}
		for (Node firstNode : wg.getAllNodes()) {
			for (Node secondNode : wg.getAllNodes()) {
				if (firstNode != secondNode) {
					wg.addWeightedEdge(firstNode, secondNode, rand.nextInt(20)+1);
				}
			}
		}
		return wg;
	}
	
	public static WeightedGraph createLinkedList(final int n) {
		WeightedGraph wg = new WeightedGraph();
		for (int i = 0; i < n; i++) {
			wg.addNode(new Node(Integer.toString(i)));
		}
		
		Object[] nodes = wg.getAllNodes().toArray();
		for (int i = 0; i < nodes.length-1; i++) {
			wg.addWeightedEdge((Node)nodes[i], (Node)nodes[i+1], 1);
		}
		
		return wg;
	}
	
	public static HashMap<Node, Integer> dijkstras(final Node start) {
		HashMap<Node, Integer> dist = new LinkedHashMap<Node, Integer>();
		PriorityQueue<Distance> pq = new PriorityQueue<Distance>(new DistanceComparator());
		HashSet<Node> finalized = new HashSet<Node>();
		
		pq.add(new Distance(start, 0));
		dist.put(start, 0);
		while (!pq.isEmpty()) {
			Node u = pq.poll().node; 
			finalized.add(u);
			for (Node v : u.neighbors.keySet()) {
				int distUtoV = u.neighbors.get(v);
				if (!dist.containsKey(v) || dist.get(v) > dist.get(u) + distUtoV) {
					dist.put(v, dist.get(u) + distUtoV);
				}
				if (!finalized.contains(v))
					pq.add(new Distance(v, dist.get(v)));
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		WeightedGraph wg = createRandomCompleteWeightedGraph(10);
		
		for (Node n : wg.getAllNodes()) {
			System.out.print(n.val + ": ");
			for (Node neighbor : n.neighbors.keySet()) {
				System.out.print(neighbor.val + "," + n.neighbors.get(neighbor) + " ");
			}
			System.out.println();
		}
		
		HashMap<Node, Integer> minDistances = dijkstras((Node)wg.getAllNodes().toArray()[0]);
		for (Node n : minDistances.keySet()) {
			System.out.println(n.val + " " + minDistances.get(n));
		}
		
	}
}
