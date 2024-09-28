#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int N;
int arr[51][51];
int m = 100001;
int X = 0;
int Y = 0;
int cnt = 0;

int main() {
    cin >> N;

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            int n;
            cin >> n;
            arr[i][j] = n;

            if(arr[i][j] < m) {
                X = i;
                Y = j;
                m = arr[i][j];
            }
        }
    }

    if(X == 1 && Y == 1) cnt = 0;
    else if(X == N && Y == 1) cnt = 3;
    else if(X == N && Y == N) cnt = 2;
    else if(X == 1 && Y == N) cnt = 1;

    cout << cnt << "\n";

    return 0;
}