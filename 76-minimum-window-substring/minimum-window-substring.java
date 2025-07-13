class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // ASCII frequency for t
        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;

        int missing = t.length();          // total chars we still need
        int left = 0, bestStart = 0, bestLen = Integer.MAX_VALUE;
  

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);

            // Include rc in window
            if (need[rc] > 0) missing--;
            need[rc]--;                    // Decrement even if char not needed

            // When window is valid, try shrinking from left
            while (missing == 0) {
                // Update best window
                int windowLen = right - left + 1;
                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestStart = left;
                    
                }

                // Remove left char from window
                char lc = s.charAt(left);
                need[lc]++;                // Put it back into need
                if (need[lc] > 0) missing++;   // Window invalid after removing
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" 
                                            : s.substring(bestStart, bestStart + bestLen);
      
    }
}
