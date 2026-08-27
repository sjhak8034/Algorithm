from sortedcontainers import SortedSet

n, m = map(int, input().split())
a = list(map(int, input().split()))

ss = SortedSet()
def solve():
    for i in range(1,m+1):
        ss.add(i)

    for i in range(n):
        fav = a[i]
        idx = ss.bisect_right(fav)-1
 
        if idx < 0:
            print(i)
            return
        else:
            ss.pop(idx)

    print(n)

solve()