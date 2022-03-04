n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

result = 0
while len(a) != 0:
    result += min(a) * max(b)
    a.pop(a.index(min(a)))
    b.pop(b.index(max(b)))

print(result)
