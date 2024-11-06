#include <bits/stdc++.h>

using namespace std;

long long N;
bitset<64> BS;
long long sum = 0;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;

    BS = bitset<64>(N);
    string B = BS.to_string();

    long long P = 1;
    for(int i = 63; i >= 0; i--) {
        if(B[i] == '1') {
            sum += P;
        }
        P *= 3;
    }

    cout << sum << "\n";

    return 0;
}