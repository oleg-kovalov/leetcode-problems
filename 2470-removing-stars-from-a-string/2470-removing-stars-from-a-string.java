class Solution {
    public String removeStars(String s) {
        LinkedList<Character> result = new LinkedList<>();
        char[] str = s.toCharArray();

        result.push(str[0]);
        for (int i=1; i < s.length(); i++)
        {
            if (str[i] == '*')
            {
                result.pop();
            } else {
                result.push(str[i]);
            }
        }

        StringBuilder resSB = new StringBuilder();
        result.forEach(resSB::append);

        return resSB.reverse().toString();
    }
}