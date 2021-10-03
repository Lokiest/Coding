n, m = map(int, input().split())
lst = list(map(int, input().split()))

array = [0] * 10 #1부터 10까지 무게 담아둘 리스트
for i in lst:
    array[i] += 1 #각 무게 해당하는 볼링공 개수

result = 0
for i in range(1, m + 1):
    n -= array[i] #무게 i인 볼링공의 개수 제외
    result += array[i] * n #B가 선택하는 경우의 수 곱해주기

print(result)
