#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int N;
vector< pair<long long, long long> > arr;
int cnt = 0;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;
    arr.resize(N+1);

    for(int i = 1; i <= N; i++) {
        long long x;
        long long y;
        cin >> x >> y;

        arr[i] = make_pair(x, y);
    }

    for(int i = 1; i <= N; i++) {
        for(int j = i+1; j <= N; j++) {
            for(int k = j+1; k <= N; k++) {
                long long x1 = arr[i].first;
                long long y1 = arr[i].second;
                long long x2 = arr[j].first;
                long long y2 = arr[j].second;
                long long x3 = arr[k].first;
                long long y3 = arr[k].second;

                long long u1 = x2-x1;
                long long v1 = y2-y1;
                long long u2 = x3-x1;
                long long v2 = y3-y1;

                long long d = u1*u2 + v2*v1;

                if(d == 0) {
                    cnt++;
                    continue;
                }

                u1 = x1-x2;
                v1 = y1-y2;
                u2 = x3-x2;
                v2 = y3-y2;

                d = u1*u2 + v2*v1;

                if(d == 0) {
                    cnt++;
                    continue;
                }

                u1 = x1-x3;
                v1 = y1-y3;
                u2 = x2-x3;
                v2 = y2-y3;

                d = u1*u2 + v2*v1;

                if(d == 0) {
                    cnt++;
                    continue;
                }
            }
        }
    }

    cout << cnt << "\n";

    return 0;
}