class Solution {
    public int minSteps(int n) {
        int primeFactorsSum = 0;
        
        int div = 2;
        while (div <= n)
        {
            while (n % div == 0)
            {
                primeFactorsSum += div;
                n = n / div;
            }
            
            div++;
        }        

        return primeFactorsSum;
    }
}