class Solution {
public:
    string decodeString(string s) {
        stack<pair<int, string>> st;
        int num = 0;
        string currStr = "";

        for (char ch : s) {
            if (isdigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                st.push({num, currStr});
                currStr = "";
                num = 0;
            } else if (ch == ']') {
                auto [repeatTimes, prevStr] = st.top(); st.pop();
                string repeated = "";
                for (int i = 0; i < repeatTimes; ++i) {
                    repeated += currStr;
                }
                currStr = prevStr + repeated;
            } else {
                currStr += ch;  // ✅ Append instead of overwrite
            }
        }

        return currStr;
    }
};
