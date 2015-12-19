public class Solution {
    /*private boolean isPrime(int num) {
        if (num <= 1) return false;
        //for (int i = 2; i <= math.sqrt(num); i++) {
        for (int i = 2; i*i<=num; i++) {
            if (num % i == 0) return false;
        }
        return true;
}*/
    public int countPrimes(int n) {
        /*int i=2,count=0;
        while(i<=n){
            while(n%i==0){
                count++;
                n/=i;
            }
            i++;
        }
        return count;*/
        /*int count=1,i,j;
        for(i=3;i<n;i++){
            if(i%2==0||i%3==0||i%5==0||i%7==0)
                continue;
            if(isPrime(i)==false)
                count++;
            
        }
        return count;*/
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i ; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}