#include <bits/stdc++.h>

using namespace std;

int N;
long now = 1;
long long sum = 0;

int main() {
    cin >> N;

    for(int i = 1; i <= N; i*=10) {
        sum += N-i+1;
    }

    cout << sum << "\n";

    return 0;
}