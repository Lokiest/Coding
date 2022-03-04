import heapq

n = int(input())
lst = []
for i in range(n):
    lst.append(list(map(int, input().split())))
    
lst.sort(key = lambda x : x[1])
S = []

for i in lst:
    heapq.heappush(S, i[0])
    if len(S) > i[1]:
        heapq.heappop(S)
print(sum(S))
