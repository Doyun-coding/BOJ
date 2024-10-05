#include <bits/stdc++.h>

using namespace std;

int N, M, K;
vector<long long> arr;
vector<long long> segmentTree;
vector<long long> lazy;
vector<long long> ans;

void updateLazy(int start, int end, int node) {
    if(lazy[node] != 0) {
        segmentTree[node] += (end - start + 1) * lazy[node];
        if(start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        } 
        lazy[node] = 0;
    }
}

long long initTree(int start, int end, int node) {
    if(start == end) {
        return segmentTree[node] = arr[start];
    }

    int mid = (start + end) / 2;

    return segmentTree[node] = initTree(start, mid, node*2) + initTree(mid+1, end, node*2+1);
}

long long sumTree(int start, int end, int node, int left, int right) {
    updateLazy(start, end, node);

    if(left > end || right < start) {
        return 0;
    }

    if(left <= start && end <= right) {
        return segmentTree[node];
    }

    int mid = (start + end) / 2;

    return sumTree(start, mid, node*2, left, right) + sumTree(mid+1, end, node*2+1, left, right);
}

void update(int start, int end, int node, int left, int right, long long diff) {
    updateLazy(start, end, node);

    if(right < start || end < left) {
        return;
    }

    if(left <= start && end <= right) {
        lazy[node] += diff;
        updateLazy(start, end, node);

        return;
    }

    int mid = (start + end) / 2;

    update(start, mid, node * 2, left, right, diff);
    update(mid+1, end, node * 2 + 1, left, right, diff);

    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
}

int main() {
    cin >> N >> M >> K;

    arr.resize(N+1);

    for(int i = 1; i <= N; i++) {
        long long n;
        cin >> n;
        arr[i] = n;
    }

    segmentTree.resize(4 * N);
    lazy.resize(4 * N);

    initTree(1, N, 1);

    for(int i = 1; i <= M+K; i++) {
        int a;
        cin >> a;

        if(a == 1) {
            int b, c;
            long long d;
            cin >> b >> c >> d;

            update(1, N, 1, b, c, d);
        }
        else if(a == 2) {
            int b, c;
            cin >> b >> c;

            long long sum = sumTree(1, N, 1, b, c);

            ans.push_back(sum);
        }
    }

    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i] << "\n";
    }

    return 0;
}