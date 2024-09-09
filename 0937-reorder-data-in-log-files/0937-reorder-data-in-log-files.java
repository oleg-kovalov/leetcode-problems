class Solution {
    public String[] reorderLogFiles(String[] logs)
    {
        Arrays.sort(logs,
            (s1, s2) -> {
                // if letters - 0, if  digits - 1
                boolean isdigit1 = s1.charAt(s1.indexOf(' ') + 1) - 'A' < 0;
                boolean isdigit2 = s2.charAt(s2.indexOf(' ') + 1) - 'A' < 0;

                if (isdigit1 && isdigit2)
                {
                    return 0;
                } else if (isdigit1 && !isdigit2)
                {
                    return 1;
                } else if (!isdigit1 && isdigit2)
                {
                    return -1;
                } else {
                    return Comparator.comparing((String s) -> s.substring(s.indexOf(' ') + 1))
                        .thenComparing((String s) -> s.substring(0, s.indexOf(' ')))
                        .compare(s1, s2);
                }

            });

        return logs;
    }
}