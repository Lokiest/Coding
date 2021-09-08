n = int(input())
book = {}

for _ in range(n):
    a = input().rstrip()

    if a in book:
        book[a] += 1
    else:
        book[a] = 1

orders = []
for a in book:
    orders.append((a, book[a]))

orders = sorted(orders, key=lambda x: (-x[1], x[0]))

print(orders[0][0])
