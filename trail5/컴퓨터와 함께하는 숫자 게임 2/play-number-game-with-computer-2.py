m = int(input())
a, b = map(int,input().split())

maxResult = 0
minResult = 100000000

def bsearch(m, target):
    low = 1
    high = m 
    count = 0
    while True:
        count +=1
        mid = (low + high)//2

        if mid > target:
            high = mid - 1
        elif mid == target:
            return count
        else:
            low = mid + 1
    return count
for i in range(a,b+1):
    result = bsearch(m,i)

    maxResult = max(result,maxResult)
    minResult = min(result,minResult)

print(minResult, maxResult)