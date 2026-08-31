import heapq
n = int(input())
x = [int(input()) for _ in range(n)]
heap = []
for i in range(n):
    num = x[i]
    if num != 0:
        heapq.heappush(heap,(abs(num), num))
    else:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)

# Please write your code here.
