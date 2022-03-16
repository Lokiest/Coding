n = int(input())

lst = []
for i in range(n):
    lst.append(int(input()))

lst = sorted(lst, reverse=True)

for i in lst:
    print(i, end=' ')
