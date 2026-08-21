N, G = map(int, input().split())

group = []
group_size = []

for _ in range(G):
    nums = list(map(int, input().split()))
    group_size.append(nums[0])
    group.append(nums[1:])

p = set()

p.add(1)
answer = 0
while p:
    answer +=1 
    now = p.pop()
    for members in group:
        if now in members:
            members.remove(now)
        if len(members) == 1:
            p.add(members[0])
    
print(answer)


# Please write your code here.
