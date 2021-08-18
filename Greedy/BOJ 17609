def second(word, left, right):
    while left < right:
        if word[left] == word[right]:
            left += 1
            right -= 1
        else:
            return False
    return True

def first(word, left, right):
    while left < right:
        if word[left] == word[right]:
            left += 1
            right -= 1
        else:
            S1 = second(word, left + 1, right)
            S2 = second(word, left, right - 1)
            if S1 == True or S2 == True:
                return 1
            else:
                return 2
    return 0

T = int(input())
for i in range(T):
    word = list(input())
    left = 0
    right = len(word) - 1
    ans = first(word,left,right)
    print(ans)
