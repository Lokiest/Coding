#1715
import heapq

n = int(input())
lst = []
for i in range(n):
    heapq.heappush(lst, int(input()))

if len(lst) == 1:
    print(0)

else:
    count = 0

    while len(lst) > 1:
        a = heapq.heappop(lst)
        b = heapq.heappop(lst)

        count += a + b
        heapq.heappush(lst, a + b)

    print(count)
    

#5052
def check():
    for i in range(len(lst) - 1):
        if lst[i] == lst[i + 1][0:len(lst[i])]:
            print('NO')
            return
    return print('YES')

T = int(input())

for _ in range(T):
    n = int(input())
    lst = []

    for i in range(n):
        lst.append(input())

    lst.sort()
    check()
    
