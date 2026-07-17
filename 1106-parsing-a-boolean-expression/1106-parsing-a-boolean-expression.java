class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') continue;

            if (ch != ')') {
                st.push(ch);
            } else {
                boolean hasTrue = false;
                boolean hasFalse = false;

                while (st.peek() != '(') {
                    char val = st.pop();
                    if (val == 't') hasTrue = true;
                    else hasFalse = true;
                }

                st.pop(); 
                char op = st.pop(); 

                if (op == '!') {
                    st.push(hasTrue ? 'f' : 't');
                } else if (op == '&') {
                    st.push(hasFalse ? 'f' : 't');
                } else { 
                    st.push(hasTrue ? 't' : 'f');
                }
            }
        }

        return st.pop() == 't';
    }
}
