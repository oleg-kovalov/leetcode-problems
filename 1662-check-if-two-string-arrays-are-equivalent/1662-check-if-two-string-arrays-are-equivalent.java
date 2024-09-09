class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int arr1 = 0;
        int arr2 = 0;

        int c1 = 0;
        int c2 = 0;

        while (arr1 < word1.length && arr2 < word2.length)
        {
            if (word1[arr1].charAt(c1) != word2[arr2].charAt(c2))
            {
                return false;
            }

            if (arr1 == word1.length-1 && c1 == word1[arr1].length()-1
                && arr2 == word2.length-1 && c2 == word2[arr2].length()-1)
            {
                return true;
            }

            c1++;
            c2++;
            //word1 next
            if (word1[arr1].length() == c1)
            {
                arr1++;
                c1 = 0;
            }

            if (word2[arr2].length() == c2)
            {
                arr2++;
                c2 = 0;
            }
        }

        return false;
    }
}