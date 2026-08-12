answer = 0

N,M = map(int,input().split())
nums = list(map(int,input().split()))

for i in range (N):
    num = nums[i]
    sum = 0
    for j in range(M):
        sum += num
        num = nums[num-1]
    answer = max(answer, sum)

print(answer)
