
#include <bits/stdc++.h>
using namespace std;

int main() {
    int K, M;
    string s;
    cin >> s >> K >> M;
    int n = s.size();

    vector<int> all;
    for (int i = 0; i + K <= n; i++) all.push_back(i);   // 끝에서 잘리는 위치 제외

    vector<vector<int>> groups;
    if (!all.empty()) groups.push_back(move(all));

    for (int d = 0; d < K; d++) {
        vector<vector<int>> nxt;
        for (auto& g : groups) {
            vector<int> zero, one;
            for (int i : g) (s[i+d] == '0' ? zero : one).push_back(i);
            if ((int)zero.size() >= M) nxt.push_back(move(zero));
            if ((int)one.size()  >= M) nxt.push_back(move(one));
        }
        groups = move(nxt);
        if (groups.empty()) { cout << 0; return 0; }
    }
    cout << 1;
}