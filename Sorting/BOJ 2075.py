import heapq

n = int(input())

lst = []
for _ in range(n):
    lst.append(list(map(int, input().split())))

heap = []
for i in range(n):
    for j in range(n):
        heapq.heappush(heap, lst[i][j])

        if len(heap) > n:
            heapq.heappop(heap)

print(heap[0])
