#include <bits/stdc++.h>

using namespace std;

string S1, S2;
int idx = 0;
int cnt = 0;
bool check = true;

int main() {
    getline(cin, S1);
    getline(cin, S2);

    while(true) {
        if(idx >= S1.size()) break;
        check = true;

        for(int i = idx; i < idx + S2.size(); i++) {
            if(S1[i] != S2[i-idx]) {
                check = false;
                break;
            }
        }

        if(check) {
            cnt++;
            idx += S2.size();
        }
        else {
            idx++;
        }
    }

    cout << cnt << "\n";

    return 0;
}