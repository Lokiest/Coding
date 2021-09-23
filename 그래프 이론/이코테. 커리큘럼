from collections import deque
import copy

v = int(input())
indegree = [0] * (v + 1) #모든 노드 진입차수 0으로 초기화
G = [[] for i in range(v + 1)]
time = [0] * (v + 1) #각 강의시간 0으로 초기화

for i in range(1, v + 1): #간선 받기
    data = list(map(int, input().split()))
    time[i] = data[0] #첫번째 수는 시간 정보

    for x in data[1:-1]:
        indegree[i] += 1
        G[x].append(i)

def topology_sort(): #위상 정렬 함수
    result = copy.deepcopy(time) #수행 결과 담을 리스트
    que = deque()

    for i in range(1, v + 1): #처음 시작할 땐 진입차수가 0인 노드를 큐에 넣기

    while que: #큐에 원소 있는 동안
        now = que.popleft()

        for i in G[now]: #해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            result[i] = max(result[i], result[now] + time[i])
            indegree[i] -= 1

            if indegree[i] == 0: #새롭게 진입차수가 0 되는 노드 큐에 다시 넣기
                que.append(i)

    for i in range(1, v + 1): #결과 출력
        print(result[i])

topology_sort()
