n = int(input())
commands = []
for _ in range(n):
    line = input().split()
    cmd = line[0]
    k = int(line[1])
    if cmd == "add":
        v = int(line[2])
        commands.append((cmd, k, v))
    else:
        commands.append((cmd, k))
map = {}
for command in commands:
   
    k = command[1]
    if command[0] == "add":
       v = command[2]
       map[k] = v 
    if command[0] == "find":
        print(map.get(k, None))
    if command[0] == "remove":
        map.pop(k) 
# Please write your code here.
