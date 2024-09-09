class Solution {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        generateParenthesisBacktrack(new StringBuilder(), n, n);

        return result;
    }

    private void generateParenthesisBacktrack(StringBuilder str, int left, int right)
    {
        if (left == 0 && right == 0)
        {
            result.add(str.toString());
            return;
        }

        if (left > 0)
        {
            generateParenthesisBacktrack(str.append("("), left-1, right);
            str.deleteCharAt(str.length()-1);
        }
        if (right > 0 && left < right)
        {
            generateParenthesisBacktrack(str.append(")"), left, right-1);
            str.deleteCharAt(str.length()-1);
        }
    }
}