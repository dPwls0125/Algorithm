#include <stdlib.h>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> nums)
{
    map<int, int> m;
    int answer = 0;
    int getNum = nums.size() / 2;
    // cout << "getNum: " << getNum << "\n";
    for (int i = 0; i < nums.size(); i++)
    {
        int kind = nums[i];
        // if (m.find(kind) == m.end())
        // {
        //     m.insert(make_pair(nums[i], 1));
        // }
        // else
        //     m[kind] += 1;
        m[kind]++;
    }
    // cout << "maps"
    //      << "\n";
    // for (auto iter : m)
    // {
    //     cout << "key: " << iter.first;
    //     cout << "value: " << iter.second << "\n";
    // }
    int kinds = m.size();
    // cout << "kinds : " << kinds << "\n";
    if (getNum < m.size())
    {
        answer = getNum;
    }
    else
        answer = m.size();
    return answer;
}
int main()
{
    int nums1[4] = {3, 1, 2, 3};
    int nums2[6] = {3, 3, 3, 2, 2, 4};
    int nums3[6] = {3, 3, 3, 2, 2, 2};

    vector<int> v1;
    vector<int> v2;
    vector<int> v3;

    for (auto iter : nums1)
        v1.push_back(iter);
    for (auto iter : nums2)
        v2.push_back(iter);
    for (auto iter : nums3)
        v3.push_back(iter);

    cout << solution(v1) << '\n';
    cout << solution(v2) << '\n';
    cout << solution(v3) << '\n';
}