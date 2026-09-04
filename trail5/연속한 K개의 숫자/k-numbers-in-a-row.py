N, K, B = map(int, input().split())
missing = [int(input()) for _ in range(B)]

comb = [1] * (N + 1)
for num in missing:
    comb[num] = 0

lengths = []
length = 0
for i in range(1, N + 1):
    if comb[i] == 0:
        lengths.append(length)
        length = 0
    else:
        length += 1
if comb[N] != 0:
    lengths.append(length)

m = len(lengths)
prefix = [0] * (m + 1)
for i in range(1, m + 1):
    prefix[i] = prefix[i - 1] + lengths[i - 1]

def solve():
    for i in range(m):          # 채울 결측 개수
        for j in range(m - i):  # i+1개 구간을 이어붙이는 시작 위치
            if prefix[j + i + 1] - prefix[j] + i >= K:
                print(i)
                return
    print(B)  # 전부 채워야 하는 극단적인 경우 (예: N번이 결측이고 K==N)

solve()