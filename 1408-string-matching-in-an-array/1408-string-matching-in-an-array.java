class Solution {
    public List<String> stringMatching(String[] words) {

        List<String> result = new ArrayList<>();
        Arrays.sort(words);
        for (int i=0; i<words.length-1; i++)
        {
            String word = words[i];
            for (int j=i+1; j<words.length; j++)
            {
                if (words[j].contains(word)) 
                {
                    result.add(word);
                    break;
                }
            }
        }

        return result;        
    }
}