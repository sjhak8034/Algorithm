from sortedcontainers import SortedDict
n = int(input())

cmd = []
k = []
v = []

for _ in range(n):
    line = input().split()
    cmd.append(line[0])
    if line[0] == "add":
        k.append(int(line[1]))
        v.append(int(line[2]))
    elif line[0] == "remove" or line[0] == "find":
        k.append(int(line[1]))
        v.append(0)
    else:
        k.append(0)
        v.append(0)

sd = SortedDict()


for i, command in enumerate(cmd):
    key = k[i]
    value = v[i]
    if command == "add" :
        sd[key] = value
    if command == "remove":
        sd.pop(key)
    if command == "find":
        if key in sd:
            print(sd[key])
        else:
            print(None)
    if command == "print_list":
        for value in sd.values():
            print(value, end= " ")
        if len(sd.values()) == 0:
            print(None, end = " ")
        print()
# Please write your code here.
