#include <bits/stdc++.h>

using namespace std;

int N;
int arr[1001];
int c;
int cnt = 0;

int main() {
    cin >> N;

    for(int i = 1; i <= N; i++) {
        string s;
        int n;
        cin >> s >> n;

        arr[i] = n;

        if(s == "jinju") {
            c = n;
        }
    }

    for(int i = 1; i <= N; i++) {
        if(arr[i] > c) {
            cnt++;
        }
    }

    cout << c << "\n";
    cout << cnt << "\n";

    return 0;
}