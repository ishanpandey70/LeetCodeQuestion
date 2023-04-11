class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int currChild  = g.length-1;
        int currCookie = s.length-1;
        
        int count=0;
        while(currChild >=0 && currCookie >=0 )
        {
            if(s[currCookie]>= g[currChild] )
            {
                currCookie--;
                currChild--;
                count++;


            }
            else currChild--;
        }
        return count;
        
    }
}