class Solution {
    List<String> result = new ArrayList<>();
    int open = 0; // 2

    public List<String> generateParenthesis(int n) {

        backtrack('(', new StringBuilder(), n * 2 - 1);

        return result;    
    }

    private void backtrack(char curr, StringBuilder builder, int n) 
    {
        if (n < 0 || open < 0) return;

        open += (curr == '(') ? 1 : -1;

        builder.append(curr);


        if (n == 0 && open == 0) 
        {
            result.add(builder.toString());
        } 

        backtrack('(', builder, n - 1);
        backtrack(')', builder, n - 1);

        builder.deleteCharAt(builder.length() - 1);
        open -= (curr == '(') ? 1 : -1;
        
    }
}