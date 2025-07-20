class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        // Initialize stack for circular behavior
        for (int i = n - 1; i >= 0; i--) {
            st.push(nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
}
