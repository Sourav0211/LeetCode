class Solution {
    public boolean isValid(String s) {

      

       
        


        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(ch == ')' || ch == ']' || ch == '}')
            {
                if(!stack.isEmpty())
                {
                    char popped = stack.pop();

                    switch(ch)
                    {
                        case ')' : if(popped != '(') return false;
                                    else continue;
                        case '}' : if(popped != '{') return false;
                                    else continue;
                        case ']' : if(popped != '[') return false;
                                    else continue;

                    }
                }
            }
            
            stack.add(ch);
            
        }

        return stack.isEmpty();
    }
}