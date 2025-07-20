class Solution {
    Boolean[][] visited;
    public boolean checkValidString(String s) {
        
        visited = new Boolean[s.length()][s.length()];
        return backtrack(0, 0, s);

    }

    private boolean backtrack(int idx, int balance, String s)
    {
        if (idx == s.length()) return balance == 0;

        if (balance < 0) return false; // more close brackets than open

        if (visited[idx][balance] != null) return visited[idx][balance];

        char c = s.charAt(idx);
        if (c == '(')
        {
            return visited[idx][balance] = backtrack(idx + 1 , balance + 1, s);
        } else if (c == ')')
        {
            return visited[idx][balance] = backtrack(idx + 1, balance - 1, s);
        } else {
            return visited[idx][balance] = 
            backtrack(idx + 1, balance, s) //empty
            || backtrack(idx + 1, balance + 1, s) //open
            || backtrack(idx + 1, balance - 1, s); // close 
        }
    }
}