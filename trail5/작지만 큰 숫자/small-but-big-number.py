from sortedcontainers import SortedSet
n, m = map(int, input().split())
sequence = list(map(int, input().split()))
query = list(map(int, input().split()))


ss = SortedSet()

for num in sequence:
    ss.add(num)

for num in query:
    if ss.bisect_right(num) - 1 <= -1:
        print(-1)
    else:
        idx = ss.bisect_right(num) - 1
        print(ss[idx])
        ss.pop(idx)