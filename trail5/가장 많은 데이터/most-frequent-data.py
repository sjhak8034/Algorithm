n = int(input())
words = [input() for _ in range(n)]
map = {}
for i in range(n):
    map.setdefault(words[i], 0)
    map[words[i]] += 1

print(max(map.values()))

# Please write your code here.
