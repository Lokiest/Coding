n = int(input())
lst = list(map(int, input().split()))
lst.sort()

count = 0 #현 그룹의 명 수
result = 0 #전체 그룹 수

for i in lst:
    count += 1 #한명씩 늘려가며

    if count == i: #공포도와 명 수가 같아진다면 그룹 생성
        result += 1 #그룹 추가
        count = 0 #현 그룹 초기화

print(result)
