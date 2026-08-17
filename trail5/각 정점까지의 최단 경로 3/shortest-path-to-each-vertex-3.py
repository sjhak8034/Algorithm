import heapq
from collections import defaultdict
MAXWEIGHT = 1000000
def dijkstra(graph, source, n):
    dist = {v: MAXWEIGHT for v in range(1,n+1)}
    dist[source] = 0
    heap = [(0, source)]
  

    while heap:
        current_dist, current = heapq.heappop(heap)
        
        if current_dist > dist[current]:
            continue
        
        for neighbor, weight in graph[current]:
            new_dist = weight + current_dist
            if dist[neighbor] > new_dist:
                dist[neighbor] = new_dist
                heapq.heappush(heap, (new_dist, neighbor))
    return dist
            

n,m = map(int,input().split())
edges = []
for i in range(m):
    edges.append(list(map(int,input().split())))

graph = {}
for edge in edges:
    graph.setdefault(edge[0], []).append([edge[1], edge[2]])
    graph.setdefault(edge[1], [])


dist = dijkstra(graph, 1, n)
for i in range(2, n+1):
    if(dist[i] == MAXWEIGHT):
        print(-1)
    else:
        print(dist[i])