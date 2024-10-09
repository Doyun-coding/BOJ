#include <bits/stdc++.h>

using namespace std;

int N, M, K;
int arr1[101][101];
int arr2[101][101];

int main() {
    cin >> N >> M;

    // arr1.resize(N+1, vector<int>(M+1));
    // arr2.resize(M+1, vector<int>(K+1));

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            int n;
            cin >> n;

            arr1[i][j] = n;
        }
    }

    cin >> M >> K;

    for(int i = 1; i <= M; i++) {
        for(int j = 1; j <= K; j++) {
            int n;
            cin >> n;

            arr2[i][j] = n;
        }
    }

    for(int k = 1; k <= N; k++) {
        for(int i = 1; i <= K; i++) {
            int sum = 0;
            for(int j = 1; j <= M; j++) {
                sum += arr1[k][j] * arr2[j][i];
            }
            cout << sum << " ";
        }
        cout << "\n";
    }

    return 0;
}