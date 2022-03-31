n = int(input())
lst = list(map(int, input().split()))
lst.sort() #이진탐색을 위한 정렬

m = int(input())
lst2 = list(map(int, input().split()))

def search(lst, t, start, end):

    while start <= end:
        mid = (start + end) // 2

        if lst[mid] == t:
            return mid

        if t < lst[mid]:
            end = mid - 1

        else:
            start = mid + 1

    return None

for i in lst2:
    result = search(lst, i, 0, n-1)

    if result != None:
        print(1)
    else:
        print(0)
