def bsearch(nums,target):
    lo = 0
    hi = len(nums)
    while(lo < hi):
        mid = int((hi - lo)/2 + lo) 
        if nums[mid] >= target:
            hi = mid
        else:
            lo = mid+1
    result = 0
    left = lo-1
    right = lo+1

    size = len(nums)

    if lo < size and nums[lo] == target:
        result +=1


    while(left >= 0  and nums[left] == target):
        
        if nums[left] == target:
            result+=1

        left = left-1

    
    

    
    while(right < size  and nums[right] == target):
        if nums[right] == target:
            result+=1

        right = right + 1

        
    
    return result

n, m = map(int, input().split())

nums = list(map(int, input().split()))

for i in range(m):
    target = int(input())
    result = bsearch(nums,target)
    print(result)