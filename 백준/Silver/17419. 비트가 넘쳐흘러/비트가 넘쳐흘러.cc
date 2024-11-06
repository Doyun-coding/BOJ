#include <bits/stdc++.h>

using namespace std;

int N;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;

    string S;
    cin >> S;

    int cnt = 0;
    for(int i = 0; i < S.length(); i++) {
        if(S[i] == '1') {
            cnt++;
        }
    }

    cout << cnt << "\n";

    return 0;
}