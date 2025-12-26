class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans = "";
        sort(strs.begin(), strs.end());
        string prefix = strs[0];
        string end = strs[strs.size()-1];
        int n = 0;
        for(int i = 0; i<min(prefix.size(), end.size()); i++){
            if(prefix[i] != end[i]){
                n = i;
                break;
            }
            ans += prefix[i];
        }
        return ans;
    }
};