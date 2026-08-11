point = [0] * 4
cups = [0] * 4
for i in range(4):
    cups[i] = i
n = int(input())
answer = 0
for i in range(n):
    a,b,c = map(int, input().split())
    
    temp = cups[b]
    cups[b] = cups[a]
    cups[a] = temp
    point[cups[c]] += 1
   

    
for i in range(4):
    
    answer = max(answer, point[i])
print(answer)