MAX_DIST = 100000000
n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

dist = [[MAX_DIST] * (n+1) for _ in range(n+1)]  

for i in range(1,n+1):
    dist[i][i] = 0

for edge in edges:
    i, j, w = edge
   
    if dist[i][j] > w:
        dist[i][j] = w

for i in range(1,n+1):
    for j in range(1,n+1):
        for k in range(1,n+1):
            if dist[k][j] > dist[k][i] + dist[i][j]:
                dist[k][j] = dist[k][i] + dist[i][j]

for i in range(1, n+1):
    for j in range(1, n+1):
        if dist[i][j] == MAX_DIST:
            print(-1, end = " ")
        else:
            print(dist[i][j], end = " ")
    print("")