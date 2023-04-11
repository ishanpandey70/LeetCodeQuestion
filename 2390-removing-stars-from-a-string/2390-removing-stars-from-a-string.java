class Solution {
    public String removeStars(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        int start  = 0 ;
        int length = s.length();
        if(length==1)
        {
            return s;
        }
        for(int i = 0 ; i<length; i++)
        {
            char ch = s.charAt(i);
            if(ch == '*')
            {
                dq.removeLast();
            }
            else
            dq.addLast(s.charAt(i));
        }
        String s1 = "";
        while(!dq.isEmpty())
        {
            s1= s1+ dq.pollFirst().toString();
        }
        
       return s1; 
    }
}