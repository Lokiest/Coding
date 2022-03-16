def find_parent(parent, x):
    if paren[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split())
parent = [0] * (v + 1)

for i in range(1, v + 1):
    parent[i] = i

edges = []
result = 0

for _ in range(e):
    a, b, cost = map(int, input().split()) #간선 정보 받기
    edges.append((cost, a, b)) #cost 기준으로

edges.sort() #cost 기준으로 정렬
last = 0 #최소 신장 트리에 포함되는 간선 중 가장 비용 큰 간선

for edge in edges: #간선 하나씩 돌면서
    cost, a, b = edge

    if find_parent(parent, a) != find_parent(parent, b): #싸이클 발생하지 않을 시 집합에 넣기
        union_parent(parent, a, b)
        result += cost
        last = cost #last 갱신

print(result - last)
