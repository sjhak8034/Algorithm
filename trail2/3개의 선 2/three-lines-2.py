
import copy

def main():
    grid = []
    grid_flat = []
    n = int(input())
    for i in range (n):
        coor = list(map(int,input().split()))
        grid.append(coor)
    
    grid_flat = [x for row in grid for x in row]
    copied_grid = copy.deepcopy(grid)

   

    for i in range (2*n):
        now = grid_flat[i]
        index = i%2
        for coor in copied_grid[:]:
            if coor[index] == now:
                copied_grid.remove(coor)
        
        for i in range(2*n):
            now = grid_flat[i]
            index = i%2
            temp = copy.deepcopy(copied_grid)   
            for coor in copied_grid[:]:
                if coor[index] == now:
                    copied_grid.remove(coor)
            for i in range (2*n):
                now = grid_flat[i]
                index = i%2
                temp2 = copy.deepcopy(copied_grid)   
                for coor in copied_grid[:]:
                    if coor[index] == now:
                        copied_grid.remove(coor)
                if(len(copied_grid) == 0):
                    print(1)
                    return 0
                copied_grid = temp2
            copied_grid = temp
        copied_grid = copy.deepcopy(grid)    
    print(0)
    return 0


main()
