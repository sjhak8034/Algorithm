n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

prefix = [[0] * (n+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,n+1):
        prefix[i][j] = arr[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]

answer = 0

for i in range(k, n+1):
    for j in range(k, n+1):
        answer = max(answer, prefix[i][j] - prefix[i-k][j] - prefix[i][j-k] + prefix[i-k][j-k])
print(answer)