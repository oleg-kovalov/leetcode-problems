class Solution {
    Map<Long, Double> cache = new HashMap<>(); // 1->5 2-> 25 4->625 9-> ...
    public double myPow(double base, int power)
    {
        if (base == 0) return 0;
        if (power == 0) return 1;
        
        boolean negBase = base < 0;
        boolean negPow = power < 0;
        boolean oddPow = power % 2 != 0;

        cache.put(1L, base);
        double result= rec( negBase ? -base : base, negPow ? -1L * power: power);
        result = (negPow ? (1/result) : result);
        return (negBase && oddPow ? -result : result);

    }
    private double rec(double base, long power) // 1
    {
        System.out.println(power);
        if (cache.containsKey(power)) return cache.get(power);

        boolean even = (power % 2 == 0);
        double result = rec(base, power/2) // 4
                      * rec(base, power/2) // 4
                      * (even ? 1 : base);
        
        cache.put(power, result);
        return result;
    }
}