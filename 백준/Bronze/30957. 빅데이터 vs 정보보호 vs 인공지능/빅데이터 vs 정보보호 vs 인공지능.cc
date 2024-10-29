#include <bits/stdc++.h>

using namespace std;

int N;
int arr[3];

int main() {
    cin >> N;
    for(int i = 0; i < 3; i++) {
        arr[i] = 0;
    }

    string s;

    cin >> s;

    for(int i = 0; i < N; i++) {
        if(s[i] == 'S') {
            arr[1] += 1;
        }
        else if(s[i] == 'B') {
            arr[0] += 1; 
        }
        else if(s[i] == 'A') {
            arr[2] += 1;
        }
    }

    if(arr[0] == arr[1] && arr[0] == arr[2]) {
        cout << "SCU" << "\n";
    }
    else if((arr[0] > arr[1]) && (arr[0] > arr[2])) {
        cout << "B\n";
    }
    else if((arr[1] > arr[0]) && (arr[1] > arr[2])) {
        cout << "S\n";
    }
    else if((arr[2] > arr[0]) && (arr[2] > arr[1])) {
        cout << "A\n";
    }
    else if(arr[0] == arr[1]) {
        cout << "BS\n";
    }
    else if(arr[0] == arr[2]) {
        cout << "BA\n";
    }
    else if(arr[1] == arr[2]) {
        cout << "SA\n";
    }

    return 0;
}