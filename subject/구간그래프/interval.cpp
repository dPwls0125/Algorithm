#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
// #include <fstream>
using namespace std;

vector<int> graph[10001];
bool visited[10001]; 
bool visited2[10001];
int is_it_interval = 1;
vector<pair<int,pair<int,int> > >answer;
int first_node;
int numVertices;
int max_depth = 0;  
int max_depth_node = -1; 

void dfs(int node, int depth){
    visited2[node]  = true; 
    if(depth > max_depth){
        max_depth = depth;
        max_depth_node = node; 
    }
    // 연결된 노드 탐색 
    for(int i=0; i<graph[node].size(); i++){
        int next_node =  graph[node][i];
        if(!visited2[next_node]){
            dfs(next_node,depth+1); 
        }     
    } 
}

void checkInterval(int node, int dot, int end_point) {
    visited[node] = true;
    int count = 0;
    int linked_size = graph[node].size();
    // 구간 생성
    if(linked_size == 1){ //external_node인 경우
      answer.push_back(make_pair(node,make_pair(dot,dot))); 
    }else if(linked_size > 1) {  // internal node인 경우
        answer.push_back(make_pair(node,make_pair(end_point,end_point+(linked_size-1))));
        dot = end_point + 1; 
        end_point = end_point+(linked_size-1);
        
    } 
    // 구간 그래프 여부 확인 
    for(int i=0; i<graph[node].size(); i++){
        int linked_node = graph[node][i];
        if(graph[linked_node].size() > 1 ) count += 1; 
        if(count>=3){
            is_it_interval = -1;  
            return;
        }
    }
    // 연결된 노드 탐색 
    for(int i=0; i<graph[node].size(); i++){
        int next_node =  graph[node][i];
        if(!visited[next_node]){
            checkInterval(next_node,dot,end_point);
            if(graph[next_node].size() == 1 ) dot += 1;
        }     
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
    dfs(n,0);
    // cout << "first node :" << max_depth_node << "\n";
    checkInterval(max_depth_node,0,0);
    cout  << is_it_interval << "\n";
    if(is_it_interval == -1 ) return 0; 
    sort(answer.begin(),answer.end());
    for(int i=0; i<answer.size(); i++){
        cout << answer[i].second.first << " " << answer[i].second.second << "\n"; 
    }
}