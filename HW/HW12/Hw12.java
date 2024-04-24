import java.util.*;

class Graph2 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> allEdges = new ArrayList<>();
        for (int i = 0; i < wells.length; i++) allEdges.add(new int[]{0, i + 1, wells[i]});
        for (int[] pipe : pipes) allEdges.add(pipe);
        allEdges.sort(Comparator.comparingInt(a -> a[2]));

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        int minCost = 0;
        for (int[] edge : allEdges) {
            int root1 = find(parent, edge[0]), root2 = find(parent, edge[1]);
            if (root1 != root2) { parent[root1] = root2; minCost += edge[2]; }
        }

        return minCost;
    }

    private int find(int[] parent, int x) {
        return parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }

    public static void main(String[] args) {
        Graph2 graph = new Graph2();
        int result = graph.minCostToSupplyWater(2, new int[]{1, 1}, new int[][]{{1, 2, 1}, {1, 2, 2}});
        System.out.println(result); 
    }
}
