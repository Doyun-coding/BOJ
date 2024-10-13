#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<vector<int> > arr;
int startX = -1, startY = -1;
int endX = -1, endY = -1;

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

class Node {
public:
    int x;
    int y;
    Node(int x, int y) {
        this->x = x;
        this->y = y;
    }
    int getX() {
        return this->x;
    }
    int getY() {
        return this->y;
    }
};

vector<vector<Node> > route;
stack<Node> S;
vector<vector<bool> > visited;

void DFS(int a, int b) {
    S.push(Node(a, b));
    while(!S.empty()) {
        Node curNode = S.top();
        S.pop();
        int x = curNode.getX();
        int y = curNode.getY();

        if(endX == x && endY == y) return;

        if(!visited[x][y]) {
            visited[x][y] = true;

            for(int i = 0; i < 4; i++) {
                if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= M) {
                    if(!visited[x+dx[i]][y+dy[i]] && arr[x+dx[i]][y+dy[i]] == 1) {
                        S.push(Node(x+dx[i], y+dy[i]));
                        route[x+dx[i]][y+dy[i]] = Node(x, y);
                    }
                }
            }

        }
    }
}

int main() {
    cin >> N >> M;

    arr.resize(N+1, vector<int>(M+1, 0));
    route.resize(N+1, vector<Node>(M+1, Node(0, 0)));
    visited.resize(N+1, vector<bool>(M+1, false));

    for(int i = 1; i <= N; i++) {
        string s;
        cin >> s;
        for(int j = 1; j <= M; j++) {

            if(s[j-1] == '.') {
                arr[i][j] = 1;
            }
            else if(s[j-1] == '+') {
                arr[i][j] = -1;
            }

            if((j == 1 || j == M) && arr[i][j] == 1) {
                if(startX == -1) {
                    startX = i;
                    startY = j;
                }
                else {
                    endX = i;
                    endY = j;
                }
            }
            else if((i == 1 || i == N) && arr[i][j] == 1) {
                if(startX == -1) {
                    startX = i;
                    startY = j;
                }
                else {
                    endX = i;
                    endY = j;
                }
            }
        }
    }

    DFS(startX, startY);

    arr[startX][startY] = 0;
    arr[endX][endY] = 0;
    int x = endX;
    int y = endY;

    while(true) {
        Node node = route[x][y];
        x = node.getX();
        y = node.getY();

        arr[x][y] = 0;

        if(x == startX && y == startY) break;
    }

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            if(arr[i][j] == -1) {
                cout << "+";
            }
            else if(arr[i][j] == 0){
                cout << ".";
            }
            else if(arr[i][j] == 1) {
                cout << "@";
            }
        }
        cout << "\n";
    }

    

    return 0;
}