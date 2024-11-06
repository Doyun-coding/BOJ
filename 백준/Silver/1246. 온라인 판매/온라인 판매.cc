#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<int> arr;
int maxValue = 0;
int sumValue = 0;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;

    arr.resize(M);
    for(int i = 0; i < M; i++) {
        int n;
        cin >> n;

        arr[i] = n;
    }
    
    int count = min(N, M);

    sort(arr.begin(), arr.end());

    int start = 0;
    if(M > N) {
        start = M-N;
    }

    for(int i = start; i < M; i++) {
        int n = arr[i] * count;
        if(n > sumValue) {
            sumValue = n;
            maxValue = arr[i];
        }
        count--;
    }

    cout << maxValue << " " << sumValue << "\n";

    return 0;
}