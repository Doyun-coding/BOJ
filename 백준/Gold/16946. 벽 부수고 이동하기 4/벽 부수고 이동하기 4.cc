#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N, M;
int arr[1001][1001];
int ans[1001][1001];
bool visited[1001][1001];

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

class Node {
private:
    int x;
    int y;

public:
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

queue<Node> q;

int graphNum[1001][1001];
vector< vector<Node> > graph;
int n = 0;
priority_queue<int> priorityQueue;

void BFS(int x, int y) {
    
    q.push(Node(x, y));
    while(!q.empty()) {
        Node node = q.front();
        q.pop();
        int curX = node.getX();
        int curY = node.getY();
        if(!visited[curX][curY]) {
            visited[curX][curY] = true;
            
            graph[n].push_back(Node(curX, curY));
            graphNum[curX][curY] = n;

            for(int i = 0; i < 4; i++) {
                if(curX+dx[i] >= 1 && curX+dx[i] <= N && curY+dy[i] >= 1 && curY+dy[i] <= M && !visited[curX+dx[i]][curY+dy[i]]) {
                    if(arr[curX+dx[i]][curY+dy[i]] == 0) {
                        q.push(Node(curX+dx[i], curY+dy[i]));
                    }
                }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;

    for(int i = 1; i <= N; i++) {
        string s;
        cin >> s;
        for(int j = 1; j <= M; j++) {
            arr[i][j] = 
            arr[i][j] = int(s[j-1] - '0');
        }
    }

    graph.resize(1000001, vector<Node>());

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++){
            graphNum[i][j] = -1;
        }
    }


    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            if(arr[i][j] == 0) {
                BFS(i, j);
                n++;
            }
        }
    }

    priorityQueue = priority_queue<int>();

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            if(arr[i][j] == 1) {
                for(int d = 0; d < 4; d++) {
                    if(i+dx[d] >= 1 && i+dx[d] <= N && j+dy[d] >= 1 && j+dy[d] <= M && graphNum[i+dx[d]][j+dy[d]] >= 0) {
                        priorityQueue.push(graphNum[i+dx[d]][j+dy[d]]);
                    }
                }
                int s = -1;
                int sum = 1;
                if(!priorityQueue.empty()) {
                    s = priorityQueue.top();
                    priorityQueue.pop();
                    sum += graph[s].size();
                }
                while(!priorityQueue.empty()) {
                    int sG = priorityQueue.top();
                    priorityQueue.pop();
                    if(s != sG) {
                        sum += graph[sG].size();
                    }
                    s = sG;
                }
                ans[i][j] = sum % 10;
            }
        }
    }


    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            cout << ans[i][j] << "";
        }
        cout << "\n";
    }

    return 0;
}