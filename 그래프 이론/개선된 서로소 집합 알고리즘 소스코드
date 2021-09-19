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

for i in range(1, v + 1): #부모 테이블에서 부모를 자기 자신으로 초기화
    parent[i] = i

for i in range(e): #union연산 각각 수행
    a, b = map(int, input().split())
    union_parent(parent, a, b)

print('각 원소가 속한 집합 : ', end='')
for i in range(1, v + 1):
    print(find_parent(parent, i), end=' ')
print()

print('부모 테이블 : ', end='')
for i in range(1, v + 1):
    print(parent[i], end=' ')
    
# find 함수가 비효율적으로 동작, 최악의 경우 모든 노드를 확인해야
