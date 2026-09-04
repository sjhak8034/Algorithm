n, k = map(int, input().split())
arr = list(map(int, input().split()))

sums = [0]
for i in range(1,n+1):
    sums.append(sums[i-1] + arr[i-1])
answer = 0
for j in range(1,n-k+1):
    answer = max(sums[j+k-1]-sums[j-1],answer)
print(answer)