n = int(input())
lst = list(map(int, input().split()))
Sum = [lst[0]]

for i in range(len(lst) - 1):
    Sum.append(max(lst[i + 1], lst[i + 1] + Sum[i]))

print(max(Sum))
