n, m = map(int, input().split())
arr = list(map(int, input().split()))
nums = list(map(int, input().split()))
map = {}
for i in range(n):
    map.setdefault(arr[i],0)
    map[arr[i]] += 1


for i in range(m):

    if nums[i] in map:
        print(map[nums[i]], end = ' ')
    else:
        print(0, end = ' ')
# Please write your code here.
