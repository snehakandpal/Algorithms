import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	static int v;
	static Vertex[] vertex;
	
	static Queue<Integer> queue = new LinkedList<>();
	
	static class Vertex {
		String color;
		Integer p;
		int d;
	}
	
	static void bfs(GraphUsingAdjacencyList graph, int s, int numOfVertex) {
		v = numOfVertex;
		vertex = new Vertex[v];
		for(int i = 0; i < v; i++) {
			vertex[i] = new Vertex();
			vertex[i].color = "WHITE";
			vertex[i].d = Integer.MAX_VALUE;
			vertex[i].p = null;
		}
		
		vertex[s].color = "GRAY";
		vertex[s].d = 0;
		vertex[s].p = null;
		
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int u = queue.remove();
			System.out.print(u);
			for(Integer v : graph.adjList[u]) {
				if(vertex[v].color.equals("WHITE")) {
					vertex[v].color = "GRAY";
					vertex[v].d = vertex[u].d + 1;
					vertex[v].p = u;
					queue.add(v);
				}
			}
			vertex[u].color = "BLACK";
		}
	}
	
	public static void main(String args[]) {
        int numOfVertex = 7;
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(numOfVertex);
        graph.addEdge(graph, 0, 2);
        graph. addEdge(graph, 0, 1);
        graph.addEdge(graph, 1, 4);
        graph.addEdge(graph, 1, 3);
        graph.addEdge(graph, 2, 6);
        graph.addEdge(graph, 2, 5);
        
        bfs(graph, 0, numOfVertex);
	}    
}
