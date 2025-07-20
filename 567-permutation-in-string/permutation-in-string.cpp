class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s1.length() > s2.length()) return false;

        vector<int> s1Freq(26, 0), windowFreq(26, 0);

        for (char c : s1) s1Freq[c - 'a']++;

        int matchCount = 0;
        int requiredMatches = 26;

        // Preprocess the first window
        for (int i = 0; i < s1.length(); ++i) {
            windowFreq[s2[i] - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if (s1Freq[i] == windowFreq[i]) matchCount++;
        }

        if (matchCount == requiredMatches) return true;

        // Slide window
        for (int i = s1.length(); i < s2.length(); ++i) {
            int add = s2[i] - 'a';
            int remove = s2[i - s1.length()] - 'a';

            // Handle removing left char
            if (s1Freq[remove] == windowFreq[remove]) matchCount--;
            windowFreq[remove]--;
            if (s1Freq[remove] == windowFreq[remove]) matchCount++;

            // Handle adding right char
            if (s1Freq[add] == windowFreq[add]) matchCount--;
            windowFreq[add]++;
            if (s1Freq[add] == windowFreq[add]) matchCount++;

            if (matchCount == requiredMatches) return true;
        }

        return false;
    }
};
