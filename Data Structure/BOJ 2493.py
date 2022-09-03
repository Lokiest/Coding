from collections import deque

n = int(input())
lst = list(map(int, input().split()))
que = deque()
answer = []

for i in range(n):
    while que:
        if (que[-1][0] > lst[i]):
            answer.append(que[-1][1] + 1)
            break
        else:
            que.pop()

    if not que:
        answer.append(0)
    que.append([lst[i], i])

print(*answer)
