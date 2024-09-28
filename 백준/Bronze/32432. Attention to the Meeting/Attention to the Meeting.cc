#include <iostream>
#include <algorithm>

using namespace std;

int N, K;

int main() {
    cin >> N;
    cin >> K;

    K -= N-1;

    int n = K / N;

    cout << n << "\n";

    return 0;
}