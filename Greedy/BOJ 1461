n, m = map(int, input().split())
lst = list(map(int, input().split()))
max_value = 0 

plus = []
minus = []
for i in lst:
    if i > 0:
        plus.append(i)
    else:
        minus.append(i)
        
    if abs(i) > abs(max_value):
        max_value = i
        
plus.sort(reverse = True)
minus.sort()

distance = []
for i in range(0, len(plus), m):
    if plus[i] != max_value:
        distance.append(plus[i])
for i in range(0, len(minus), m):
    if minus[i] != max_value:
        distance.append(minus[i])
        
answer = abs(max_value)
for i in distance:
    answer += abs(i * 2)

print(answer)
