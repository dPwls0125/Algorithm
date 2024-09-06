#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

vector<int> solution(vector<vector<int> > edges) {

    int max_node = 0;
    int extra_node; 
    for(int i=0; i<edges.size(); i++){
        if(edges[i][0] > max_node) max_node = edges[i][0];
        if(edges[i][1] > max_node) max_node = edges[i][1];
    }
    
    vector<pair<int,int> >degree;
    fill_n(degree.begin(),max_node+1,make_pair(0,0));

    // outdegree, indegree counting
    for(int i=0; i<edges.size(); i++){
        // outdegree
        ++degree[edges[i][0]].first;
        // indegree
        ++degree[edges[i][1]].second;
    }
    // extra node 찾기
    for(int i=1; i<=max_node; i++){
        int outdegree = degree[i].first;
        int indegree = degree[i].second;
        if(outdegree >= 2 && indegree ==0 ) {
            extra_node = i;
            break;
        }
    }

    queue<int>extra_edges;
    int total_shape_graph = 0;

    // extra_node와 연결된 간선 찾기 
    for(int i=0; i<edges.size(); i++){
        if(edges[i][0] == extra_node){
            extra_edges.push(edges[i][1]);
            ++total_shape_graph;
        }
    }
    
    // extra_node와 연결된 간선 제거 
    while(!extra_edges.empty()){
        int edge = extra_edges.front(); extra_edges.pop();
        --degree[edge].second; // indegree 하나 제거 
    }
    
    vector<int> answer;
    fill_n(answer.begin(),4,0);
    answer[0]  = extra_node;

    for(int i=1; i<=degree.size(); i++){
        int outdegree = degree[i].first;
        int indegree = degree[i].second;
        // 막대 
        if(indegree == 1 && outdegree ==0)
            ++answer[2];
        //8자 모양 도넛
        if(outdegree == 2 && indegree==2) {
            ++answer[3];
        }
    }
    answer[1] = total_shape_graph - answer[2] - answer[3];
    return answer;
}

int main() {
    vector<vector<int> > edges;
  // 벡터에 값 추가 (명시적으로 벡터 생성)
    edges.push_back(vector<int>{2, 3});
    edges.push_back(vector<int>{4, 3});
    edges.push_back(vector<int>{1, 1});
    edges.push_back(vector<int>{2, 1});
    
    vector<int>answer = solution(edges);
    for(int i=0; i<3; i++){
        cout << answer[i]<< " ";
    }
    return 0; 
}