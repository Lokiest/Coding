lst = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
# 실제로는 데이터의 개수 N에 4를 곱한 크기만큼 미리 세그먼트 트리의 공간을 할당한다.
Seg_tree = [0] * (len(lst) * 4)


# <세그먼트 트리를 배열의 각 구간 합으로 채워주기>

def Seg(start, end, index): # index : 세그먼트 트리의 인덱스 (무조건 1부터 시작)
    # 가장 끝에 도착하면 lst 삽입
    if start == end:
        Seg_tree[index] = lst[start]
        return Seg_tree[index]
    mid = (start + end) // 2
    # 좌측 노드와 우측 노드를 채워주면서 부모 노드의 값도 채워주기
    Seg_tree[index] = Seg(start, mid, index * 2) + Seg(mid + 1, end, index * 2 + 1)
    return Seg_tree[index]


# <구간 합을 구하는 함수>
# left, right : 구간 합을 구하고자 하는 범위

def interval_sum(start, end, index, left, right):
    # 범위 밖에 있는 경우
    if left > end or right < start:
        return 0
    # 범위 안에 있는 경우
    if left <= start and right >= end:
        return Seg_tree[index]
    # 그렇지않다면 두 부분으로 나누어 합을 구하기
    mid = (start + end) // 2
    # start와 end가 변하면서 구간 합인 부분을 더해준다고 생각
    return interval_sum(start, mid, index * 2, left, right) + interval_sum(mid + 1, end, index * 2 + 1, left, right)


# <특정 원소의 값을 수정하는 함수>

# what : 구간 합을 수정하고자 하는 노드
# value : 수정할 값
def update(start, end, index, what, value):
    # 범위 밖에 있는 경우
    if what < start or what > end:
        return
    # 범위 안에 있으면 내려가면서 다른 원소도 갱신
    Seg_tree[index] += value
    if start == end:
        return
    mid = (start + end) // 2
    update(start, mid, index * 2, what, value)
    update(mid + 1, end, index * 2 + 1, what, value)


Seg(0, len(lst) - 1, 1)
print(interval_sum(0, len(lst) - 1, 1, 0, 9))  # 0부터 9까지의 구간 합
print(interval_sum(0, len(lst) - 1, 1, 0, 2))  # 0부터 2까지의 구간 합
print(interval_sum(0, len(lst) - 1, 1, 6, 7))  # 0부터 2까지의 구간 합

# lst[0]을 +4만큼 수정
update(0, len(lst) - 1, 1, 0, 4)
print(interval_sum(0, len(lst) - 1, 1, 0, 2))   # 0부터 2까지의 구간 합

# lst[9]를 -11만큼 수정
update(0, len(lst) - 1, 1, 9, -11)
print(interval_sum(0, len(lst) - 1, 1, 8, 9))   # 8부터 9까지의 구간 합
