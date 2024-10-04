#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int N;
int m;
int n;
int c = 1;
int pre = 1;

int main() {
    cin >> N;

    m = N * (N-1) / 2;

    cout << m << "\n";
    
    cout << "1 ";
    int mul = 2;
    int now = 1;
    for(int i = 1; i < N; i++) {
        now *= mul;
        cout << now << " ";
    }

    cout << "\n";

    cout << N-1 << "\n";

    for(int i = 1; i <= N; i++) {
        cout << i << " ";
    }
    cout << "\n";

    return 0;
}