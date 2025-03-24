class Solution {
    Set<Integer> total = new HashSet<>();
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit: digits)
        {
            count[digit] += 1;        
        }

        rec(0, count);

        return total.size();

        
    }

    private void rec(int num, int[] count)
    {
        if (num >= 100){
            
            total.add(num);
            return;
        }

        for (int i=0; i<count.length; i++)
        {
            if (count[i] == 0) continue;
            if (i == 0 && num == 0) continue;
            if (num >=10 && (i % 2 == 1)) continue;

            count[i]--;
            rec(num * 10 + i, count);
            count[i]++;
        }
        
    }
    
}