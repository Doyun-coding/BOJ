#include <bits/stdc++.h>

using namespace std;

string A, B;

int main() {
    cin >> A >> B;

    reverse(A.begin(), A.end());
    reverse(B.begin(), B.end());

    int x = stoi(A);
    int y = stoi(B);

    int sum = x + y;
    string result = to_string(sum);
    reverse(result.begin(), result.end());

    cout << stoi(result) << "\n";


    return 0;
}