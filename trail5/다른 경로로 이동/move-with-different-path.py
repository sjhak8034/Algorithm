import heapq

MAX_DIST = 1000000
n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

adj = [[] for _ in range(n+1)]     # adj[u] = [(간선ID, 이웃), ...]
edge_weight = []                    # edge_weight[간선ID] = 가중치

for eid, (start, end, weight) in enumerate(edges):
    adj[start].append((eid, end))
    adj[end].append((eid, start))
    edge_weight.append(weight)

for i in range(1,n+1):
     adj[i] = sorted(adj[i], key=lambda x: x[1])
    
disabled = [False] * len(edges)

def dijkstra(adj, edge_weight, disabled, n, source):
    dist = [MAX_DIST] * (n+1)
    dist[source] = 0
    heap = [(0, source)]
    while heap:
        d, u = heapq.heappop(heap)
        if d > dist[u]:
            continue
        for eid, v in adj[u]:
            if disabled[eid]:
                continue          # 꺼진 간선이면 양방향 다 자동으로 건너뜀
            nd = d + edge_weight[eid]
            if nd < dist[v]:
                dist[v] = nd
                heapq.heappush(heap, (nd, v))
    return dist


dist = dijkstra(adj,edge_weight,disabled,n,1)
distN = dijkstra(adj, edge_weight, disabled, n, n) 
stack = [1]

while stack:
    current = stack.pop()
    for eid, neighbor in adj[current]:
        if disabled[eid]:
            continue
        if edge_weight[eid] + distN[neighbor] + dist[current] == dist[n]:
            disabled[eid] = True      # 이 한 줄이 양방향 모두 처리
            stack.append(neighbor)
            break

dist_disalbed = dijkstra(adj,edge_weight,disabled,n,1)
print(dist_disalbed[n])