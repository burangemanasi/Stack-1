//739. Daily Temperatures - https://leetcode.com/problems/daily-temperatures/description/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Using Stack cz we need to resolve the future elements first in order to solve the current element
//keep pushing unresolved problems in stack, pop when can be resolved
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int poppedTemp = st.pop();
                result[poppedTemp] = i - poppedTemp;
            }
            st.push(i);
        }
        return result;
    }
}