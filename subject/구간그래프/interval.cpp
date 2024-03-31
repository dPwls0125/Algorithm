#include <iostream>
#include <string>
#include <vector>
#include <fstream>
using namespace std;

vector<int> graph[10001];
bool visited[10001] = {false,}; 
int is_it_interval = 1; 
void checkInterval(int node) {
    visited[node] = true;

    int count = 0;
    for(int i=0; i<graph[node].size(); i++){
        int linked_node = graph[node][i];
        if(graph[linked_node].size() > 1 ) count += 1; 
        if(count>=3){
            is_it_interval = -1;  
            return;
        }
    }
    for(int i=0; i<graph[node].size(); i++){
        int next_node =  graph[node][i];
        if(!visited[next_node])
            checkInterval(next_node);
    }
    return; 
}

int main() {
    int n; 
    cin >> n; 
    for(int i=1; i<n; i++){
        int a, b ;
        cin >> a >> b ;
        graph[a].push_back(b);
        graph[b].push_back(a); // 무방향 그래프
    }
    checkInterval(n);
    cout << is_it_interval;
}

