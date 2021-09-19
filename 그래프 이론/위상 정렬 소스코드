from  collections import deque

v, e = map(int, input().split())
indegree = [0] * (v + 1) #모든 노드에 대한 진입차수 0으로 초기화
G = [[] for i in range(v + 1)]

for _ in range(e):
    a, b = map(int, input().split()) #간선 정보 받기
    G[a].append(b) #정점 a에서 b로 이동 가능
    indegree[b] += 1 #진입차수 1 증가

def topology_sort(): #위상 정렬 함수
    result = [] #알고리즘 수행 결과 담을 리스트
    que = deque()

    for i in range(1, v + 1): #진입차수가 0인 노드를 큐에 넣기
        if indegree[i] == 0:
            que.append(i)

    while que: #큐에 원소 존재할 동안
        now = que.popleft() #원소 꺼내기
        result.append(now)

        for i in G[now]: #해당 원소와 연결된 노드들의 진입차수에서 1 빼주기
            indegree[i] -= 1

            if indegree[i] == 0: #새롭게 진입차수가 0이 되는 노드를 큐에 넣기
                que.append(i)

    for i in result:
        print(i, end=' ')

topology_sort()
