class Solution {
    public int getLucky(String s, int k) {
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
        {
            sb.append(c - 'a' + 1);
        }

        String num = sb.toString();
        for (int i=0; i<k; i++)
        {
            int sum = 0;
            for (int n=0; n<num.length(); n++)
            {
                sum += num.charAt(n) - '0';
            }
            num = Integer.valueOf(sum).toString();
        }

        return Integer.valueOf(num);

    }
}