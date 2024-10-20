#include <bits/stdc++.h>

using namespace std;

string S;
stack<char> s;

int main() {
    getline(cin, S);

    for(int i = 0; i < S.length(); i++) {
        if(S[i] == '<') {
            while(!s.empty()) {
                char ans = s.top();
                s.pop();

                cout << ans << "";
            }

            cout << "<";

            for(int j = i+1; j < S.length(); j++) {
                if(S[j] == '>') {
                    i = j;
                    cout << ">";
                    break;
                }
                cout << S[j];
            }
        }
        else if(S[i] == ' ') {
            while(!s.empty()) {
                char ans = s.top();
                s.pop();

                cout << ans << "";
            }
            cout << " ";
        }
        else {
            s.push(S[i]);
        }
    }

    while(!s.empty()) {
        char ans = s.top();
        s.pop();

        cout << ans << "";
    }
    cout << "\n";

    return 0;
}