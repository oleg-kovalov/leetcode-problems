class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();

        for (int i=0; i<currentState.length()-1; i++)
        {
            char current = currentState.charAt(i);
            char next = currentState.charAt(i+1);
            if (current - '+' == 0 && next -'+' == 0)
            {
                String currentRes= "";
                if (i > 0)
                {
                    currentRes += currentState.substring(0, i);
                }
                currentRes += "--";
                if (i < currentState.length()-2)
                {
                    currentRes += currentState.substring(i+2);
                }
                result.add(currentRes);
            }
        }

        return result;
    }
}