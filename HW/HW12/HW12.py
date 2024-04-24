from typing import List

class Graph:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        all_edges = []
        
        for i, cost in enumerate(wells):
            all_edges.append((0, i+1, cost)) 
        
        for pipe in pipes:
            all_edges.append((pipe[0], pipe[1], pipe[2]))
        
        all_edges.sort(key=lambda x: x[2])
        
        parent = [i for i in range(n+1)]
        
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        min_cost = 0
        for edge in all_edges:
            house1, house2, cost = edge
            root1 = find(house1)
            root2 = find(house2)
            if root1 != root2:  
                parent[root1] = root2
                min_cost += cost
        
        return min_cost

graph = Graph()
print(graph.minCostToSupplyWater(2, [1,1], [[1,2,1],[1,2,2]])) 
