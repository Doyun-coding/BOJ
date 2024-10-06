#include <bits/stdc++.h>

using namespace std;

int X;
int cnt = 0;
int now = 64;
int cut = 64;

int main() {
    cin >> X;
    
    if(X == 64) {
        cnt = 1;
    }
    else {
        while(true) {
            cut = cut / 2;

            if(now - cut == X) {
                cnt++;
                break;
            }
            else if(now - cut > X) {
                now -= cut;
            }
            else {
                cnt++;
            }
        }
    }

    cout << cnt << "\n";

    return 0;
}