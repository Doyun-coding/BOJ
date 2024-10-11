#include <bits/stdc++.h>

using namespace std;

int N, M, R;
vector<int> visitedOrder;
vector<vector<int> > arrayLists;
vector<bool> visited;
int now = 0;

class Node {
public:
    int x;
    int cnt;

    Node(int x, int cnt) {
        this->x = x;
        this->cnt = cnt;
    }
    int getX() {
        return this->x;
    }
    int getCnt() {
        return this->cnt;
    }

    bool operator<(const Node& other) const {
        return this->x > other.x;
    }
};

stack<Node> q;
priority_queue<int, vector<int>, less<int> > pq;

void DFS(int x) {
    q.push(Node(x, 1));
    while(!q.empty()) {
        Node curNode = q.top();
        q.pop();
        int u = curNode.getX();
        int cnt = curNode.getCnt();
        if(!visited[u]) {
            now++;
            visited[u] = true;
            visitedOrder[u] = now;

            for(int n : arrayLists[u]) {
                if(!visited[n]) {
                    pq.push(n);
                }
            }

            while(!pq.empty()) {
                int n = pq.top();
                pq.pop();
                q.push(Node(n, cnt+1));
            }

        }
    }
}

int main() {
    cin >> N >> M >> R;

    visitedOrder.resize(N+1, 0);
    arrayLists.resize(N+1);
    visited.resize(N+1, false);

    for(int i = 1; i <= M; i++) {
        int a, b;
        cin >> a >> b;

        arrayLists[a].push_back(b);
        arrayLists[b].push_back(a);
    }

    DFS(R);

    for(int i = 1; i <= N; i++) {
        cout << visitedOrder[i] << "\n";
    }

    return 0;
}