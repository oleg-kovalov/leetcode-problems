class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] sieve = new boolean[1001];
        List<Integer> primes = sieveOfEratosthenes(sieve);

        int prev = -1;
        for (int i=0; i<nums.length; i++)
        {
            int num = nums[i];
            int pid = 0;
            while (pid < primes.size() && primes.get(pid) < num && num - primes.get(pid) > prev)
            {
                pid++;
            }

            if (pid > 0) num = num - primes.get(pid-1);
            if (num <= prev) return false;
            prev = num;
        }

        return true;

    }


    private List<Integer> sieveOfEratosthenes(boolean[] sieve)
    {
        List<Integer> primes = new ArrayList<>();
        for (int i=2; i<sieve.length; i++)
        {
            if (!sieve[i])
            {
                primes.add(i);
                for (int mark=i*i; mark < sieve.length; mark += i)
                {
                    sieve[mark] = true;
                }
            }
        }

        return primes;
    }

}