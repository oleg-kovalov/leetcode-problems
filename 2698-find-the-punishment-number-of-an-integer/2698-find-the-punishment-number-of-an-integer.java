class Solution {
    public int punishmentNumber(int n) {

        int result = 0;

        for (int num=1; num <= n; num++)
        {
            int square = num * num;
            if (canPartition(String.valueOf(square), num))
            {
                result += square;
            }
        }

        return result;  
    }

    private boolean canPartition(String sequence, int target)
    {

        if (target < 0) return false;

        if (target == 0 && sequence.length() == 0) return true;

        for (int i=0; i<sequence.length(); i++)
        {
            String left = sequence.substring(0, i+1);
            String right = sequence.substring(i+1);

            if (canPartition(right, target - Integer.valueOf(left)))
            {
                return true;
            }
        }

        return false;
    }
}