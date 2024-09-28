#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N;
int dp[41][3];

int main() {
    cin >> N;

    

    dp[1][1] = 1;
    dp[1][2] = 2;
    dp[2][1] = 2;
    dp[2][2] = 3;

    for(int i = 3; i <= N; i++) {
        dp[i][1] = dp[i-1][2];
        dp[i][2] = dp[i-1][1] + dp[i-1][2];
    }

    cout << dp[N][1] << "\n";

    return 0;
}