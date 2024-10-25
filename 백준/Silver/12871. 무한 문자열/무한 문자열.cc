#include <bits/stdc++.h>

using namespace std;

string A, B;
int a, b;
string S1 = "", S2 = "";
bool check = true;

int main() {
    cin >> A;
    cin >> B;

    S1 = A;
    S2 = B;

    while(true) {
        a = S1.size();
        b = S2.size();

        if(a == b) break;

        if(a > b) {
            S2 += B;
        }
        else {
            S1 += A;
        }
    }

    for(int i = 0; i < S1.length(); i++) {
        if(S1[i] != S2[i]) {
            check = false;
            break;
        }
    }

    if(check) {
        cout << "1\n";
    }
    else {
        cout << "0\n";
    }

    return 0;
}