#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

enum Color {
    WHITE,
    GRAY,
    BLACK
};

int myTime = 1;
int sccNumber = 1;
Color color[10002];
int low[10002];
int discoverTime[10002];
int scc[10002];

vector<vector<int>> edges;
vector<vector<int>> sccGroup; // 백준용 코드
stack<int> discoverStack;

int strongComponent(int u) {

    color[u] = GRAY;
    discoverTime[u] = myTime++;
    low[u] = discoverTime[u];
    discoverStack.push(u);

    for (int v : edges[u]) {
        if (color[v] == WHITE) {
            int ret = strongComponent(v);
            low[u] = min(low[u], ret);
        }
        else if (scc[v] == 0) {
            low[u] = min(low[u], discoverTime[v]);
        }
    }

    if (low[u] >= discoverTime[u]) {
        int y = 0;
        do {
            y = discoverStack.top();
            discoverStack.pop();
            scc[y] = sccNumber;
            sccGroup[sccNumber].push_back(y); // 백준용 코드
        } while (y != u);
        ++sccNumber;
    }
    return low[u];
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n = 0, m = 0, u = 0, v = 0;

    cin >> n >> m;
    edges.resize(n + 1);
    sccGroup.resize(n + 1); // 백준용 코드
    for (int i=0; i<m; ++i) {
        cin >> u >> v;
        edges[u].push_back(v);
    }

    for (int i=1; i<=n; ++i) {
        if (color[i] == WHITE) {
            strongComponent(i);
        }
    }

    cout << sccNumber - 1 << endl;

    // 백준용 코드
    for (int i=1; i<=n; ++i) {
        int s_num = scc[i];
        if (sccGroup[s_num].back() != -1) {
            sort(sccGroup[s_num].begin(), sccGroup[s_num].end());
            for (int component : sccGroup[s_num]) {
                cout << component << " ";
            }
            cout << "-1\n";
            sccGroup[s_num].push_back(-1);
        }
    }

    return 0;
    
}