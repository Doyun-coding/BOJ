#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<long long> arr;
vector<long long> segmentTree;
vector<long long> lazy;

long long initTree(int start, int end, int node) {
    if(start == end) {
        return segmentTree[node] = arr[start];
    }

    int mid = (start + end) / 2;

    return segmentTree[node] = initTree(start, mid, node * 2) + initTree(mid + 1, end, node * 2 + 1);
}

void lazyTree(int start, int end, int node) {
    if(lazy[node] != 0) {
        segmentTree[node] += (end - start + 1) * lazy[node];
        if(start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
}

void updateTree(int start, int end, int node, int left, int right, long long diff) {
    lazyTree(start, end, node);

    if(left > end || right < start) {
        return;
    }

    if(left <= start && end <= right) {
        lazy[node] += diff;
        return;
    }

    int mid = (start + end) / 2;

    updateTree(start, mid, node * 2, left, right, diff);
    updateTree(mid + 1, end, node * 2 + 1, left, right, diff);

    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
}

void findTree(int start, int end, int node, int x) {
    lazyTree(start, end, node);

    if(start > x || end < x) {
        return;
    }

    if(start == end) {
        arr[start] = segmentTree[node];
        return;
    }

    int mid = (start + end) / 2;

    findTree(start, mid, node * 2, x);
    findTree(mid + 1, end, node * 2 + 1, x);
}

int main() {
    cin >> N;

    arr.resize(N+1);

    for(int i = 1; i <= N; i++) {
        int n;
        cin >> n;
        arr[i] = n;
    }

    segmentTree.resize(4 * N);
    lazy.resize(4 * N);

    initTree(1, N, 1);  

    cin >> M;

    for(int i = 1; i <= M; i++) {
        int a;
        cin >> a;

        if(a == 1) {
            int b, c;
            long long diff;
            cin >> b >> c >> diff;

            updateTree(1, N, 1, b, c, diff);
        }
        else if(a == 2) {
            int b;
            cin >> b;

            findTree(1, N, 1, b);

            cout << arr[b] << "\n";
        }
    }

    return 0;
}