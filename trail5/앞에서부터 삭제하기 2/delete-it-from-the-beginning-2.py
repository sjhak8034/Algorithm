import heapq
n = int(input())
arr = list(map(int, input().split()))
answer = 0
heap = []
heap2 = []
for i in range(n-1,n):
        heapq.heappush(heap,arr[i])
sum = 0
for k in range(n-2, 1, -1):
    heapq.heappush(heap,arr[k])
    heapq.heappush(heap2,heapq.heappop(heap))
    
    
    size = n-k-1
    while heap:
        sum += heap[0]
        heapq.heappush(heap2,heapq.heappop(heap))
    answer = max(answer, sum/size)
    heapq.heappush(heap,heapq.heappop(heap2))

print(f"{answer:.2f}")

