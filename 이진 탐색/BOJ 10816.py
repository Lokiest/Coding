from bisect import bisect_left, bisect_right

n = int(input())
lst = list(map(int, input().split()))
lst.sort()

m = int(input())
lst2 = list(map(int, input().split()))

def count_by_range(t, left, right):
    left_index = bisect_left(t, left)
    right_index = bisect_right(t, right)

    return right_index - left_index

for i in range(m):
    print(count_by_range(lst, lst2[i], lst2[i]), end=' ')
