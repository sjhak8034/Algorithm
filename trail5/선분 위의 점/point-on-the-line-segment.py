n, m = map(int,input().split())
nums = list(map(int,input().split()))
nums = sorted(nums)

coors = []

for i in range(m):
    coor = list(map(int,input().split()))
    coors.append(coor)

def upper_bound(nums,target):
    hi = len(nums)
    lo = 0
    while hi > lo:
        mid = (lo + hi)//2
        if nums[mid] > target:
            hi = mid 
        else: 
            lo = mid + 1
    return lo

def lower_bound(nums,target):
    hi = len(nums)
    lo = 0
    while hi > lo:
        mid = (lo + hi)//2
        if nums[mid] >= target:
            hi = mid 
        else: 
            lo = mid + 1
    return lo
def count(nums,target1,target2):
    return(upper_bound(nums,target1) - lower_bound(nums,target2))
for coor in coors:
    print(count(nums,coor[1],coor[0]))


