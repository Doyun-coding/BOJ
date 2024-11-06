#include <bits/stdc++.h>

using namespace std;

int T;
int N;
string S1, S2;
int W = 0, B = 0;

ostringstream sb;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> T;

    for(int t = 1; t <= T; t++) {
        cin >> N;
        cin >> S1;
        cin >> S2;

        int start = 0;
        int end = 0;
        W = 0;
        B = 0;

        for(int i = 0; i < N; i++) {
            if(S1[i] != S2[i]) {
                start = i;
                break;
            }
        }

        for(int i = N-1; i >= 0; i--) {
            if(S1[i] != S2[i]) {
                end = i;
                break;
            }
        }

        int cnt = 0;
        while(true) {
            if(start > end) break;

            if(S1[start] == S2[start]) {
                start++;
                continue;                     
            }

            if(S1[end] == S2[end]) {
                end--;
                continue;
            }
            
            if(S1[start] != S1[end]) {
                start++;
                end--;
                cnt++;
            }
            else {
                if(S1[start] == 'W') {
                    if(B <= 0) {
                        W++;
                        cnt++;
                    }
                    else {
                        B--;
                    }
                    start++;
                }
                else {
                    if(W <= 0) {
                        B++;
                        cnt++;
                    }
                    else {
                        W--;
                    }
                    start++;
                }
            }   
        }

        sb << cnt << "\n";
    }

    cout << sb.str() << "\n";

    return 0;
}