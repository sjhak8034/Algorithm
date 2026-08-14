import copy
def sim(n, grid, bombCoors, bombs, result, index, current):
   
    if(index == len(bombCoors)) :
        result[0] = max(result[0], current)
        return
    
    
    x = bombCoors[index][1]
    y = bombCoors[index][0]
    for bomb in bombs:
        dx = bomb[1]
        dy = bomb[0]
        current_copy = current
        temp = []
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if(ny < 0 or ny >= n or nx < 0 or nx >= n):
                continue
            if grid[ny][nx] == 1:
                continue
            grid[ny][nx] = 1
            current_copy += 1
            temp.append([ny,nx])
        
        sim(n, grid, bombCoors, bombs, result, index+1,current_copy)
        for coor in temp:
            grid[coor[0]][coor[1]] = 0 

n = int(input())
grid = []
for i in range(n):
    grid.append(list(map(int,input().split())))
bombCoors = []
for i in range(n):
    for j in range(n):
        if grid[i][j] == 1:
            bombCoors.append([i,j])
bombs = [[[-1,-2,1,2],[0,0,0,0]], [[-1,1,0,0],[0,0,-1,1]], [[-1,-1,1,1],[1,-1,1,-1]]]
result = [0]
sim(n,grid,bombCoors,bombs,result,0,len(bombCoors))
print(result[0])