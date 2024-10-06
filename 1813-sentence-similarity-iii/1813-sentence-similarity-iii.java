class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        

        int startCount = 1;
        while (startCount <= Math.min(words1.length, words2.length) && words1[startCount - 1].equals(words2[startCount - 1]))
        {
            startCount++;
        }
        startCount--;
        System.out.println("start count: " + startCount);



        int endCount = 1;
        while (endCount + startCount <= Math.min(words1.length, words2.length) && words1[words1.length - 1 - endCount + 1].equals(words2[words2.length - 1 - endCount + 1]))
        {
            endCount++;
        }
        endCount--;
        System.out.println("end count: " + endCount);

        StringBuilder result = new StringBuilder();
        for (int i=0; i<startCount; i++)
        {
            result.append(words1[i]).append(" ");
        }
        for (int i= words1.length -1 - endCount + 1; i < words1.length ; i++)
        {
            result.append(words1[i]).append(" ");
        }

        String resultString = result.toString().trim();
        System.out.println("result: " + resultString);

        return resultString.equals(sentence1) || resultString.equals(sentence2);

    }
}