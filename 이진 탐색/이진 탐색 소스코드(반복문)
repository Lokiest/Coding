def binary_search(lst, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if lst[mid] == target:
            return mid

        elif lst[mid] > target:
            end = mid - 1

        else:
            start = mid + 1

    return None

n, target = list(map(int, input().split()))
lst = list(map(int, input().split()))

result = binary_search(lst, target, 0, n - 1)
if result == None:
    print('원소 없음')
else:
    print(result + 1)
