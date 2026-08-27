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
        ss.remove(v)
    if c == "largest":
        length = len(ss)
        if length == 0:
            print(None)
        else:
            print(ss[length-1])
    if c == "smallest":
        length = len(ss)
        if length == 0:
            print(None)
        else:
            print(ss[0])
    if c == "lower_bound":
        flag = 0
        for i in range(len(ss)):
            if(ss[i] >= v):
                flag = 1
                print(ss[i])
                break
        if flag == 0:
            print(None)
    if c == "upper_bound":
        flag = 0
        for i in range(len(ss)):
            if(ss[i] > v):
                flag = 1
                print(ss[i])
                break
        if flag == 0:
            print(None)
    if c == "find":
        if v in ss:
            print("true")
        else: 
            print("false")

