s = input().upper()
alpha = list(set(s))

cnt = []

for i in alpha:
    cnt.append(s.count(i))

if cnt.count(max(cnt)) > 1:
    print("?")
else:
    idx = cnt.index(max(cnt))
    print(alpha[idx])