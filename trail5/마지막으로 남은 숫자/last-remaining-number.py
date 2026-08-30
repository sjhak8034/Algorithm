import heapq

n = int(input())
arr = list(map(int, input().split()))

heap = []
for i in range(n):
    heapq.heappush(heap,-arr[i])

while len(heap) > 1:
    num1 = -heapq.heappop(heap)
    num2 = -heapq.heappop(heap)
    if(num1 == num2):
        continue
    heapq.heappush(heap,-num1+num2)

if len(heap) == 0:
    print(-1)
else:
    print(-heap[0])
