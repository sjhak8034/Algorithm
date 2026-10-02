#include <bits/stdc++.h>
using namespace std;

int N, M;
vector<vector<int>> grid;
int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};

vector<array<int, 5>> cells;      // 배치 하나 = 정렬된 칸 인덱스 5개
vector<long long> scores;         // 그 배치의 에너지 합

unordered_set<unsigned long long> seen;   // 중복 배치 제거용 키

int cur[5];                       // DFS 중인 배치
vector<char> inSet;               // 이미 넣은 칸인가
int anchor;
inline bool isInbound(int y, int x) {
    return 0 <= y && y < N && 0 <= x && x < M;
}

void collect(int cnt) {
    if (cnt == 5) {
        array<int, 5> a;
        for (int i = 0; i < 5; i++) a[i] = cur[i];
        sort(a.begin(), a.end());

        // 정렬된 인덱스 5개를 8비트씩 눌러 담아 유일한 키로 만든다 (최대 256칸)
        unsigned long long key = 0;
        for (int i = 0; i < 5; i++) key |= (unsigned long long)a[i] << (8 * i);
        if (!seen.insert(key).second) return;     // 이미 본 배치

        long long s = 0;
        for (int i = 0; i < 5; i++) s += grid[a[i] / M][a[i] % M];
        cells.push_back(a);
        scores.push_back(s);
        return;
    }
    for (int k = 0; k < cnt; k++) {               // 현재 배치의 모든 칸에서
        int y = cur[k] / M, x = cur[k] % M;
        for (int d = 0; d < 4; d++) {             // 이웃으로 한 칸 확장
            int ny = y + dy[d], nx = x + dx[d];
            if (!isInbound(ny, nx)) continue;
            int nid = ny * M + nx;
            if (inSet[nid]) continue;
            if (nid < anchor) continue;  
            inSet[nid] = 1;
            cur[cnt] = nid;
            collect(cnt + 1);
            inSet[nid] = 0;
        }
    }
}

// 정렬된 두 배열의 공통 원소 개수 (3개를 넘으면 바로 중단)
inline int overlap(const array<int, 5>& a, const array<int, 5>& b) {
    int i = 0, j = 0, c = 0;
    while (i < 5 && j < 5) {
        if (a[i] == b[j]) { if (++c > 2) return c; i++; j++; }
        else if (a[i] < b[j]) i++;
        else j++;
    }
    return c;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    grid.assign(N, vector<int>(M));
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++) cin >> grid[i][j];

    // 1단계: 가능한 배치를 전부 한 번만 모은다
    inSet.assign(N * M, 0);
    for (int y = 0; y < N; y++)
        for (int x = 0; x < M; x++) {
            int id = y * M + x;
            anchor = id;              // ← 추가
            inSet[id] = 1; cur[0] = id;
            collect(1);
            inSet[id] = 0;
    }
    int P = cells.size();

    // 2단계: 겹침이 정확히 2인 쌍 중 점수 합이 최대인 것
    // 점수 내림차순으로 보며, 더 볼 필요가 없어지면 끊는다
    vector<int> ord(P);
    for (int i = 0; i < P; i++) ord[i] = i;
    sort(ord.begin(), ord.end(), [](int a, int b) { return scores[a] > scores[b]; });

    bool found = false;
    long long ans = 0;
    for (int a = 0; a + 1 < P; a++) {
        int i = ord[a];
        if (found && scores[i] + scores[ord[a + 1]] <= ans) break;
        for (int b = a + 1; b < P; b++) {
            int j = ord[b];
            if (found && scores[i] + scores[j] <= ans) break;
            if (overlap(cells[i], cells[j]) == 2) {
                ans = scores[i] + scores[j];
                found = true;
            }
        }
    }

    cout << (found ? ans : -1) << "\n";
    return 0;
}