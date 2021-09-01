def binary_search(lst, target, start, end):
    if start > end:
        return None

    mid = (start + end) // 2

    if lst[mid] == target:
        return mid

    elif lst[mid] > target:
        return binary_search(lst, target, start, mid - 1)

    else:
        return binary_search(lst, target, mid + 1, end)

n, target = list(map(int, input().split()))
lst = list(map(int, input().split()))

result = binary_search(lst, target, 0, n - 1)
if result == None:
    print('원소 없음')
else:
    print(result + 1)
