import java.util.ArrayList;
import java.util.Collections;

//Attempt #1 - roughly 20mins
class Solution {
    public String reverseWords(String s) {
        ArrayList<String> sans = new ArrayList<String>(); //to store tokenized words
        StringBuilder sb = new StringBuilder();
        s.trim();
        int j = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==' ')
            {
                sans.add(s.substring(j,i));
                j=i;
            }
            else if(i==s.length()-1)
            {
                sans.add(s.substring(j,i+1));
                j=i;
                break;
            }
        }
        sans.removeAll(Collections.singleton(" "));
        for(int i=0; i<sans.size(); i++)
        {
            String tes = sans.get(i).trim();
            sb.append(reverse(tes) + " ");
        }
        String ans = sb.toString();
        //System.out.println(sans);
        return ans.trim();
    }
    public String reverse(String s)
    {
        String ans = "";
        for(int i=0; i<s.length(); i++)
        {
            ans+=s.charAt(s.length()-i-1);
        }
        return ans;
    }
}
/*
29 / 29 test cases passed.
Status: Accepted
Runtime: 112 ms (beats 17%)
Memory Usage: 71.9 MB (beats 24%)
Time Complexity: O(n^2)
 */

 //Solution #1
 class Solution2 {

    public String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] chArray = s.toCharArray();
        int len = s.length();
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                while (startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }
}
/*

29 / 29 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 42.6 MB
Time Complexity: O(n) The outer loop iterates over N characters to find the start and 
end index of every word. The algorithm to reverse the word also iterates N times to 
perform N/2 swaps. Thus, the time complexity is (N + N) = O(N).
Space Complexity: O(1)
 */