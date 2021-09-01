lst = [5,7,9,0,3,1,6,2,4,8]

def quick(lst):
    if len(lst) <= 1:
        return lst

    pivot = lst[0]
    tail = lst[1:]

    left = [x for x in tail if x <= pivot]
    right = [x for x in tail if x > pivot]

    return quick(left) + [pivot] + quick(right)

print(quick(lst))
