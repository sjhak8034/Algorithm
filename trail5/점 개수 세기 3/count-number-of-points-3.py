from sortedcontainers import SortedSet

n, q = map(int, input().split())
points = list(map(int, input().split()))
queries = [tuple(map(int, input().split())) for _ in range(q)]

ss = SortedSet()

pdict = {}

for i in range(n):
    ss.add(points[i])

for i, v in enumerate(ss):
    pdict.setdefault(v,i)

for i in range(q):
    n1, n2 = queries[i]

    print(pdict[n2] - pdict[n1] + 1)




