n = int(input())
lst = list(map(int, input().split()))

lst_sorted = sorted(list(set(lst)))
dict = {lst_sorted[i] : i for i in range(len(lst_sorted))}

for i in lst:
    print(dict[i], end = ' ')
