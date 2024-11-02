class Solution {
    public boolean isCircularSentence(String sentence) {

        int fromIdx = 0;
        while (sentence.indexOf(' ', fromIdx) != -1)
        {
            int spaceIdx = sentence.indexOf(' ', fromIdx);
            if (sentence.charAt(spaceIdx - 1) != sentence.charAt(spaceIdx + 1)) return false;

            fromIdx = spaceIdx + 1;
        }

        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);       
    }
}