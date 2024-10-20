class Solution {
    public List<String> stringSequence(String target) {
        List<String> resultList = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        for (char c: target.toCharArray())
        {
            char resultChar = 'a';
            while (c - resultChar != 0)
            {
                resultList.add(builder.toString() + resultChar);
                resultChar++;
            }
            resultList.add(builder.toString() + resultChar);
            builder.append(resultChar);
        }

        return resultList;
    }
}