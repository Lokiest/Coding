def find_parent(parent, x): #특정 원소가 속한 집합 찾기
    if parent[x] != x: #루트 노드가 아니라면 루트 노드 찾을 때까지 재귀 호출
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b): #두 원소가 속한 집합 합치기
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split()) #노드 개수와 간선 개수
parent = [0] * (v + 1) #부모 테이블 초기화

edges = [] #모든 간선을 담을 리스트와 최종 비용을 담을 변수 설정
result = 0

for i in range(1, v + 1): #부모 테이블에서 부모를 자기 자신으로 초기화
    parent[i] = i

for _ in range(e): #간선에 대한 정보 받기
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort() #비용순으로 정렬

for edge in edges: #간선 하나씩 돌면서 싸이클이 발생하지 않는 경우만 집합에 포함시키기
    cost, a, b = edge

    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)
