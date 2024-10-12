#include <bits/stdc++.h>

using namespace std;

int N;
vector<vector<string> > arr;

int MAX = -100000000;
int MIN = 100000000;

int dx[] = {1, 0};
int dy[] = {0, 1};

class Node {
public:
    int x;
    int y;
    int value;
    string pre;
    Node(int x, int y, int value, string pre) {
        this->x = x;
        this->y = y;
        this->value = value;
        this->pre = pre;
    }
    int getX() {
        return this->x;
    }
    int getY() {
        return this->y;
    }
    int getValue() {
        return this->value;
    }
    string getPre() {
        return this->pre;
    }
};

stack<string> st;
stack<Node> S;

void DFS(int a, int b) {
    S.push(Node(a, b, stoi(arr[1][1]), ""));
    while(!S.empty()) {
        Node curNode = S.top();
        S.pop();
        int x = curNode.getX();
        int y = curNode.getY();
        int value = curNode.getValue();
        string pre = curNode.getPre();

        if(x == N && y == N) {
            MAX = max(MAX, value);
            MIN = min(MIN, value);
        }
        else {
            for(int i = 0; i < 2; i++) {
                if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= N) {
                    if(arr[x+dx[i]][y+dy[i]] == "+" || arr[x+dx[i]][y+dy[i]] == "-" || arr[x+dx[i]][y+dy[i]] == "*") {
                        S.push(Node(x+dx[i], y+dy[i], value, arr[x+dx[i]][y+dy[i]]));
                    }
                    else {
                        int n = stoi(arr[x+dx[i]][y+dy[i]]);
                        if(pre == "+") {
                            S.push(Node(x+dx[i], y+dy[i], value + n, ""));
                        }
                        else if(pre == "-") {
                            S.push(Node(x+dx[i], y+dy[i], value - n, ""));
                        }
                        else if(pre == "*") {
                            S.push(Node(x+dx[i], y+dy[i], value * n, ""));
                        }
                    }
                }

            }
        }

    }

}

int main() {
    cin >> N;

    arr.resize(N+1, vector<string>(N+1));

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            string s;
            cin >> s;

            arr[i][j] = s;
        }
    }

    DFS(1, 1);

    cout << MAX << " " << MIN << "\n";

    return 0;
}