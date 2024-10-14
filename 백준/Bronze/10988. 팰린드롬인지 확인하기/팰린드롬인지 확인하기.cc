#include <bits/stdc++.h>

using namespace std;

bool check = true;

int main() {
    string s;

    getline(cin, s);

    int l = s.size();

    for(int i = 0; i < l/2; i++) {
        if(s[i] != s[l-1-i]) {
            check = false;
            break;
        }
    }

    if(check) {
        cout << "1" << "\n";
    }
    else {
        cout << "0" << "\n";
    }

    return 0;
}