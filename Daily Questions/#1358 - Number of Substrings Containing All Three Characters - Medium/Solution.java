class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0, cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            
            while (freq.size() == 3) {
                cnt += s.length() - i;
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                if (freq.get(s.charAt(left)) == 0) {
                    freq.remove(s.charAt(left));
                }
                left++;
            }
        }
        
        return cnt;
    }
}