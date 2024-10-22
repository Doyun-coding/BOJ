#include <bits/stdc++.h>

using namespace std;

string S;
int num = 1;

int main() {
    cin >> S;

    for(int i = 0; i < S.length(); i++) {
        if(S[i] == ',') num++;
    }

    cout << num << "\n";

    return 0;
}