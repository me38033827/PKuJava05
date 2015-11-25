public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> s=new HashSet<Integer>();
        while(n!=1)
        {
            n=adddigit(n);
            if(s.contains(n)) return false;
            s.add(n);
        }
        return true;
    }
    
    public int adddigit(int n){
        int result=0;
        while(n!=0){
            int digit=n%10;
            result+=digit*digit;
            n/=10;
        }
        return result;
    }
}