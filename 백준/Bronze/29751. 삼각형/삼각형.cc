#include <bits/stdc++.h>

using namespace std;

int W, H;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> W >> H;
    
    double ans = (double) W * H / 2;

    
    cout << fixed << setprecision(1);
    cout << ans << "\n";


    return 0;
}