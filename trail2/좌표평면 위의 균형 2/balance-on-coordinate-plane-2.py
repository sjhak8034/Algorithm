n = int(input())
coors = []
for i in range(n):
    coors.append(list(map(int,input().split())))

answer = 10000

for i in range(50):
    x = 2*i
    for j in range(50):
        y = 2*j
        result = [0]*4
        for coor in coors:
            leftRight = 1 if x - coor[0] > 0 else 0
            upperLower = 1 if y - coor[1] > 0 else 0
            result[leftRight + 2*upperLower] += 1

        answer = min(answer, max(result))       

        
print(answer)