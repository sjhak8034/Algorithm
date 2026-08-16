n,m = map(int,input().split())

nums = []

for i in range(n):
    nums.append(int(input()))

sum_nums = sum(nums)
max_k = sum_nums//m
min_k = min(nums)//(m//n + m%n)

def getCount(m, n, nums, slice):
    count = 0
    for i in nums:
        count += i // slice
    return count

def bsearch(low, high, m, n, nums):
    count = 0
    while(low < high):
        mid = (low+high)//2
        count = getCount(m,n,nums,mid)
  
        if m > count:
            high = mid
        else:
            low = mid+1
    return low-1 if low >= 1 and  getCount(m,n,nums,low) < m  else low

print(bsearch(min_k,max_k,m,n,nums))

