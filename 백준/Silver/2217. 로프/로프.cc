#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
#include <cmath>

using namespace std;

int N;
priority_queue<int, vector<int>, greater<int> > priorityQueue;
int m = 0;

int main() {
    cin >> N;

    for(int i = 1; i <= N; i++) {
        int n;
        cin >> n;
        priorityQueue.push(n);
    }

    while(!priorityQueue.empty()) {
        int n = priorityQueue.top();
        int size = priorityQueue.size();
        priorityQueue.pop();

        n = n * size;
        m = max(m, n);
    }

    cout << m << "\n";

    return 0;
}