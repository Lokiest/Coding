n, m = map(int, input().split())
knowlst = set(input().split()[1:])
parties = []

for i in range(m):
    parties.append(set(input().split()[1:]))

for i in range(m):
    for people in parties:
        if people & knowlst:
            knowlst = knowlst | people

count = 0
for people in parties:
    if people & knowlst:
        continue
    else:
        count += 1

print(count)
