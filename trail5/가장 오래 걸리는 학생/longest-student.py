import heapq
MAX_DISTANCE = 1000000
n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

adj = [[] for _ in range(n+1)]
weights = []
for eid, [current,neighbor,weight] in enumerate(edges):
    adj[current].append([eid,neighbor])
    adj[neighbor].append([eid,current])
    weights.append(weight)

def dijkstra(adj,weights,source,n):
    dist = {v:MAX_DISTANCE for v in range(1,n+1)}
    dist[source] = 0
    heap = [[0,source]]

    while heap:
        c_d, c = heapq.heappop(heap)
        if c_d > dist[c]:
            continue
        for eid,neighbor in adj[c]:
            if weights[eid] + c_d < dist[neighbor]:
                dist[neighbor] =  weights[eid] + c_d
                heapq.heappush(heap,[dist[neighbor],neighbor])

    return dist

dist = dijkstra(adj,weights,1,n)
distN = dijkstra(adj,weights,n,n)

print(max(distN.values()))

# Please write your code here.
