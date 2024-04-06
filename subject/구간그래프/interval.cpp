#include <iostream>
#include <string>
#include <vector>
#include <fstream>
using namespace std;

vector<int> graph[10001];
bool visited[10001]; 
int is_it_interval = 1;
vector<pair<int,pair<int,int> > >answer;
int first_node;
void checkInterval(int node, int dot, int end_point) {
    visited[node] = true;
    int count = 0;
    int linked_size = graph[node].size();
    
    // 구간 생성
    if(linked_size == 1){ //dot인 경우
      answer.push_back(make_pair(node,make_pair(dot,dot))); // leaf_node인 경우
      if(node != first_node) dot += 1;  // 첫번째 노드인 경우, 다음 도트의 시작점을 그대로 둠.
    }else if(linked_size > 1) {
        int new_end = end_point+(linked_size-1);
        answer.push_back(make_pair(node,make_pair(end_point,new_end)));
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
            dot += 1; // 꺅~~~ 매우 중요! 
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
    int leaf_node = 0; 
    for(int i=1; i<=n; i++){
        if(graph[i].size() == 1) {
            leaf_node = i;
            break;
        }
    }
    first_node = leaf_node; // 리프노드부터 시작하기 때문에 무조건 dot임.
    checkInterval(leaf_node,0,0);
    cout  << is_it_interval << "\n";
    if(is_it_interval == -1 ) return 0; 
    for(int i=0; i<answer.size(); i++){
        cout << "node:"<<answer[i].first << "first: " << answer[i].second.first << "second: "<<answer[i].second.second << "\n";
    }
}