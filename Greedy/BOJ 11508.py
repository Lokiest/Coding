n = int(input())
m = []

for i in range(n):
    m.append(int(input()))
    
m.sort(reverse = True)    
count = 0    
for i in range(n):
    if i % 3 != 2:
        count += m[i]
print(count)
