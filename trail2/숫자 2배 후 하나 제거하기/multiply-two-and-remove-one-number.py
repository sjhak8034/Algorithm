import copy
answer = 10 ** 18
n = int(input())
arr = list(map(int,input().split()))
temp = copy.deepcopy(arr)

for i in range(n): # muptiple
    arr[i] = 2*arr[i]
    for j in range(n): # skip
        comp = 0
        a = arr.pop(j)
        for k in range(n-2):
            diff = abs(arr[k] - arr[k+1])
            comp += diff
        arr.insert(j,a)
        answer = min(answer, comp)
    
    arr[i] = temp[i]
    
print(answer)