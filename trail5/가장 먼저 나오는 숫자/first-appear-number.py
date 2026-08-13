def lowerSearch(nums, target):
    lo = 0
    hi = len(nums)

    while(lo < hi):
        mid = (lo + hi)//2
        if(nums[mid] >= target):
            hi = mid
        else:
            lo = mid+1
    return lo+1 if lo < len(nums) and nums[lo] == target else -1

n,m = map(int,input().split())
nums = list(map(int,input().split()))
targets = list(map(int,input().split()))
for i in range(m):
    target = targets[i]
    result = lowerSearch(nums, target)
    print(result)