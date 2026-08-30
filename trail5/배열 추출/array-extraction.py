import heapq
n = int(input())
x = [int(input()) for _ in range(n)]

heap = []
for i in range(n):
    num = x[i]
    if num == 0:
        if heap:
            print(-heapq.heappop(heap))  
        else:
            print(0)
    else:
        heapq.heappush(heap,-num)
