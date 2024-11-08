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

bool isLine(Node A, Node B, Node C, Node D) {
    if(A.getX() > B.getX()) {
        int temp = A.getX();
        A.x = B.getX();
        B.x = temp;
    }

    if(C.getX() > D.getX()) {
        int temp = C.getX();
        C.x = D.getX();
        D.x = temp;
    }

    return (A.getX() <= D.getX() && B.getX() >= C.getX()) || (C.getX() <= B.getX() && D.getX() >= A.getX());
}

bool isLineY(Node A, Node B, Node C, Node D) {
    if(A.getY() > B.getY()) {
        int temp = A.getY();
        A.y = B.getY();
        B.y = temp;
    }

    if(C.getY() > D.getY()) {
        int temp = C.getY();
        C.y = D.getY();
        D.y = temp;
    }

    return (A.getY() <= D.getY() && B.getY() >= C.getY()) || (C.getY() <= B.getY() && D.getY() >= A.getY());
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

    if(c1 <= 0 && c2 <= 0) {
        if(c1 == 0 && c2 == 0) {

            if(isLine(p1, p2,p3,p4) && isLineY(p1, p2, p3, p4)) {
                cout << "1\n";
            }
            else {
                cout << "0\n";
            }

        }
        else {
            cout << "1\n";
        }
    }
    else {
        if((p1.getX() == p3.getX() && p1.getY() == p3.getY()) || (p1.getX() == p4.getX() && p1.getY() == p4.getY()) || (p2.getX() == p3.getX() && p2.getY() == p3.getY()) || (p2.getX() == p4.getX() && p2.getY() == p4.getY())) {
            cout << "1\n";
        }
        else {
            cout << "0\n";
        }
    }


    return 0;
}