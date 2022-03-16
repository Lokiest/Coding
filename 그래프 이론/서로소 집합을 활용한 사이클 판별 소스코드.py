def find_parent(parent, x): #특정 원소가 속한 집합 찾기
    if parent[x] != x: #루트 노드가 아니라면 루트 노드 찾을 때까지 재귀 호출
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b): #두 원소가 속한 집합 합치기
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split()) #노드 개수와 간선 개수
parent = [0] * (v + 1) #부모 테이블 초기화

for i in range(1, v + 1): #부모 테이블에서 부모를 자기 자신으로 초기화
    parent[i] = i

cycle = False #싸이클 발생 여부

for i in range(e):
    a, b = map(int, input().split())

    if find_parent(parent, a) == find_parent(parent, b): 
        cycle = True
        break #싸이클 발생 시 종료
    else: #싸이클 발생하지 않았을 시 합집합 수행
        union_parent(parent, a, b)

if cycle:
    print('Cycle on')
else:
    print('Cycle off')
