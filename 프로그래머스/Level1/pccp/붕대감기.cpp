#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution1(vector<int> bandage, int health, vector<vector<int>> attacks) {

    int answer = 0;

    int final_attack_time = attacks[attacks.size()-1][0]; // 인덱스 주의!
    int attack_arr[final_attack_time];
    int current_success_time = 0; 
    int current_stamina = health;
    
    fill_n(attack_arr,final_attack_time,0);

    for(int i=0; i<attacks.size(); i++){
        attack_arr[attacks[i][0]-1] = attacks[i][1];
    }
    for(int i=0; i<final_attack_time; i++){
        // attack 당한 경우
        if(attack_arr[i] > 0){
          current_stamina -=  attack_arr[i];
          current_success_time = 0; 
          if(current_stamina <= 0) return -1;
        }
        //attack 안당한 경우 == 기술 성공한 경우 
        else{
            current_stamina += bandage[1];
            current_success_time +=1;

            if(current_success_time == bandage[0]){
                current_success_time = 0; 
                current_stamina += bandage[2];
            }
            if(current_stamina > health) current_stamina = health;
        }
    }
    answer = current_stamina; 
    return answer;
}


int main() {
    vector<int>bandage = {5,1,5};
    int health = 30; 
    vector<vector<int> >attacks = {{2,10},{9,15},{10,5},{11,5}};

    cout << solution1(bandage,health,attacks);

}