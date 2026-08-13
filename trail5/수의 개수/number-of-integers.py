def lower_bound(nums, target):
    lo, hi = 0, len(nums)
    while lo < hi:
        mid = (lo + hi) // 2
        if nums[mid] >= target:
            hi = mid
        else:
            lo = mid + 1
    return lo

def upper_bound(nums, target):
    lo, hi = 0, len(nums)
    while lo < hi:
        mid = (lo + hi) // 2
        if nums[mid] > target:
            hi = mid
        else:
            lo = mid + 1
    return lo

def count(nums, target):
    return upper_bound(nums, target) - lower_bound(nums, target)

n, m = map(int, input().split())

nums = list(map(int, input().split()))

for i in range(m):
    target = int(input())
    result = count(nums,target)
    print(result)