import sys, heapq

def main():
    data = sys.stdin.read().split()
    i = 0
    L = int(data[i]); i += 1
    Q = int(data[i]); i += 1

    pending = {}   # name -> [(놓인시각, 놓인위치)]  아직 주인이 안 온 초밥
    person  = {}   # name -> [자리위치, 남은개수]
    heap    = []   # (먹는시각, name)
    people_cnt = 0
    sushi_cnt  = 0
    out = []

    for _ in range(Q):
        cmd = int(data[i]); i += 1
        t   = int(data[i]); i += 1

        if cmd == 100:
            x = int(data[i]); i += 1
            name = data[i]; i += 1
            sushi_cnt += 1
            if name in person:
                p = person[name][0]
                heapq.heappush(heap, (t + (p - x) % L, name))
            else:
                pending.setdefault(name, []).append((t, x))

        elif cmd == 200:
            x = int(data[i]); i += 1
            name = data[i]; i += 1
            n = int(data[i]); i += 1
            person[name] = [x, n]
            people_cnt += 1
            for ts, sx in pending.pop(name, ()):
                cur = (sx + t - ts) % L          # 지금 이 초밥이 있는 위치
                heapq.heappush(heap, (t + (x - cur) % L, name))

        while heap and heap[0][0] <= t:          # 시각 t까지 도달한 초밥 먹기
            _, name = heapq.heappop(heap)
            info = person.get(name)
            if info is None:
                continue
            sushi_cnt -= 1
            info[1] -= 1
            if info[1] == 0:
                del person[name]
                people_cnt -= 1

        if cmd == 300:
            out.append(f"{people_cnt} {sushi_cnt}")

    print("\n".join(out))

main()