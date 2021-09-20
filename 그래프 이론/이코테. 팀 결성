def find_parent(parent, x):  # 특정 원소가 속한 집합 찾기
    if parent[x] != x:  # 루트 노드가 아니라면 루트 노드 찾을 때까지 재귀 호출
        return find_parent(parent, parent[x])
    return x


def union_parent(parent, a, b):  # 두 원소가 속한 집합 합치기
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n, m = map(int, input().split())  # 노드 개수와 간선 개수
parent = [0] * (n + 1)  # 부모 테이블 초기화

for i in range(1, n + 1):  # 부모 테이블에서 부모를 자기 자신으로 초기화
    parent[i] = i

for i in range(m):
    oper, a, b = map(int, input().split())

    if oper == 0:
        union_parent(parent, a, b)

    elif oper == 1:
        if find_parent(parent, a) == find_parent(parent, b):
            print('YES')
        else:
            print('NO')
