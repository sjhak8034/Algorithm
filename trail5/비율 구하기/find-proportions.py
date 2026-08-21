from sortedcontainers import SortedDict 

sd = SortedDict()

n = int(input())
words = [input() for _ in range(n)]



for word in words:
    sd.setdefault(word,0)
    sd[word] += 1/n * 100

for key, value in sd.items():
    print(key, f"{value:.4f}")

# Please write your code here.
