#include <bits/stdc++.h> 
vector<int> mergeKSortedArrays(vector<vector<int>>&kArrays, int k)
{
    priority_queue<int, vector<int>, greater<int>> q;
    vector<int> result;
    for(int i=0; i<kArrays.size(); i++){
        for(int j=0; j<kArrays[i].size(); j++){
            q.push(kArrays[i][j]);
        }
    }
    while(!q.empty()){
        result.push_back(q.top());
        q.pop();
    }
    return result;
}
