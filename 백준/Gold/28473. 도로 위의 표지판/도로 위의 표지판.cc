#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<int> parent;

class Node {
public:
    int start;
    int end;
    int num;
    long long cost;
    
    Node(int start, int end, int num, long long cost) 
        : start(start), end(end), num(num), cost(cost) {}

    bool operator<(const Node &other) const {
        if (this->num == other.num) {
            return this->cost < other.cost;  // 오름차순 정렬
        }
        return this->num < other.num;  // num을 우선적으로 정렬
    }
};

vector<Node> arr;

// Union-Find 함수들
int find(int x) {
    if (x != parent[x]) {
        parent[x] = find(parent[x]);  // 경로 압축
    }
    return parent[x];
}

void u(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
        parent[y] = x;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    cin >> N >> M;

    parent.resize(N + 1);
    for (int i = 1; i <= N; i++) {
        parent[i] = i;
    }

    for (int i = 1; i <= M; i++) {
        int start, end, num;
        long long cost;
        cin >> start >> end >> num >> cost;
        arr.emplace_back(start, end, num, cost);
    }

    // 정렬하여 최소 비용의 간선을 먼저 처리
    sort(arr.begin(), arr.end());

    long long sum = 0;
    int edge = 0;
    ostringstream s;

    for (const auto &node : arr) {
        if (find(node.start) != find(node.end)) {
            s << node.num;  // 노드 번호 추가
            sum += node.cost;
            edge += 1;
            u(node.start, node.end);

            // 최소 신장 트리를 완성한 경우 종료
            if (edge == N - 1) break;
        }
    }

    if (edge == N - 1) {
        cout << s.str() << " " << sum << "\n";
    } else {
        cout << "-1\n";
    }

    return 0;
}
