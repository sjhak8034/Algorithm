n, k = map(int, input().split())
arr = list(map(int, input().split()))
map = {}
for i in range(n):
    map.setdefault(arr[i],0)
    map[arr[i]]+=1

answer = 0
for num in arr :
    if k-num in map:
        if k-num == num:
            answer -=1
        answer += map[k-num]
print(answer//2)

# Please write your code here.
