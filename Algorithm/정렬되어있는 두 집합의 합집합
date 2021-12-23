n, m = 3, 4
a = [1, 3, 5]
b = [2, 4, 6, 8]

result = [0] * (n + m)
i, j, k = 0, 0, 0

#모든 원소가 result에 담길 때까지 반복
while i < n or j < m:
    # b의 모든 원소가 담겼거나, a의 원소가 더 작을때
    if j >= m or (i < n and a[i] <= b[j]):
        result[k] = a[i]
        i += 1

    else:
        #b의 원소를 결과 리스트로
        result[k] = b[j]
        j += 1
    k += 1

for i in result:
    print(i, end = ' ')
