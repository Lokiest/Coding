n, m, k = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()

first = lst[-1] #가장 큰 수
second = lst[-2] #두번째로 큰 수

count = int(m / (k + 1)) * k #가장 큰 수 몇 번 더해지는지
count += m % (k + 1)

result = 0
result += count * first #가장 큰 수 더하기
result += (m - count) * second #나머지는 두번째로 큰 수 더하기

print(result)
