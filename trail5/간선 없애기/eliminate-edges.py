import heapq
import sys

def dijkstra(adj, n, source):
    INF = float('inf')
    dist = [INF] * (n + 1)
    dist[source] = 0
    heap = [(0, source)]
    while heap:
        d, u = heapq.heappop(heap)
        if d > dist[u]:
            continue
        for v, w in adj[u]:
            nd = d + w
            if nd < dist[v]:
                dist[v] = nd
                heapq.heappush(heap, (nd, v))
    return dist

def solve():
    n, m = map(int, input().split())
    adj = [[] for _ in range(n+1)]
    edges = []
    for _ in range(m):
        a, b, w = map(int, input().split())
        adj[a].append((b, w))
        adj[b].append((a, w))
        edges.append((a, b, w))

    dist1 = dijkstra(adj, n, 1)      # 1에서 각 정점까지 최단거리
    distN = dijkstra(adj, n, n)      # n에서 각 정점까지 최단거리 (양방향이라 그대로 사용 가능)
    D = dist1[n]

    # 최단경로 DAG 구성: dist1이 작은 쪽 -> 큰 쪽 방향으로만
    dag_out = [[] for _ in range(n+1)]
    edge_dir = []
    for a, b, w in edges:
        if dist1[a] + w + distN[b] == D:
            dag_out[a].append(b)
            edge_dir.append((a, b))
        elif dist1[b] + w + distN[a] == D:
            dag_out[b].append(a)
            edge_dir.append((b, a))
        else:
            edge_dir.append(None)   # 최단경로에 아예 안 쓰이는 간선 -> 제거해도 영향 없음

    order = sorted(range(1, n+1), key=lambda v: dist1[v])

    cnt1 = [0] * (n+1)       # 1 -> v 최단경로 개수 (정확한 값)
    cnt1[1] = 1
    for u in order:
        for v in dag_out[u]:
            cnt1[v] += cnt1[u]

    cntN = [0] * (n+1)       # v -> n 최단경로 개수
    cntN[n] = 1
    for u in reversed(order):
        for v in dag_out[u]:
            cntN[u] += cntN[v]

    total = cnt1[n]

    count = 0
    for d in edge_dir:
        if d is None:
            continue
        u, v = d
        if cnt1[u] * cntN[v] == total:    # 이 간선을 모든 최단경로가 반드시 지나감
            count += 1

    print(count)

solve()