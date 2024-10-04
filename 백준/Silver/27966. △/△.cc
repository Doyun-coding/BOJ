#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>

using namespace std;

long N;

int main() {
    cin >> N;

    long ans = (long) (N-1)*(N-1);

    cout << ans << "\n";

    for(int i = 2; i <= N; i++) {
        cout << "1 " << i << "\n";
    }

    return 0;
}