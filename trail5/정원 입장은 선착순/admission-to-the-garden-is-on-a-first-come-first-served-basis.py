import heapq

N = int(input())
a, t = [], []
for _ in range(N):
    ai, ti = map(int, input().split())
    a.append(ai)
    t.append(ti)


heap_wait_people = []
heap_wait_time = []
heap_come = []

for i in range(N):
    heapq.heappush(heap_come,(a[i],i,t[i]))

current_t = 0
while heap_come:

    while heap_come and heap_come[0][0] < current_t:
        heapq.heappush(heap_wait_people,(heap_come[0][1],heap_come[0][0],heap_come[0][2]))
        heapq.heappop(heap_come)

    if not heap_wait_people:
        heapq.heappush(heap_wait_time,-max(heap_come[0][0],current_t) + heap_come[0][0])
        current_t = max(heap_come[0][0],current_t) + + heap_come[0][2]
        heapq.heappop(heap_come)
    else:
        
        idx, a, t = heapq.heappop(heap_wait_people)
        heapq.heappush(heap_wait_time,-max(a,current_t) + a)
        current_t = max(a,current_t) + t

   

    
    

print(-heap_wait_time[0])