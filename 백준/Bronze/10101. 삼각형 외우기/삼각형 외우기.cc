#include <bits/stdc++.h>

using namespace std;

int A, B, C;

int main() {
    cin >> A >> B >> C;

    if(A == 60 && B == 60 && C == 60) {
        cout << "Equilateral" << "\n";
    }
    else if(A + B + C == 180) {
        if(A == B || B == C || C == A) {
            cout << "Isosceles" << "\n";
        }
        else {
            cout << "Scalene" << "\n";
        }
    }
    else {
        cout << "Error" << "\n";
    }

    return 0;
}