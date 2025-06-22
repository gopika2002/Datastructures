import java.util.*;
class Graph 
{
    int V;
    List<List<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    // === Graph Basics ===
    void addEdge(int u, int v) {}

    // === Traversals ===
    void dfs(int src, boolean[] visited) {}
    void bfs(int src) {}

    // === Connectivity & Paths ===
    boolean hasPath(int src, int dest, boolean[] visited) {}
    List<Integer> shortestPathUnweighted(int src, int dest) {}

    // === Cycle Detection ===
    boolean hasCycleUndirected(int v, boolean[] visited, int parent) {}
    boolean hasCycleDirected(int v, boolean[] visited, boolean[] recStack) {}

    // === Topological Sort ===
    List<Integer> topologicalSortDFS() {}
    List<Integer> topologicalSortKahn() {}

    // === Strongly Connected Components (Tarjan’s Algorithm) ===
    void tarjansSCC() {}

    // === Shortest Paths ===
    int[] dijkstra(int src) {}
    int[] bellmanFord(int src) {}
    int[][] floydWarshall() {}

    // === MST Algorithms ===
    void primsMST() {}
    void kruskalsMST() {}

    // === Bipartite Check ===
    boolean isBipartite() {}

    // === Bridges and Articulation Points ===
    void findBridges() {}
    void findArticulationPoints() {}
}
