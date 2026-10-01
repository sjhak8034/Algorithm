
#include <bits/stdc++.h>
using namespace std;

int K, M;
string s;

// g: 같은 길이-d 접두사를 공유하는 시작 위치들
// 반환: 이 가지에서 깊이 K까지 M개 이상 살아남는가
bool rec(const vector<int>& g, int d) {
    if (d == K) return true;              // 길이 K 패턴을 M개가 공유
    vector<int> zero, one;
    for (int i : g) (s[i+d] == '0' ? zero : one).push_back(i);
    if ((int)zero.size() >= M && rec(zero, d+1)) return true;
    if ((int)one.size()  >= M && rec(one,  d+1)) return true;
    return false;
}

int main() {
    cin >> s >> K >> M;
    int n = s.size();
    vector<int> all;
    for (int i = 0; i + K <= n; i++) all.push_back(i);
    if ((int)all.size() < M) { cout << 0; return 0; }
    cout << (rec(all, 0) ? 1 : 0);
}