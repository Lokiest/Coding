x, y = map(int ,input().split())
win_z = (y * 100) // x
ans = int(2e9)
left, right = 1, x

while left <= right:
    mid = (left + right) // 2
    cur_win = (y + mid) * 100 // (x + mid)

    if cur_win > win_z:
        ans = min(mid, ans)
        right = mid - 1
    else:
        left = mid + 1

if ans == int(2e9):
    print(-1)
else:
    print(ans)
