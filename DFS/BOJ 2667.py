n = int(input())

graph = []
count = 0

for _ in range(n):
    graph.append(list(map(int,input())))

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def dfs(x,y):
    global count
    if 0 <= x < n and 0 <= y < n and graph[x][y] == 1:
        count += 1
        graph[x][y] = 0

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)
        return True
    return False

s = []
count = 0
result = 0

for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            s.append(count)
            result += 1
            count = 0

s.sort()
print(result)
for i in range(len(s)):
    print(s[i])
