import heapq

N = int(input())
commands = []

for _ in range(N):
    line = input().split()
    if line[0] == "push":
        commands.append((line[0], int(line[1])))
    else:
        commands.append((line[0],))


class PriorityQueue:
    def __init__(self):
        self.items = []
    def push(self,item):
        heapq.heappush(self.items,-item)
    def pop(self):
        return -heapq.heappop(self.items)
    def empty(self):
        return not self.items
    def size(self):
        return len(self.items)
    def top(self):
        return -self.items[0]

pq = PriorityQueue()

for command in commands:
    c = command[0]

    if c == "push":
        v = command[1]
        pq.push(v)
    if c == "size":
        print(pq.size())
    if c == "pop":
        print(pq.pop())
    if c == "empty":
        print(int(pq.empty()))
    if c == "top":
        print(pq.top())
