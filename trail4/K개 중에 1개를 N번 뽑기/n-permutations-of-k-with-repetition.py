K,N = map(int,input().split())

def dfs(K,N,depth,array):
    if depth == N:
        print(" ".join(map(str, array))) 
        return
    
    for i in range(K):
        array.append(i+1)
        dfs(K,N,depth + 1,array)
        array.pop()

    
dfs(K,N,0,[])