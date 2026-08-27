from sortedcontainers import SortedSet
n, m = map(int, input().split())

# Store points as list of tuples
points = [tuple(map(int, input().split())) for _ in range(n)]

# Store queries as list of tuples
queries = [tuple(map(int, input().split())) for _ in range(m)]

ss = SortedSet()

for point in points:
    ss.add(point)

for query in queries:
    idx = ss.bisect_right(query)
    if(idx >= len(ss)):
        print(-1,-1)
    else:
        print(ss[idx][0], ss[idx][1])