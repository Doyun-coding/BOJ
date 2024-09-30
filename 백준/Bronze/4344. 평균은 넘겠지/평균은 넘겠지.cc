#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int C;

int main() {
    cin >> C;

    int N;
    for(int c = 1; c <= C; c++) {
        cin >> N;

        int arr[N+1];
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            int n;
            cin >> n;
            arr[i] = n;
            sum += n;
        }

        double avg = sum / N;

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(arr[i] > avg) {
                cnt++;
            }
        }

        double res = (double)cnt / N * 100;

        cout << fixed;
		cout.precision(3);
		cout << res << "%" << endl;

    }

    return 0;
}