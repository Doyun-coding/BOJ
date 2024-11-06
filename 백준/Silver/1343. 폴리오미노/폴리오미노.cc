#include <bits/stdc++.h>

using namespace std;

string S;
bool check = true;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> S;

    int cnt = 0;
    for(int i = 0; i < S.length(); i++) {
        if(S[i] == '.') {
            if(cnt % 2 != 0) {
                check = false;
                break;
            }
            else {
                if(cnt == 2) {
                    S[i-1] = 'B';
                    S[i-2] = 'B';
                }
            }
            cnt = 0;
        }
        else {
            cnt++;
            if(cnt == 4) {
                for(int j = i; j >= i-3; j--) {
                    S[j] = 'A';
                }
                cnt = 0;
            }
        }
    }

    if(cnt % 2 != 0) {
        check = false;
    }
    else {
        if(cnt == 2) {
            S[S.length()-1] = 'B';
            S[S.length()-2] = 'B';
        }
    }

    if(check) {
        for(int i = 0; i < S.length(); i++) {
            cout << S[i] << "";
        }
        cout << "\n";
    }
    else {
        cout << "-1" << "\n";
    }


    return 0;
}