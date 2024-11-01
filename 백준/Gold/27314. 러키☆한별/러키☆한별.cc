#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<vector<int> > arr;
int X, Y;
int c = 0;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

class Node {
public:
    int x;
    int y;
    int cnt;

    Node(int x, int y) {
        this->x = x;
        this->y = y;
    }

    Node(int x, int y, int cnt) {
        this->x = x;
        this->y = y;
        this->cnt = cnt;
    }

    int getX() {
        return this->x;
    }
    int getY() {
        return this->y;
    }
    int getCnt() {
        return this->cnt;
    }

};

int m = 0;
int ans = 0;

void BFS(int a, int b, bool what, int destX, int destY) {
    vector<vector<bool> > visited;
    visited.resize(N+1, vector<bool>(M+1, false));

    queue<Node> q;
    q.push(Node(a, b, 0));
    while(!q.empty()) {
        Node curNode = q.front();
        q.pop();

        int x = curNode.getX();
        int y = curNode.getY();
        int cnt = curNode.getCnt();

        if(!visited[x][y]) {
            visited[x][y] = true;

            if(!what && cnt > m) {
                continue;
            }

            if(!what && arr[x][y] == 1) {
                if(cnt <= m) {
                    c++;
                }
            }

            if(arr[x][y] == 2 && what && x == destX && y == destY) {
                m = cnt;
                return;
            }

            for(int i = 0; i < 4; i++) {
                if(x+dx[i] >= 1 && x+dx[i] <= N && y+dy[i] >= 1 && y+dy[i] <= M && !visited[x+dx[i]][y+dy[i]]) {
                    if(arr[x+dx[i]][y+dy[i]] != -1) {
                        q.push(Node(x+dx[i], y+dy[i], cnt+1));
                    }
                }
            }

        }
        
    }

}

int main() {
    cin >> N >> M;

    arr.resize(N+1, vector<int>(M+1, 0));

    for(int i = 1; i <= N; i++) {
        string s;
        cin >> s;
        for(int j = 1; j <= M; j++) {
            if(s[j-1] == 'H' || s[j-1] == '.') {
                arr[i][j] = 0;
                if(s[j-1] == 'H') {
                    X = i;
                    Y = j;
                }
            }
            else if(s[j-1] == 'P') {
                arr[i][j] = 1;
            }
            else if(s[j-1] == '#') {
                arr[i][j] = 2;
            }
            else if(s[j-1] == 'X') {
                arr[i][j] = -1;
            }
        }
    }

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            if(arr[i][j] == 2) {
                m = 0;
                BFS(X, Y, true, i, j);

                c = 0;
                BFS(i, j, false, 0, 0);
                ans = max(ans, c);
            }
        }
    }

    cout << ans << "\n";

    return 0;
}