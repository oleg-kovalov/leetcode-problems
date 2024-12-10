class Solution {
    public int maximumLength(String s) {
        
        int max = -1;
        for (int start=0; start < s.length() - 2; start++)
        {
            for (int end=start + 1; end <= s.length(); end++)
            {
                if (end > start + 1 && s.charAt(end-1) != s.charAt(end-2)) break;

                String substr = s.substring(start, end);
                int secondMatch = s.indexOf(substr, start + 1);
                if (secondMatch == -1) break;
                int thirdMatch = s.indexOf(substr, secondMatch + 1);
                if (thirdMatch == -1) break;

                max = Math.max(max, substr.length());
                System.out.println("found " + substr);
            }
        }

        return max;

    }
}