def sequentail_search(n, target, lst):
    for i in range(n):
        if lst[i] == target:
            return i + 1

print("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하시오")
data = input().split()
n = int(data[0])
target = data[1]

print("앞서 적은 원소 개수만크 문자열을 입력하시오. 구분은 띄어쓰기 한 칸으로")
lst = input().split()

print(sequentail_search(n, target, lst))
