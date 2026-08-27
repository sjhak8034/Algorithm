from sortedcontainers import SortedSet

n = int(input())
command = []
x = []

for _ in range(n):
    line = input().split()
    command.append(line[0])
    if line[0] in ["add", "remove", "find", "lower_bound", "upper_bound"]:
        x.append(int(line[1]))
    else:
        x.append(0)

ss = SortedSet()

for i in range(n):
    c = command[i]
    v = x[i]
    if c == "add":
        ss.add(v)
    if c == "remove":
        ss.discard(v)  
    if c == "largest":
        print(ss[-1] if ss else None)
    if c == "smallest":
        print(ss[0] if ss else None)
    if c == "lower_bound":
        idx = ss.bisect_left(v)          # v 이상인 첫 위치
        print(ss[idx] if idx < len(ss) else None)

    if c == "upper_bound":
        idx = ss.bisect_right(v)         # v 초과인 첫 위치
        print(ss[idx] if idx < len(ss) else None)
    if c == "find":
        print("true" if v in ss else "false")

