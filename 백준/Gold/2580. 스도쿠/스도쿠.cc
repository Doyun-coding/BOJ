#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector< vector<int> > arr;

bool check(int x, int y, int data) {
    for(int i = 1; i <= 9; i++) {
        if(arr[i][y] == data) {
            return false;
        }
        if(arr[x][i] == data) {
            return false;
        }
    }

    int c = (x-1) / 3 * 3;
    int r = (y-1) / 3 * 3;

    for(int i = c+1; i <= c+3; i++) {
        for(int j = r+1; j <= r+3; j++) {
            if(arr[i][j] == data) {
                return false;
            }
        }
    }
    return true;
}

bool sudoku(int x, int y) {
    if(y > 9) {
        return sudoku(x + 1, 1);
    }

    if(x > 9) {
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                cout << arr[i][j] << " ";
            }
            cout << endl;
        }
        return true;
    }

    if(arr[x][y] == 0) {
        for(int i = 1; i <= 9; i++) {
            if(check(x, y, i)) {
                arr[x][y] = i;
                if(sudoku(x, y+1))
                    return true;
            }
        }
        arr[x][y] = 0;
        return false;
    }
    return sudoku(x, y+1);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    arr.resize(10, vector<int>(10, 0));

    for(int i = 1; i <= 9; i++) {
        for(int j = 1; j <= 9; j++) {
            cin >> arr[i][j];
        }
    }

    sudoku(1, 1);

    return 0;
}
