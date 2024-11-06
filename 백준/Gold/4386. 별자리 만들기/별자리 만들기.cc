#include <bits/stdc++.h>

using namespace std;

int N;

class Point {
public:
    double x;
    double y;
    Point(double x, double y) {
        this->x = x;
        this->y = y;
    }

    double getX() {
        return this->x;
    }
    double getY() {
        return this->y;
    }
};

vector<int> parent;

vector<Point> p;

int find(int x) {
    if(x == parent[x]) {
        return x;
    }

    return parent[x] = find(parent[x]);
}

void u(int x, int y) {
    x = find(x);
    y = find(y);

    if(x != y) {
        parent[y] = x;
    }
}

class Node {
public:
    int start;
    int end;
    double dist;
    Node(int start, int end, double dist) {
        this->start = start;
        this->end = end;
        this->dist = dist;
    }
    int getStart() {
        return this->start;
    }
    int getEnd() {
        return this->end;
    }
    double getDist() {
        return this->dist;
    }

    bool operator<(const Node &other) const {
        return this->dist < other.dist;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;

    for(int i = 1; i <= N; i++) {
        double x, y;
        cin >> x >> y;

        p.push_back(Point(x, y));
    }

    parent.resize(N+1);
    for(int i = 1; i <= N; i++) {
        parent[i] = i;
    }

    vector<Node> arr;
    for(int i = 0; i < p.size(); i++) {
        Point p1 = p[i];
        double x = p1.getX();
        double y = p1.getY();
        
        for(int j = i+1; j < p.size(); j++) {
            Point p2 = p[j];
            double x2 = p2.getX();
            double y2 = p2.getY();

            double dist = sqrt(pow((x2-x), 2) + pow((y2-y), 2));

            dist = round(dist * 100) / 100;
            
            arr.push_back(Node(i, j, dist)); 
        }
    }

    sort(arr.begin(), arr.end());

    double sum = 0;

    for(int i = 0; i < arr.size(); i++) {
        Node node = arr[i];
        int start = node.getStart();
        int end = node.getEnd();
        double dist = node.getDist();
        
        if(find(start) != find(end)) {
            u(start, end);
            sum += dist;
        }
    }

    cout << sum << "\n";

    return 0;
}