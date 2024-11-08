#include <bits/stdc++.h>

using namespace std;

class Node {
public:
    long long x;
    long long y;

    Node(long long x, long long y) {
        this->x = x;
        this->y = y;
    }

    long long getX() {
        return this->x;
    }
    long long getY() {
        return this->y;
    }
};

int CCW(Node A, Node B, Node C) {
    long long value = (A.getX() * B.getY()) + (B.getX() * C.getY()) + (C.getX() * A.getY());
    value -= (B.getX() * A.getY()) + (C.getX() * B.getY()) + (A.getX() * C.getY());

    if(value > 0) return 1;
    else if(value == 0) return 0;
    else return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    long long x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;
    Node p1(x1, y1);
    Node p2(x2, y2);

    cin >> x1 >> y1 >> x2 >> y2;
    Node p3(x1, y1);
    Node p4(x2, y2);

    int c1 = CCW(p1, p2, p3) * CCW(p1, p2, p4);
    int c2 = CCW(p3, p4, p1) * CCW(p3, p4, p2);

    if(c1 < 0 && c2 < 0) {
        cout << "1\n";
    }
    else {
        cout << "0\n";
    }


    return 0;
}