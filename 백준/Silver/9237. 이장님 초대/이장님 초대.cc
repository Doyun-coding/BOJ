#include <bits/stdc++.h>

using namespace std;

int N;
vector<int> arr;
int today = 1;
int now = 0;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;

    arr.resize(N+1);

    for(int i = 1; i <= N; i++) {
        int n;
        cin >> n;

        arr[i] = n;
    }

    sort(arr.begin()+1, arr.end(), greater<int>());

    
    for(int i = 1; i <= N; i++) {
        today++;
        now--;
        now = max(now, arr[i]);
    }

    today += now;

    cout << today << "\n";

    return 0;
}