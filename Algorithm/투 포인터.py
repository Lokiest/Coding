n = 5 #데이터 개수
m = 5 #찾고자 하는 부분합
lst = [1, 2, 3, 2, 5]

count = 0
interval_sum = 0
end = 0

for start in range(n): #start 하나씩 돌면서
    while interval_sum < m and end < n: #end 가능한만큼 이동시키기
        interval_sum += lst[end]
        end += 1
    #부분합이 m이 되었을 경우 카운트 += 1
    if interval_sum == m:
        count += 1
    interval_sum -= lst[start]

print(count)
