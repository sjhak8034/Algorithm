import heapq

t = int(input())
for _ in range(t):
    m = int(input())
    arr = list(map(int, input().split()))
    heap_min = []
    heap_max = []
    count = 0
    for num in arr:
        count += 1
        if(count == 1):
            heapq.heappush(heap_min,num)
        else:
            if num >= heap_min[0]:
                heapq.heappush(heap_min,num)
            else:
                heapq.heappush(heap_max,-num)
        if count % 2 == 1:
            while len(heap_min) != len(heap_max) + 1:
                if  len(heap_min) > len(heap_max) + 1:
                    heapq.heappush(heap_max,-heapq.heappop(heap_min)) 
                else:
                    heapq.heappush(heap_min,-heapq.heappop(heap_max)) 
            
            print(heap_min[0], end = " ")
        
    print()
    


    
