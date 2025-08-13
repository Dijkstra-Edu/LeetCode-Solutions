class Solution {
public:
    string reverseWords(string s) {
        int left = 0;
        int right = s.length()-1;
    
        string temp="";
        string ans="";
    
        //Iterate the string and keep on adding to form a word
        //If empty space is encountered then add the current word to the result
        while (left <= right) {
            char ch= s[left];
            if (ch != ' ') {
                temp += ch;
            } else if (ch == ' ') {
                if (ans!="") ans = temp + " " + ans;
                else ans = temp;
                temp = "";
            }
            left++;
        }
    
        //If not empty string then add to the result(Last word is added)
        if (temp!="") {
            if (ans!="") ans = temp + " " + ans;
            else ans = temp;
        }
    
        return ans; 
    }
};