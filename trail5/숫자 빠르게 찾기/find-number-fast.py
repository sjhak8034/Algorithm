n, m = map(int,input().split())

nums = list(map(int,input().split()))

def bsearch(nums, num):
    lo, hi = 0, len(nums)              # 반열림 [lo, hi)
    while lo < hi:
        mid = (lo + hi) // 2
        if nums[mid] >= num: hi = mid  # T: 후보 유지
        else:                lo = mid + 1
    return lo+1 if lo < len(nums) and nums[lo] == num else -1
    
for i in range(m):
    num = int(input())
    result = bsearch(nums,num)
    print(result)