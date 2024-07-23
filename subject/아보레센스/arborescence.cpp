#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>

#define WHITE 0
#define GREY 1
#define BLACK 2

using namespace std;


int node_number = 1;
int cluster_num = 1;
int color[10005];
int upperParent[10005];
int discover_time[10005];
int cluster[10005];
int arborescence_root;
stack<int> st;


int visited[10005];  // visited[i] = i번 노드를 방문했는지 여부
int tree_num[10005];  // tree_num[i] = i번 노드를 루트로 하는 서브트리의 노드 개수
vector<int> graph[10005];  // graph[i] = i번 노드와 연결된 노드들


int strongly_connected_component(int node) {
    color[node] = GREY;
    discover_time[node] = node_number++;
    upperParent[node] = discover_time[node];
    st.push(node);

    for (int i = 0; i < graph[node].size(); i++) {
        int next_node = graph[node][i];
        if (color[next_node] == WHITE) {
            int up = strongly_connected_component(next_node);
            upperParent[node] = min(upperParent[node], up);
        }
        else if (cluster[next_node] == 0) {
            upperParent[node] = min(upperParent[node], discover_time[next_node]);
        }
    }

    if (upperParent[node] == discover_time[node]) {
        int n;
        while (true) {
            n = st.top();
            st.pop();
            cluster[n] = cluster_num;
            if (n == node) break;
        }
        cluster_num += 1;
    }

    color[node] = BLACK;

    return upperParent[node];
}

void dfs(int node, int n) {
    visited[node] = GREY;
    tree_num[node] = 1;

    for (int i = 0; i < graph[node].size(); ++i) {
        int next = graph[node][i];
        if (visited[next] == WHITE) {
            dfs(next, n);
            tree_num[node] += tree_num[next];
        }
        else if (visited[next] == BLACK) {
            tree_num[node] += tree_num[next];
        }
    }
    if (tree_num[node] == n) {
        arborescence_root = node;
    }
    visited[node] = BLACK;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
    }

    for (int i = 1; i <= n; ++i) {  // 강한 연결 요소 찾기
        if (color[i] == WHITE) {
            strongly_connected_component(i);
        }
    }

    for (int i = 1; i <= n; ++i) {  // dfs로 가장 아보레센스 루트 하나 찾기
        if (visited[i] == WHITE) {
            dfs(i, n);
        }
    }

    int answer = 0;
    for (int i = 1; i <= n; ++i) {  // 아보레센스 루트의 연결 성분들 찾기
        if (cluster[i] == cluster[arborescence_root]) {
            ++answer;
        }
    }

    cout << answer << '\n';  // 정답 출력

    return 0;
}