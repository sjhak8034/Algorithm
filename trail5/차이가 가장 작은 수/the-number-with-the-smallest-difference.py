from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = [int(input()) for _ in range(n)]

ss = SortedSet()

for num in arr:
    ss.add(num)




def solve():
    left = 0
    right = 1
    answer = 10000000000
    flag = 0
    while (right <= len(ss)-1):
        if ss[right] - ss[left] > m :
            flag = 1
            answer = min(answer,ss[right] - ss[left]) 
            left += 1
        elif ss[right] - ss[left] < m:
            right += 1
        else:
            print(m)
            return 0
    if flag == 0:
        print(-1)
    else:
        print(answer) 

solve()


