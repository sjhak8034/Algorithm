n, k = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0
map = {}
for i in range(n):
    map.setdefault(arr[i],0)
    map[arr[i]] += 1
for i in range(n):
    for j in range(i+1,n):
        n1 = arr[i]
        n2 = arr[j]
        n3 = k-n1-n2
        
        if n1 in map and n2 in map and n3 in map:
      
            answer -= 1 if (n3 == n1) else 0
            answer -= 1 if (n3 == n2) else 0
            answer += map[n3]
       

print(answer//3)
# Please write your code here.
