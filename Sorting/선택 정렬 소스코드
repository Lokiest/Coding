lst = [7,5,9,0,3,1,6,2,4,8]

for i in range(len(lst)):
    min_index = i
    for j in range(i+1, len(lst)):
        if lst[min_index] > lst[j]:
            min_index = j
    lst[i], lst[min_index] = lst[min_index], lst[i]  #스왑

print(lst)
