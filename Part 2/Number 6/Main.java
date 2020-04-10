import java.util.*;

public class Main {
	public static class Distance {
		GridNode node;
		int distanceFromStart;
		int estimateToEnd;
		public Distance(GridNode gn, int g, int h) {
			node = gn;
			distanceFromStart = g;
			estimateToEnd = h;
		}
	}
	
	public static class DistanceComparator implements Comparator<Distance> {
		public int compare(Distance d1, Distance d2) {
			if (d1.distanceFromStart + d1.estimateToEnd < d2.distanceFromStart + d2.estimateToEnd) {
				return -1;
			} else if (d1.distanceFromStart + d1.estimateToEnd > d2.distanceFromStart + d2.estimateToEnd) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public static Graph createRandomGridGraph(int n) {
		Graph g = new Graph();
		Random rand = new Random();
		GridNode[][] grid = new GridNode[n][n];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				GridNode gn = new GridNode(x, y, Integer.toString(x) + "," + Integer.toString(y));
				g.addGridNode(gn);
				grid[x][y] = gn;
			}
		}

		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid.length; y++) {
					System.out.println("gridNode is : " + grid[x][y].val);
					if (x+1 < grid.length) {
						if (rand.nextInt(100) < 75)
							g.addUndirectedEdge(grid[x][y], grid[x+1][y]);
					}
					if (y+1 < grid.length) {
						if (rand.nextInt(100) < 75)
							g.addUndirectedEdge(grid[x][y], grid[x][y+1]);
					}
			}
		}
		
		return g;
	}
	
	private static int heuristic(final GridNode sourceNode, final GridNode destNode) {
		int xDist = Math.abs(sourceNode.x - destNode.x);
		int yDist = Math.abs(sourceNode.y - destNode.y);
		return xDist + yDist;
	}
	
	public static ArrayList<GridNode> astar(final GridNode sourceNode, final GridNode destNode) {
		PriorityQueue<Distance> pq = new PriorityQueue<Distance>(new DistanceComparator());
		HashMap<GridNode, Integer> dist = new LinkedHashMap<GridNode, Integer>();
		HashMap<GridNode, GridNode> parents = new HashMap<GridNode, GridNode>();
		dist.put(sourceNode, 0);
		pq.add(new Distance(sourceNode, 0, heuristic(sourceNode, destNode)));
		parents.put(sourceNode,  null);
		while (!pq.isEmpty()) {
			GridNode curr = pq.poll().node;
			if (curr == destNode)
				break;
			for (GridNode neighbor : curr.neighbors) {
				int newCost = dist.get(curr) + 1;
				if (!dist.containsKey(neighbor) || newCost < dist.get(neighbor)) {
					dist.put(neighbor, newCost);
					pq.add(new Distance(neighbor, newCost, heuristic(neighbor, destNode)));
					parents.put(neighbor, curr);
				}
			}
		}
		if (parents.get(destNode) != null) {
			//construct path
			ArrayList<GridNode> path = new ArrayList<GridNode>();
			GridNode curr = destNode;
			path.add(destNode);
			while (curr != null) {
				curr = parents.get(curr);
				path.add(curr);
			}
			Collections.reverse(path);
			return path;
		} else {
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		Graph g = createRandomGridGraph(100);
		for (GridNode gn : g.getAllNodes()) {
			System.out.print(gn.val + ": ");
			for (GridNode neighbor : gn.neighbors) {
				System.out.print(neighbor.val + " ");
			}
			System.out.println();
		}
		Object[] nodes = g.getAllNodes().toArray();
		GridNode sourceNode = (GridNode)nodes[0];
		GridNode destNode = (GridNode)nodes[nodes.length-1];
		System.out.println("Path from " + sourceNode.val + " to " + destNode.val);
		ArrayList<GridNode> path = astar(sourceNode, destNode);
		if (path != null) {
			for (GridNode gn : path) {
				if (gn != null)
					System.out.print("(" + gn.val + ") -> ");
			}
		} else {
			System.out.println("No path");
		}
		
	}

}
