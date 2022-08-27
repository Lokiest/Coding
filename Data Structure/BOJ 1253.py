n = int(input())
lst = list(map(int, input().split()))
lst.sort()
count = 0

for i in range(n):
    temp = lst[:i] + lst[i + 1:]
    left, right = 0, len(temp) - 1

    while left < right:
        total = temp[left] + temp[right]
        if total == lst[i]:
            count += 1
            break

        if total < lst[i]:
            left += 1
        else:
            right -= 1
print(count)
