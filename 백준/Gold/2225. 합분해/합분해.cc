#include <bits/stdc++.h>

using namespace std;

int N, K;
vector<vector<long long> > dp;

int main() {
    cin >> N >> K;

    dp.resize(N+1, vector<long long>(K+1, 1));

    for(int i = 1; i <= K; i++) {
        dp[1][i] = i;
    }

    for(int i = 2; i <= N; i++) {

        dp[i][1] = 1;
        
        for(int j = 2; j <= K; j++) {
            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
        }
    }

    cout << dp[N][K] << "\n";

    return 0;
}