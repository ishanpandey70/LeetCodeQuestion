int start  = 0 ;
int length = s.length();
if(length==1)
{
return s;
}
while (start<s.length())
{
if(s.charAt(start) == '*')
{
if(start == 1)
{
s = s.substring(2);
start =0;
}
else
{
start = start -2;
s= s.substring(0,start+1)+ s.substring(start+3);
}
}
start++;
}
return s;