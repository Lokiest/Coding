n = int(input())
lst = list(map(int, input().split()))
lst.sort()

m = int(input())
lst2 = list(map(int, input().split()))

def search(lst, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if lst[mid] == target:
            return mid

        elif lst[mid] > target:
            end = mid - 1

        else:
            start = mid + 1

    return None

for i in lst2:
    result = search(lst, i, 0, n - 1)

    if result != None:
        print('yes', end=' ')
    else:
        print('no', end=' ')
