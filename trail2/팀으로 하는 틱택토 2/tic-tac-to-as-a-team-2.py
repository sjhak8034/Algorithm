grid = [0] * 3
for i in range(3):
    digits = input()
    grid[i] = [int(c) for c in digits]

lines = []          # list 대신 다른 이름


# 대각선
arr = [0] * 10
for i in range(3):
    arr[grid[i][i]] = 1
if sum(arr) == 2:
    temp = []
    for i in range (10):
        if arr[i] == 1:
            temp.append(i)
    lines.append([temp[0], temp[1]])   
    lines.append([temp[1], temp[0]])   

arr = [0] * 10
for i in range(3):
    arr[grid[2-i][i]] = 1
if sum(arr) == 2:
    temp = []
    for i in range (10):
        if arr[i] == 1:
            temp.append(i)
    lines.append([temp[0], temp[1]])   
    lines.append([temp[1], temp[0]])   

# 가로
for i in range(3):
    arr = [0] * 10
    for j in range(3):
        arr[grid[i][j]] = 1
    if sum(arr) == 2:
        temp = []
        for i in range (10):
            if arr[i] == 1:
                temp.append(i)
        lines.append([temp[0], temp[1]])   
        lines.append([temp[1], temp[0]])   

# 세로
for i in range(3):
    arr = [0] * 10
    for j in range(3):
        arr[grid[j][i]] = 1
    if sum(arr) == 2:
        temp = []
        for i in range (10):
            if arr[i] == 1:
                temp.append(i)
        lines.append([temp[0], temp[1]])   
        lines.append([temp[1], temp[0]])   

unique = [list(t) for t in {tuple(x) for x in lines}]
print(int(len(unique)/2))