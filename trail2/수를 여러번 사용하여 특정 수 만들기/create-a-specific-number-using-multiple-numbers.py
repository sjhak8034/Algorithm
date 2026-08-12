a, b, c = map(int,input().split())

a_count = int(c/a)
b_count = int(c/b)


answer = 0;

for i in range(a_count+1):
    for j in range(b_count+1):
        if a * i + b * j <= c:
            answer = max(answer,a * i + b * j)

print(answer)