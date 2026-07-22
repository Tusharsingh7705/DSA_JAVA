class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int moves=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){
                    moves++;
                }
                else{
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            moves++;
            st.pop();
        }
        return moves; 
    }
}