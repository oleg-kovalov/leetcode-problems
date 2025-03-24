class Solution {
    public boolean areAlmostEqual(String s1, String s2) {        
        List<int[]> mismatches = new ArrayList<>();

        for (int i=0; i<s1.length(); i++)
        {
            if (s1.charAt(i) != s2.charAt(i))
            {
                if (mismatches.size() == 2) return false;
                mismatches.add(new int[]{s1.charAt(i), s2.charAt(i)});
            }
        }

        if (mismatches.size() == 0) return true;
        if (mismatches.size() == 1) return false;

        return mismatches.get(0)[0] == mismatches.get(1)[1] && mismatches.get(0)[1] == mismatches.get(1)[0];
    }
}