import math
n = int(input())
lst = list(map(int, input().split(' ')))

lst.sort()

left = 0
right = n - 1

answer = math.inf
final = []

while left < right:
    l_left = lst[left]
    l_right = lst[right]
    total = l_left + l_right

    if abs(total) < answer:
        answer = abs(total)
        final = [l_left, l_right]

    if total < 0:
        left += 1
    else:
        right -= 1

print(final[0], final[1])
