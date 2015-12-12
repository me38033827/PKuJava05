/*
Count Primes
 Description:
 
Count the number of prime numbers less than a non-negative number, n.

*/


public class Solution {
    
    public int countPrimes(int n) {
        int count = 0;
        boolean[] num = new boolean[n];//default value is false
        for(int i = 2; i < n; i++) {
            if(!num[i]) {
                count++;
                for(int j = 2 * i; j < n; j +=i)
                    if(!num[j])
                       num[j] =true;
            }
        }
        return count;
    }
    /*
    public int countPrimes(int n) {
        int count=0;
        for(int i=1;i<n;i=i+2){
            if(isPrims(i))
             count++;
        }
        if(n>2) return count+1;
        return count;
    }
    public boolean isPrims(int n){//nÊÇÆæÊı
        if(n<=1) return false;
        for(int i=3;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    */
}


    
