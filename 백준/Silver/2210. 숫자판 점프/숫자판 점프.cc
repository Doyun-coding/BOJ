#include <bits/stdc++.h>

using namespace std;

vector<vector<int> > arr;

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

set<int> hashSet;

class Node {
public:
    int x;
    int y;
    int depth;
    int sum;
    Node(int x, int y, int depth, int sum) {
        this->x = x;
        this->y = y;
        this->depth = depth;
        this->sum = sum;
    }
    int getX() {
        return this->x;
    }
    int getY() {
        return this->y;
    }
    int getDepth() {
        return this->depth;
    }
    int getSum() {
        return this->sum;    
    }
};

stack<Node> S;

void DFS(int a, int b) {
    S.push(Node(a, b, 1, 0));
    while(!S.empty()) {
        Node curNode = S.top();
        S.pop();
        int x = curNode.getX();
        int y = curNode.getY();
        int depth = curNode.getDepth();
        int sum = curNode.getSum();

        sum += pow(10, depth-1) * arr[x][y];

        if(depth == 6) {
            if(hashSet.find(sum) == hashSet.end()) {
                hashSet.insert(sum);
            }
        }
        else {
            for(int i = 0; i < 4; i++) {
                if(x+dx[i] >= 1 && x+dx[i] <= 5 && y+dy[i] >= 1 && y+dy[i] <= 5) {
                    S.push(Node(x+dx[i], y+dy[i], depth+1, sum));
                }
            }
        }

    }

}

int main() {
    arr.resize(6, vector<int>(6, 0));

    for(int i = 1; i <= 5; i++) {
        for(int j = 1; j <= 5; j++) {
            int n;
            cin >> n;

            arr[i][j] = n;
        }
    }

    for(int i = 1; i <= 5; i++) {
        for(int j = 1; j <= 5; j++) {
            DFS(i, j);
        }
    }

    int size = hashSet.size();
    
    cout << size << "\n";

    return 0;
}