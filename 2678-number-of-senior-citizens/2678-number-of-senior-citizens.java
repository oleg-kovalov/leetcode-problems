class Solution {
    public int countSeniors(String[] details) {
        int result = 0;
        for (String detail: details)
        {
            if (detail.charAt(11) > '6' ||
            (detail.charAt(11) == '6' && detail.charAt(12) > '0'))
            {
             
                result += 1;
            }
            
        }

        return result;
    }
}