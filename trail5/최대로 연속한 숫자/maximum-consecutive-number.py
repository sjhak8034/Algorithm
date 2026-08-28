from sortedcontainers import SortedSet

n, m = map(int, input().split())
nums = list(map(int, input().split()))

ss = SortedSet()


ss.add(-1)
ss.add( n+1)
ss2 = SortedSet()

memo = {}

for num in nums:
    ss.add(num)
    idx = ss.bisect_left(num)
    if(ss[idx+1]- ss[idx-1]-1 in memo):
        memo[ss[idx+1]- ss[idx-1]-1] -= 1
        if (memo[ss[idx+1]- ss[idx-1]-1] == 0):
            ss2.discard(ss[idx+1]- ss[idx-1]-1)
    ss2.add(ss[idx+1] - ss[idx]-1)
    ss2.add(ss[idx] - ss[idx-1]-1)
    memo.setdefault(ss[idx+1] - ss[idx]-1,0)
    memo.setdefault(ss[idx] - ss[idx-1]-1,0)
    memo[ss[idx+1] - ss[idx]-1] += 1
    memo[ss[idx] - ss[idx-1]-1] += 1
    print(ss2[len(ss2)-1])


