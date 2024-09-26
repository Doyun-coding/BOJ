#include <iostream>

using namespace std;

int x1, y1, x2, y2, x3, y3;

int main() {
    cin >> x1 >> y1;
    cin >> x2 >> y2;
    cin >> x3 >> y3;

    int u1 = x1-x2;
    int u2 = y1-y2;
    int v1 = x3-x2;
    int v2 = y3-y2;

    int d = u1*v2 - u2*v1;

    if(d == 0) {
        cout << "0" << "\n";
    }
    else if(d > 0) {
        cout << "-1" << "\n";
    }
    else if(d < 0) {
        cout << "1" << "\n";
    }

    return 0;
}