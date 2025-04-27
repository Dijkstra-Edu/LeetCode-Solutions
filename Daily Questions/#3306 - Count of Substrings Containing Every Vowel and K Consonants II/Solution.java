class Solution {
    public long countOfSubstrings(String word, int k) {
        return atleast(k, word)-atleast(k+1, word);
    }
    private boolean isAllVowelPresent(int[] freq)
    {
        return (freq['a'-'a']>0 && freq['e'-'a']>0 && freq['i'-'a']>0 && 
            freq['o'-'a']>0 && freq['u'-'a']>0);
    }
    private boolean isConsonant(char ch)
    {
        return (ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u');
    }
    private long atleast(int k, String word)
    {
        int n=word.length();
        int[] freq=new int[26];
        int currConsonant=0;
        long cnt=0;
        int left=0;
        for(int right=0;right<n;right++)
        {
            char ch=word.charAt(right);
            if(isConsonant(ch)) currConsonant++;
            freq[ch-'a']++;
            while(currConsonant>=k && isAllVowelPresent(freq))
            {
                cnt+=(n-right);
                char c=word.charAt(left);
                if(isConsonant(c)) currConsonant--;
                freq[c-'a']--;
                left++;
            }
        }
        return cnt;
    }
}
