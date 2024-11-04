#include <bits/stdc++.h>

using namespace std;

int N;
vector<vector<int> > arr;
int sum = 0;
vector<int> parent;
int c = 0;

class Node {
public:
    int start;
    int end;
    int cost;

    Node(int start, int end, int cost) {
        this->start = start;
        this->end = end;
        this->cost = cost;
    }

    int getStart() {
        return this->start;
    }
    int getEnd() {
        return this->end;
    }
    int getCost() {
        return this->cost;
    }

    bool operator<(const Node& other) const {
        return this->cost < other.cost;
    }
};

vector<Node> graph;

int find(int x) {
    if(parent[x] == x) {
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

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;

    arr.resize(N+1, vector<int>(N+1, 0));
    parent.resize(N+1);

    for(int i = 1; i <= N; i++) {
        string s;
        cin >> s;

        for(int j = 1; j <= N; j++) {
            if(s[j-1] != '0') {
                int n = s[j-1] - '0';
                n -= 48;
                if(n <= 0) {
                    n += 58;
                }

                arr[i][j] = n;
                sum += n;

                if(i == j) arr[i][j] = 0;
                else {
                    graph.push_back(Node(i, j, arr[i][j]));
                }
            }
            else {
                arr[i][j] = 0;
            }
        }
    }

    for(int i = 1; i <= N; i++) {
        parent[i] = i;
    }

    sort(graph.begin(), graph.end());

    for(int i = 0; i < graph.size(); i++) {
        Node node = graph[i];
        if(find(node.getStart()) != find(node.getEnd())) {
            u(node.getStart(), node.getEnd());
            c += node.getCost();
        }
    }

    bool chk = true;

    for(int i = 1; i < N; i++) {
        if(find(parent[i]) != find(parent[i+1])) {
            chk = false;
            break;
        }
    }

    if(!chk) {
        cout << "-1\n";
    }
    else {
        sum -= c;
        cout << sum << "\n";
    }
    return 0;
}