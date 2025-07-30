class Solution {
    public int longestValidParentheses(String s) {
       int right = 0;
       int left =0;
       int max =0;

       for(char ch : s.toCharArray())
       {
        if(ch == ')')
        {
            right++;
        }
        if(ch == '(')
        {
            left++;
        }
        if(right > left)
        {
            left = 0;
            right = 0;
            continue;
        }

        if(left == right)
        {
            max = Math.max(max, left + right);
        }
        
       }
        left = 0;
        right = 0;
       for(int i = s.length() - 1 ; i>=0 ;i--)
       {
        if(s.charAt(i) == ')')
        {
            right++;
        }
        if(s.charAt(i) == '(')
        {
            left++;
        }
        if(left > right)
        {
            left = 0;
            right = 0;
            continue;
        }

        if(left == right)
        {
            max = Math.max(max, left + right);
        }
        
       }

       return max;
    }
}