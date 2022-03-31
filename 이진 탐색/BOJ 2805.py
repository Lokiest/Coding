n, m = map(int, input().split())
lst = list(map(int, input().split()))

start = 1
end = max(lst) #가장 큰 값이 끝 값

while start <= end:
    total = 0 #남은 부분을 담기위한
    mid = (start + end) // 2

    for i in lst:
        if i >= mid:
            total += i - mid #절단기 아래 부분을 제외한 남은 값들

    if total < m:
        end = mid - 1

    else:
        start = mid + 1

print(end)
