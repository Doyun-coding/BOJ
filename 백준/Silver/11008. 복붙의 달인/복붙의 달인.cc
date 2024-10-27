#include <bits/stdc++.h>

using namespace std;

int T;

int main() {
    cin >> T;

    for(int t = 1; t <= T; t++) {
        string s, p;
        cin >> s >> p;

        int cnt = 0;
        int index = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s[i] == p[0]) {
                if(s.length() - i >= p.length()) {
                    bool check = true;
                    for(int j = 1; j < p.length(); j++) {
                        if(s[i+j] != p[j]) {
                            check = false;
                            break;
                        }
                    }
                    if(check) {
                        i += p.length()-1;
                    }
                } 
            }
            cnt++;
        }

        cout << cnt << "\n";
    }
    cout << "\n";

    return 0;
}