import sys
import heapq

n = int(sys.stdin.readline())
a = []

for i in range(n):
    S,E = map(int, sys.stdin.readline().split())
    a.append([S,E])
a.sort()
room = []
heapq.heappush(room, a[0][1])
for i in range(1,n):
    if a[i][0] < room[0]:
        heapq.heappush(room,a[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room,a[i][1])
print(len(room))
