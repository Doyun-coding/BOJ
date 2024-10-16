#include <bits/stdc++.h>

using namespace std;

string ans = "";

int main() {
    string S;

    getline(cin, S);

    ans = S[0];

    for(int i = 1; i < S.size(); i++) {
        if(S[i] == '-') {
            ans += S[i+1];
        } 
    }

    cout << ans << "\n";

    return 0;
}