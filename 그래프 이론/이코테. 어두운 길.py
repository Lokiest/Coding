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

edges = [] #간선 담을 리스트
result = 0 #최종 비용 담을 변수

for i in range(1, n + 1):
    parent[i] = i

for _ in range(m):
    x, y, z = map(int, input().split())
    edges.append((z, x, y)) #비용 기준으로 append

edges.sort() #비용순으로 정렬
total = 0 #전체 가로등 비용

for edge in edges: #간선 하나씩 돌면서
    cost, a, b = edge
    total += cost

    if find_parent(parent, a) != find_parent(parent, b): #싸이클 발생하지 않는 경우 집합에 포함
        union_parent(parent, a, b)
        result += cost

print(total - result)
