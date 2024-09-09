class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;
        boolean oneDeleted = false;
        boolean leftDeleted = false;
        int deletedIndex = -1;
        boolean secondAttempt = false;

        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end))
            {
                if (oneDeleted){
                    if (secondAttempt)
                    {
                        return false;
                    } else {
                        secondAttempt = true;
                        System.out.println("second attempt");
                        if (leftDeleted)
                        {
                            start = deletedIndex;
                            System.out.println("deleted: " + s.charAt(s.length() - 1 - start));
                            end = s.length() - 1 - start - 1;
                        } else {
                            end = deletedIndex;
                            System.out.println("deleted: " + s.charAt(s.length() - 1 - end));
                            start = s.length() - 1 - end + 1;
                        }
                    }
                    continue;
                }

                if (s.charAt(start+1) == s.charAt(end))
                {
                    System.out.println("remove: " + s.charAt(start));
                    deletedIndex = start;
                    start = start + 1;
                    oneDeleted = true;
                    leftDeleted = true;
                } else if (s.charAt(start) == s.charAt(end-1))
                {
                    System.out.println("remove: " + s.charAt(end));
                    deletedIndex = end;
                    end = end - 1;
                    oneDeleted = true;
                    leftDeleted = false;
                } else {
                    return false;
                }
            }

            start += 1;
            end -= 1;

        }

        return true;
    }
}