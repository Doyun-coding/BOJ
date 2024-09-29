#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int N;

int main() {
    cin >> N;

    for(int i = 2; i <= N; i++) {
        if(N == 1) break;

        if(N % i == 0) {
            while(true) {
                if(N % i == 0) {
                    N /= i;
                    cout << i << "\n";
                }
                else {
                    break;
                }
            }
        }
    }

    return 0;
}