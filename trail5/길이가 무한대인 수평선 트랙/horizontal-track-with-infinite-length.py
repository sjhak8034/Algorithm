from sortedcontainers import SortedSet
n, t = map(int, input().split())
start = []
speed = []

ss1 = SortedSet(key=lambda p: p[0]) 
ss2 = SortedSet()
ss3 = SortedSet()
deleteSS = SortedSet()
for _ in range(n):
    s, v = map(int, input().split())
    start.append(s)
    speed.append(v)
    
for i in range(n):
    ss1.add((start[i],speed[i]))
for i in range(1,n):
    if (ss1[i-1][1] - ss1[i][1]) <= 0:
        time = 10000000000
    else:
        dist = ss1[i][0] - ss1[i-1][0]
        diff = ss1[i-1][1] - ss1[i][1]
        time = -(-dist // diff)          # 올림 나눗셈으로 수정

    ss2.add((time,ss1[i-1][0],ss1[i][0]))
current_t = 0
while ss2:
    current_t = ss2[0][0]
    deleteI = ss2[0][1]
    deleteI2 = ss2[0][2]
    if current_t > t:
        break
    ss2.pop(0)
    if deleteI in deleteSS or deleteI2 in deleteSS:
        continue
    idx = ss1.bisect_key_left(deleteI)
    ss1.pop(idx)
  
    if 0 <= idx < len(ss1) and 0 <= idx-1 < len(ss1):
        if (ss1[idx-1][1] - ss1[idx][1]) <= 0:
            time = 10000000000
        else:
            dist = ss1[idx][0] - ss1[idx-1][0]
            diff = ss1[idx-1][1] - ss1[idx][1]
            time = -(-dist // diff)      # 올림 나눗셈으로 수정
        ss2.add((time,ss1[idx-1][0],ss1[idx][0]))
    deleteSS.add(deleteI)



print(len(ss1))