#include <bits/stdc++.h>

using namespace std;

vector<int> arr;
vector<int> chess;

int main() {
    chess.resize(7);

    int a, b, c, d, e, f;
    cin >> a >> b >> c >> d >> e >> f;
    chess[1] = a;
    chess[2] = b;
    chess[3] = c;
    chess[4] = d;
    chess[5] = e;
    chess[6] = f;

    arr.resize(7);
    arr[1] = 1;
    arr[2] = 1;
    arr[3] = 2;
    arr[4] = 2;
    arr[5] = 2;
    arr[6] = 8;

    for(int i = 1; i <= 6; i++) {
        cout << arr[i] - chess[i] << " ";
    }
    cout << "\n";

    return 0;
}