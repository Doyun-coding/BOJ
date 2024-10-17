#include <bits/stdc++.h>

using namespace std;

string S;
set<string> hashSet;

int main() {
    cin >> S;

    
    for(int i = 0; i < S.size(); i++) {
        string s = "";
        for(int j = i; j < S.size(); j++) {
            s += S[j];

            hashSet.insert(s);
        }
    }

    cout << hashSet.size() << "\n";

    return 0;
}