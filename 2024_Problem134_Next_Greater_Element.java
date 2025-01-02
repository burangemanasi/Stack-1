//503. Next Greater Element 2 - https://leetcode.com/problems/next-greater-element-ii/description/
//Time Complexity: O(2n)
//Space Complexity: O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        //if next greater numbers doesn't exists, return -1
        Arrays.fill(result, -1);

        //since 2 pass is allowed
        for(int i=0; i<2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            st.push(i%n);
        }
        return result;
    }
}
