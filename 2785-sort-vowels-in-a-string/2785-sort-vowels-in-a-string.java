class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('A','a','E','e','I','i','O','o','U','u');

        Character[] sortedVowels = new Character[s.length()];

        int[] count = new int['z' - 'A']; // array with count for each vowel
        for (int i=0; i<s.length(); i++)
        {
            char current = s.charAt(i);
            if (vowels.contains(current))
            {
                count[current - 'A']++;
            }
        }

        // add prefix sum to count array
        for (int i=1; i<count.length; i++)
        {
            count[i] = count[i] + count[i-1];
        }

        // calculate sorted array from input and count
        for (int i=s.length()-1; i>=0; i--)
        {
            char current = s.charAt(i);
            if (vowels.contains(current))
            {
                int countNum = count[current - 'A'];
                sortedVowels[countNum - 1] = current;
                count[current - 'A']--;
            }
        }

//        System.out.println("sorted: " + Arrays.toString(sortedVowels));

        LinkedList<Character> sortedLL = new LinkedList<>(Arrays.asList(sortedVowels));
        Iterator<Character> iterator = sortedLL.iterator();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<s.length(); i++)
        {
            char current = s.charAt(i);
            if (vowels.contains(current)) {
                result.append(iterator.next());
            } else {
                result.append(current);
            }
        }


        return result.toString();
    }
}