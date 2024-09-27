#include <iostream>
#include <algorithm>
#include <cstring>
#include <set>

using namespace std;

int N;
int cnt = 0;

int main() {
    cin >> N;

    for(int i = 1; i <= N; i++) {
        string s;
        cin >> s;

        set<char> hashSet;
        char pre = '\0';
        bool check = true;
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == pre) {
                continue;
            }

            if(hashSet.find(s[i]) != hashSet.end()) {
                check = false;
                break;
            }
            else {
                hashSet.insert(s[i]);
                pre = s[i];
            }
        }

        if(check) {
            cnt++;
        }
    }

    cout << cnt << "\n";

    return 0;
}