#PyPy3 제출
#Python 제출시 sys 사용

from collections import deque

n, m = map(int, input().split())
lst = list(map(int, input().split())) 
que = deque([i for i in range(1, n + 1)]) #앞 뒤로 append, pop 가능한 deque 설정
count = 0

for i in lst: #lst안의 값들 하나하나 빼내야하므로 돌려주면서
    while True: #값 뺄때까지 못나가는 루프
        if que[0] == i: #lst안의 값과 que[0] 값 같다면 popleft (가장 왼쪽에 있을테니)
            que.popleft()
            break

        else:
            if que.index(i) < len(que) / 2: #que의 인덱스 확인하고 que의 중간보다 왼쪽에 존재 시
                while que[0] != i:
                    que.append(que.popleft()) #왼쪽으로 돌고 있으므로 왼쪽에서 빼주고 오른쪽으로 붙이기
                    count += 1

            else: #que의 중간보다 오른쪽에 존재 시
                while que[0] != i:
                    que.appendleft(que.pop()) #오른쪽으로 돌고 있으므로 오른쪽에서 빼주고 왼쪽으로 붙이기
                    count += 1

print(count)
