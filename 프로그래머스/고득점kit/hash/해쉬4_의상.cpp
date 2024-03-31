#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;
unordered_map<string, int> m;
int solution(vector<vector<string> > clothes)
{
    int answer = 1;
    for (auto list : clothes)
    {
        m[list[1]]++;
    }
    //    cout << m.size() << "\n";
    //    cout << answer<<"\n";
    for (auto iter : m)
    {
        answer *= iter.second + 1;
    }
    //    cout << temp << "\n";
    return answer - 1;
}
int main()
{
    // 2차원 벡터 선언
    vector<vector<string>> clothes;

    // [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]] 추가
    //     clothes.push_back({"yellow_hat", "headgear"});
    //     clothes.push_back({"blue_sunglasses", "eyewear"});
    //     clothes.push_back({"green_turban", "headgear"});
    clothes.push_back({"crow_mask", "face"});
    clothes.push_back({"blue_sunglasses", "face"});
    clothes.push_back({"smoky_makeup", "face"});
    cout << solution(clothes);
}
