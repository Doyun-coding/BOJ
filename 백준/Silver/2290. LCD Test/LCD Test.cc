#include <bits/stdc++.h>

using namespace std;

int s;
string n;
vector<vector<int> > arr[10];

int main() {
    cin >> s >> n;

    for(int i = 0; i < 10; i++) {
        arr[i].resize(2*s+3, vector<int>(s+2, 0));
    }

    for(int i = 0; i < 2*s+3; i++) {
        if(i == 0 || i == 2*s+2) {
            for(int j = 1; j < s+1; j++) {
                arr[0][i][j] = 1;
            }
        }
        else {
            if(s+1 != i) {
                arr[0][i][0] = 2;
                arr[0][i][s+1] = 2;
            }
        }
    }

    for(int i = 1; i < 2*s+2; i++) {
        if(i != s+1) {
            arr[1][i][s+1] = 2;
        }
    }

    for(int i = 0; i < 2*s+3; i++) {
        if(i == 0 || i == s+1 || i == 2*s+2) {
            for(int j = 1; j < s+1; j++) {
                arr[2][i][j] = 1;
            }
        }
        else {
            if(i < s+1) {
                arr[2][i][s+1] = 2;
            }  
            else {
                arr[2][i][0] = 2;
            }
        }
    }

    for(int i = 0; i < 2*s+3; i++) {
        if(i == 0 || i == s+1 || i == 2*s+2) {
            for(int j = 1; j < s+1; j++) {
                arr[3][i][j] = 1;
            }
        }
        else {
            arr[3][i][s+1] = 2;
        }
    }

    for(int i = 1; i < 2*s+2; i++) {
        if(s+1 == i) {
            for(int j = 1; j < s+1; j++) {
                arr[4][i][j] = 1;
            }
        }
        else {
            if(i < s+1) {
                arr[4][i][0] = 2;
                arr[4][i][s+1] = 2;
            }
            else {
                arr[4][i][s+1] = 2;
            }
        }
    }

    for(int i = 0; i < 2*s+3; i++) {
        if(i == 0 || i == s+1 || i == 2*s+2) {
            for(int j = 1; j < s+1; j++) {
                arr[5][i][j] = 1;
            }
        }
        else {
            if(i < s+1) {
                arr[5][i][0] = 2;
            }
            else {
                arr[5][i][s+1] = 2;
            }
        }
    }

    for(int i = 0; i < 2*s+3; i++) {
        if(i == 0 || i == s+1 || i == 2*s+2) {
            for(int j = 1; j < s+1; j++) {
                arr[6][i][j] = 1;
            }
        }
        else {
            if(i < s+1) {
                arr[6][i][0] = 2;
            }
            else {
                arr[6][i][0] = 2;
                arr[6][i][s+1] = 2;
            }
        }
    }

    for(int i = 0; i < 2*s+2; i++) {
        if(i == 0) {
            for(int j = 1; j < s+1; j++) {
                arr[7][i][j] = 1;
            }
        }
        else if(i != s+1) {
            arr[7][i][s+1] = 2;
        }
    }

    for(int i = 0; i < 2*s+3; i++) {
        if(i == 0 || i == s+1 || i == 2*s+2) {
            for(int j = 1; j < s+1; j++) {
                arr[8][i][j] = 1;
            }
        }
        else {
            arr[8][i][0] = 2;
            arr[8][i][s+1] = 2;
        }
    }

    for(int i = 0; i < 2*s+3; i++) {
        if(i == 0 || i == s+1 || i == 2*s+2) {
            for(int j = 1; j < s+1; j++) {
                arr[9][i][j] = 1;
            }
        }
        else {
            if(i < s+1) {
                arr[9][i][0] = 2;
                arr[9][i][s+1] = 2;
            }
            else {
                arr[9][i][s+1] = 2;
            }
        }
    }



    // for(int i = 0; i < 2*s+3; i++) {
    //     for(int j = 0; j < s+2; j++) {
    //         cout << arr[1][i][j] << "";
    //     }
    //     cout << "\n";
    // }

    for(int i = 0; i < 2*s+3; i++) {
        for(int k = 0; k < n.length(); k++) {
            int l = n[k] - '0';
            for(int j = 0; j < s+2; j++) {
                if(arr[l][i][j] == 1) {
                    cout << "-";
                }
                else if(arr[l][i][j] == 2) {
                    cout << "|";
                }
                else {
                    cout << " ";
                }
            }
            cout << " ";
        }
        cout << "\n";
    }
    cout << "\n";

    return 0;
}