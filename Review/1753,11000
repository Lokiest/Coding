#1753
import heapq
import sys
input = sys.stdin.readline

v, e = map(int, input().split())
k = int(input())
lst = [[] for _ in range(v + 1)]
heap = []
INF = int(1e9)
dp = [INF] * (v + 1)
for i in range(e):
    u, v, w = map(int, input().split())
    lst[u].append((w, v))


def Dijk(start):
    dp[start] = 0
    heapq.heappush(heap, (0, start))

    while len(heap) > 0:
        weight, now = heapq.heappop(heap)

        if dp[now] < weight:
            continue

        for w, next_node in lst[now]:
            next_wight = w + weight

            if next_wight < dp[next_node]:
                dp[next_node] = next_wight
                heapq.heappush(heap, (next_wight, next_node))

Dijk(k)
for i in dp[1:]:
    if i == INF:
        print('INF')
    else:
        print(i)
        
        
#11000
import sys
import heapq
input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    start, end = map(int, input().split())
    lst.append((start, end))

lst.sort()
room = []
heapq.heappush(room, lst[0][1])

for i in range(1, n):
    if lst[i][0] < room[0]:
        heapq.heappush(room, lst[i][1])

    else:
        heapq.heappop(room)
        heapq.heappush(room, lst[i][1])

print(len(room))
