import math
n = int(input())

def findSequence(remain, result):
    if remain == 0:
        result[0]+=1
    rangeNum = remain + 1 if remain + 1 <= 5 else 5
    for i in range(1,rangeNum):
        findSequence(remain - i, result)
     

result = [0]
findSequence(n,result)
print(result[0])
    