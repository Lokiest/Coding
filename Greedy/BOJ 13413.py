n = int(input())
R = 0
arr = []
F_arr = []

for _ in range(n):
    T = int(input())
    S = list(input())
    E = list(input())

    for j in range(T):
        if S[j] != E[j]:
            arr.append(S[j])

    if arr.count("B") >= arr.count("W"):
        R = arr.count("B")
    else:
        R = arr.count("W")
    F_arr.append(R)
    arr = []

for ans in F_arr:
    print(ans)
