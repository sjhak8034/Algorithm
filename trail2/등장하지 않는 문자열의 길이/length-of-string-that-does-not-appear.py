N = int(input())
str = input()



for i in range(N):
    data = set()
    success = 1
    for j in range(N-i):
        if str[j:j+i+1] in data:
            success = 0
            break
        data.add(str[j:j+i+1])
    if success == 1:
        print(i+1)
        break
# Please write your code here.