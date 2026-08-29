MAX_DISTANCE = 100000000

N, M, P, Q = map(int, input().split())

edges = [tuple(map(int, input().split())) for _ in range(M)]
queries = [tuple(map(int, input().split())) for _ in range(Q)]



dist = [[MAX_DISTANCE] * (N+1) for _ in range(N+1)] 
distP = [[MAX_DISTANCE] * (N+1) for _ in range(N+1)] 

for i in range(1,N+1):
    dist[i][i] = 0

for edge in edges:
    i,j,w = edge
    if(dist[i][j] > w):
        dist[i][j] = w

for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

for k in range(1,P+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            if distP[i][j] > dist[i][k] + dist[k][j]:
                distP[i][j] = dist[i][k] + dist[k][j]


for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            if distP[i][j] > distP[i][k] + distP[k][j]:
                distP[i][j] = distP[i][k] + distP[k][j]
count = 0
answer = 0

for query in queries:
    i, j = query
    if distP[i][j] != MAX_DISTANCE:
        count += 1
        answer += distP[i][j]
print(count)
print(answer)
# Please write your code here.
