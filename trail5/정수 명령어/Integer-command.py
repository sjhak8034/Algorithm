from sortedcontainers import SortedSet

T = int(input())



for _ in range(T):
    ss = SortedSet()
    k = int(input())
    operations = [tuple(input().split()) for _ in range(k)]
    command = [op[0] for op in operations]
    n = [int(op[1]) for op in operations]

    for i in range(k):
        c = command[i]
        v = n[i]
        if c == "I":
            ss.add(v)
        if c == "D":
            if ss:
                if v == 1:
                    ss.pop(len(ss)-1)
                else:
                    ss.pop(0)
    if ss:
        print(ss[-1], ss[0])
    else:
        print("EMPTY")

