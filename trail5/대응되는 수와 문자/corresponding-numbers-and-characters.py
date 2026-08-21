n, m = map(int, input().split())

# Note: Using 1-based indexing for words as per C++ code
words = [""] + [input() for _ in range(n)]
queries = [input() for _ in range(m)]
map = {}

for i in range(1,n+1):
    map[words[i]] = i
    map[str(i)] = words[i]
for i in range(m):
    print(map[queries[i]])
# Please write your code here.
