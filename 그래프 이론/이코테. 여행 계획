def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())
parent = [0] * (n + 1)

for i in range(1, n + 1):
    parent[i] = i

for i in range(n): #union 연산 각각 수행
    lst = list(map(int, input().split()))
    for j in range(n):
        if lst[j] == 1: #연결된 경우 union 연산 수행
            union_parent(parent, i + 1, j + 1)

plan = list(map(int, input().split()))

result = True
for i in range(m - 1): #여행 계획에 속하는 모든 노드의 루트가 동일한지 확인하기
    if find_parent(parent, plan[i]) != find_parent(parent, plan[i + 1]):
        result = False

if result: #여행 계획에 속한 모든 노드가 서로 연결되어있는지 확인
    print('YES')
else:
    print('NO')
