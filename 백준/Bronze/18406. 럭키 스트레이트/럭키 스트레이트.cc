#include <bits/stdc++.h>

using namespace std;

string S;
int A = 0;
int B = 0;

int main() {
    cin >> S;

    int size = S.length() / 2;

    for(int i = 0; i < size; i++) {
        A += stoi(to_string(S[i]));
    }

    for(int j = size; j < S.length(); j++) {
        B += stoi(to_string(S[j]));
    }

    if(A == B) {
        cout << "LUCKY" << "\n";
    }
    else {
        cout << "READY" << "\n";
    }

    return 0;
}