class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        unordered_map<char, char> m;
        m[']'] = '[';
        m[')'] = '(';
        m['}'] = '{';

        for(char ch : s){
            if(m.find(ch) != m.end()){
                if(st.empty())return false;
                if(st.top() == m[ch]){
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(ch);
            }
        }

        return st.size() == 0;

        // return true;
    }
};
