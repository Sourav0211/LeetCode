class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s2.length() < s1.length()) return false;

        vector<int> s1Freq(26,0);
        vector<int> s2Freq(26,0);

        for(char ch: s1)
        {
            s1Freq[ch - 'a']++;
        }

        for(int i = 0;i<s1.length();i++)
        {
            s2Freq[s2[i] - 'a']++;
        }
        if(s1Freq ==s2Freq) return true;

        for(int k = s1.length(); k<s2.length();k++)
        {
            s2Freq[s2[k] - 'a']++;

            s2Freq[ s2[k - s1.length()]- 'a']--;

            if(s1Freq == s2Freq) return true;
        }

        return false;
    }
};