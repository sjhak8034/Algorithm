import heapq
n = int(input())
arr = list(map(int, input().split()))

heap1 = []
heap2 = []



for i in range(n):
    mul = 1
    heapq.heappush(heap1,arr[i])
    if len(heap1) < 3:
        print(-1)
    else:
        for i in range(3):
            num = heapq.heappop(heap1)
            mul *= num
            heapq.heappush(heap2, num)
        print(mul)
        for i in range(3):
            heapq.heappush(heap1,heapq.heappop(heap2))