#include <bits/stdc++.h>

using namespace std;

int N;
vector<long long> arr;
int M;
vector<long long> segmentTree;
vector<long long> ans;

void returnTree(int node) {
    if(node == 0) return;

    int left = segmentTree[node * 2];
    int right = segmentTree[node * 2 + 1];

    if(segmentTree[node] != left && segmentTree[node] != right) {
        long long m = min(left, right);
        segmentTree[node] = m;

        returnTree(node / 2);
    }
    else {
        return;
    }
}

long long initTree(int start, int end, int node) {
    if(start == end) {
        return segmentTree[node] = arr[start];
    }

    int mid = (start + end) / 2;

    return segmentTree[node] = min(initTree(start, mid, node * 2), initTree(mid + 1, end, node * 2 + 1));
}

long long minTree(int start, int end, int node, int left, int right) {
    if(start > right || end < left) {
        return 1000000001;
    }

    if(left <= start && end <= right) {
        return segmentTree[node];
    }

    int mid = (start + end) / 2;

    return min(minTree(start, mid, node * 2, left, right), minTree(mid + 1, end, node * 2 + 1, left, right));   
}

long long updateTree(int start, int end, int node, int left, int diff) {
    if(start > left || end < left) return 1000000001;

    if(start == end) {
        segmentTree[node] = diff;

       // returnTree(node / 2);
        return segmentTree[node];
    }

    int mid = (start + end) / 2;

    updateTree(start, mid, node * 2, left, diff);
    updateTree(mid + 1, end, node * 2 + 1, left, diff);

    return segmentTree[node] = min(segmentTree[node * 2], segmentTree[node * 2 + 1]);
}

int main() {
    cin >> N;

    arr.resize(N+1);
    for(int i = 1; i <= N; i++) {
        long long n;
        cin >> n;
        arr[i] = n;
    }

    segmentTree.resize(4 * N);

    initTree(1, N, 1);

    cin >> M;

    for(int i = 1; i <= M; i++) {
        int a;
        cin >> a;

        if(a == 1) {
            int b;
            long long c;
            cin >> b >> c;

            updateTree(1, N, 1, b, c);
        }
        else if(a == 2) {
            int b, c;
            cin >> b >> c;

            long long m = minTree(1, N, 1, b, c);

            ans.push_back(m);
        }
    }

    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i] << "\n";
    }

    return 0;
}