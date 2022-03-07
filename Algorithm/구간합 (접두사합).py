#쿼리가 하나의 경우
n = 5
lst = [10, 20, 30, 40, 50]

#접두사 합 배열 계산
sum_value = 0
prefix_sum = [0]
for i in lst:
    sum_value += i
    prefix_sum.append(sum_value)

#3~4의 구간 합
left = 3
right = 4
print(prefix_sum[right] - prefix_sum[left - 1])
