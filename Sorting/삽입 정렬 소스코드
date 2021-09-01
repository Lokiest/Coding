lst = [7,5,9,0,3,1,6,2,4,8]

for i in range(1, len(lst)):
    for j in range(i,0,-1):
        if lst[j] < lst[j - 1]: #왼쪽으로 한칸씩 이동
            lst[j], lst[j-1] = lst[j-1], lst[j]
        else: #같거나 작은 값 만나면 break
            break

print(lst)
