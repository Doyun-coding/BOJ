#include <iostream>
#include <vector>

using namespace std;

vector< vector<int> > arr;
vector< vector<int> > arr1;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;
    arr.resize(N+1, vector<int>(M+1));
    arr1.resize(N+1, vector<int>(M+1));

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            cin >> arr[i][j];
        }
    }

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            cin >> arr1[i][j];
        }
    }

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            int sum = arr[i][j] + arr1[i][j];
            cout << sum << " ";
        }
        cout << "\n";
    }

    return 0;
}