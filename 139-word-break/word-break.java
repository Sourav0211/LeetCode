class Solution {

    private boolean fn(int idx, String s, List<String> wordDict, Boolean[] dp)
    {

        if(idx == s.length())
        {
            return true;
        }
        if(dp[idx] != null)
        {
            return dp[idx];
        }  
       
        
   
        for(String currWord : wordDict)
        {
            int size = currWord.length();
            if(idx + size <= s.length() && s.substring(idx, idx + size).equals(currWord))
            {
                if (fn(idx + size, s, wordDict, dp)) {
                    return dp[idx] = true;
                }
            }
            
        }
        
        return dp[idx] = false;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Boolean[] dp = new Boolean[s.length() + 1];

        dp[s.length()] = true;

        for(int idx = s.length() - 1; idx >= 0 ; idx--)
        {
            for(String currWord : wordDict)
            {
                int size = currWord.length();
                if(idx + size <= s.length() && s.substring(idx, idx + size).equals(currWord))
                {
                    if (dp[idx + size] != null && dp[idx + size] == true ) {
                        dp[idx] = true;
                        break;
                    }
                }
                
            }
        
        }

        return dp[0] == null ? false : true ;
    }
}