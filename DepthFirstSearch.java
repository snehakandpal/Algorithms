
public class DepthFirstSearch {
	static int v;
	static Vertex[] vertex;
//	static int time;
	
	static class Vertex {
		String color;
		Integer p;
//		int d;
//		int f;
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
		
//		time = 0;
		
		for(int i = 0; i < v; i++) {
			if(vertex[i].color.equals("WHITE")) {
				System.out.println(i);
				dfsVisit(graph, i);
			}
		}
	}
	
	static void dfsVisit(GraphUsingAdjacencyList graph, int u) {
//		time = time + 1;
//		vertex[u].d = time;
		vertex[u].color = "GRAY";
		
		for(Integer v : graph.adjList[u]) {
			if(vertex[v].color.equals("WHITE")) {
				System.out.println(v);
				vertex[v].p = u;
				dfsVisit(graph, v);
			}
//			else if(vertex[v].color.equals("GRAY")) {
//				System.out.println("Cycle exists.");
//			}
 		}
		vertex[u].color = "BLACK";
//		time = time + 1;
//		vertex[u].f = time;
	}
	
	public static void main(String args[]) {
        int numOfVertex = 5;
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(numOfVertex);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        
        dfs(graph, numOfVertex);
	} 
}
