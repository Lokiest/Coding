n = int(input())
lst = []
for i in range(n):
    weight, hight = map(int, input().split())
    lst.append((weight, hight))

for i in lst:
    rank = 1

    for j in lst:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1

    print(rank, end=" ")
