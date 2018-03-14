import java.util.Arrays;

public class GraphKruskalMST {
		int V, E;
		Edge edge[];
		
		Edge result[];					//store MST
		int e = 0;						//index for result[]
		
		class Edge implements Comparable<Edge>{
			int src;
			int dest;
			int weight;
			
			public int compareTo(Edge compareEdge) {
				return this.weight-compareEdge.weight;
			}
		}
		
		GraphKruskalMST(int v, int e) {
			V = v;
			E = e;
			edge = new Edge[E];
			for(int i = 0; i < e; i++) {
				edge[i] = new Edge();
			}
		}
		
		int find(int parent[],int i) {
			if(parent[i] != i)
				parent[i] = find(parent, parent[i]);
			return parent[i];
		}
		
		void Union(int parent[], int x, int y) {
			int xset = find(parent, x);
			int yset = find(parent, y);
			parent[xset] = yset;
		}
		
//		int isCycle(GraphKruskalMST graph) {
//			int parent[] = new int[graph.V];
//			
//			for(int i = 0; i < graph.V; i++) {
//				parent[i] = -1;
//			}
//			
//			for(int i = 0; i < graph.E; i++) {
//				int x = find(parent, graph.edge[i].src);
//				int y = find(parent, graph.edge[i].dest);
//				if(x == y)
//					return 1;
//				Union(parent, x, y);
//			}
//			return 0;
//		}
		
		void kruskal() {
			 result = new Edge[V];
			
			for(int i = 0; i < V; i++) {
				result[i] = new Edge();
			}
			
			Arrays.sort(edge);				//sort in ascending order w.r.t. weight
			
			int parent[] = new int[V];		//parent[] for each vertex
			for(int i = 0; i < V; i++) {
				parent[i] = i;				//initial parent is the vertex itself
			}
			
			int i = 0;						//index for next edge
			
			while(e < V - 1) {
				Edge nextEdge = new Edge();
				nextEdge = edge[i++];
				
				int x = find(parent, nextEdge.src);
				int y = find(parent, nextEdge.dest); 
				
				if(x != y) {					//check if acyclic
					result[e++] = nextEdge;
					Union(parent, x, y);
				}
			}
		}
		
		void printMST() {
			System.out.println("Following are the edges in " + "the constructed MST");
			for (int i = 0; i < e; ++i)
				System.out.println(result[i].src+" -- " + result[i].dest+" == " + result[i].weight);
		}
		
		 public static void main (String[] args) {
		        int V = 4;  // Number of vertices in graph
		        int E = 5;  // Number of edges in graph
		        GraphKruskalMST graph = new GraphKruskalMST(V, E);
		 
		        // add edge 0-1
		        graph.edge[0].src = 0;
		        graph.edge[0].dest = 1;
		        graph.edge[0].weight = 10;
		 
		        // add edge 0-2
		        graph.edge[1].src = 0;
		        graph.edge[1].dest = 2;
		        graph.edge[1].weight = 6;
		 
		        // add edge 0-3
		        graph.edge[2].src = 0;
		        graph.edge[2].dest = 3;
		        graph.edge[2].weight = 5;
		 
		        // add edge 1-3
		        graph.edge[3].src = 1;
		        graph.edge[3].dest = 3;
		        graph.edge[3].weight = 15;
		 
		        // add edge 2-3
		        graph.edge[4].src = 2;
		        graph.edge[4].dest = 3;
		        graph.edge[4].weight = 4;
		 
		        graph.kruskal();
		        graph.printMST();
		    }
}