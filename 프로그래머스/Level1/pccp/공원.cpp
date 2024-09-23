#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool isItPossible(int i, int j, int mat_index,vector<int> mats,vector<vector<string> > park,int park_width,int park_height){
    // park 인덱스를 벗어나면 불가능 처리 
    if((i+mats[mat_index]-1 >= park_height || j+mats[mat_index]-1 >= park_width)) return false;
    
    for(int k = i; k < i + mats[mat_index]; k++){
        for(int l = j; l < j + mats[mat_index]; l++){
            if(park[k][l] != "-1" )
                return false;
        }
    }
    return true;
}

int solution(vector<int> mats, vector<vector<string> > park) {

    int length = 0;
    int possible_max_mat = 0; 
    int park_height = park.size();
    int park_width = park[0].size();

    for(int i=0; i<park.size(); i++){
        for(int j=0; j<park[i].size(); j++){
            for(int mat = 0; mat < mats.size(); mat++){
                if(isItPossible(i,j,mat,mats,park,park_width,park_height)){
                    // cout << mats[mat];
                    if(mats[mat] > possible_max_mat) possible_max_mat = mats[mat];
                }
            }
        }
    }

    if(possible_max_mat == 0) return -1 ;
    return possible_max_mat;
}

// int main() {
//     vector<vector<string>>park = 
//     {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"},
//      {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, 
//      {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
//       {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
//       vector<int> mats= {5,3,2};
//     cout << solution(mats,park);
// }