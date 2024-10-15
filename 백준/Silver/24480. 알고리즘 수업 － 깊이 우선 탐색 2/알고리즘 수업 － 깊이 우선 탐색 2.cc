#include <bits/stdc++.h>

using namespace std;

int N, M, R;
vector<priority_queue<int, vector<int>, greater<int> > > arrayLists;
vector<bool> visited;
vector<int> cnt;
stack<int> S;
int now = 0;

void DFS(int a) {
    S.push(a);
    while(!S.empty()) {
        int u = S.top();
        S.pop();

        if(!visited[u]) {
            visited[u] = true;
            now++;
            cnt[u] = now;

            while(!arrayLists[u].empty()) {
                int n = arrayLists[u].top();
                arrayLists[u].pop();

                S.push(n);
            }

        }

    }
}

int main() {
    cin >> N >> M >> R;

    arrayLists.resize(N+1);
    visited.resize(N+1, false);
    cnt.resize(N+1, 0);

    for(int i = 1; i <= M; i++) {
        int a, b;
        cin >> a >> b;

        arrayLists[a].push(b);
        arrayLists[b].push(a);
    }

    DFS(R);

    for(int i = 1; i <= N; i++) {
        cout << cnt[i] << "\n";
    }    

    return 0;
}