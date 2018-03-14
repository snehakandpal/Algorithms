import java.util.LinkedList;

public class TopologicalSort {
	static int v;
	static Vertex[] vertex;
	static int time;
	
	static LinkedList<Integer> sortedVertex = new LinkedList();
	
	static class Vertex {
		String color;
		Integer p;
		int d;
		int f;
		
		public int compareTo(Vertex compareVertex) {
			return this.f-compareVertex.f;
		}
	}
	
	static void addEdge(GraphUsingAdjacencyList graph, int src, int dest) {
		graph.adjList[src].addFirst(dest);
	}
	
	static void dfs(GraphUsingAdjacencyList graph, int numOfVertex) {
		v = numOfVertex;
		vertex = new Vertex[v];
		for(int i = 0; i < v; i++) {
			vertex[i] = new Vertex();
			vertex[i].color = "WHITE";
			vertex[i].p = null;
		}
		
		time = 0;
		
		for(int i = 0; i < v; i++) {
			if(vertex[i].color.equals("WHITE")) {
				dfsVisit(graph, i);
			}
		}
	}
	
	static void dfsVisit(GraphUsingAdjacencyList graph, int u) {
		time = time + 1;
		vertex[u].d = time;
		vertex[u].color = "GRAY";
		
		for(Integer v : graph.adjList[u]) {
			if(vertex[v].color.equals("WHITE")) {
				vertex[v].p = u;
				dfsVisit(graph, v);
			}
		}
		vertex[u].color = "BLACK";
		sortedVertex.addFirst(u);
		time = time + 1;
		vertex[u].f = time;
	}
	
	static void sort(GraphUsingAdjacencyList graph, int numOfVertex) {
		dfs(graph, numOfVertex);
		for(int i : sortedVertex) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String args[]) {
        int numOfVertex = 6;
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(numOfVertex);
        addEdge(graph, 5, 2);
        addEdge(graph, 5, 0);
        addEdge(graph, 4, 0);
        addEdge(graph, 4, 1);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);
        sort(graph, numOfVertex);
	} 
}
