class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        
        for (String str: strs)
        {
            char[] keyArr = str.toCharArray();
            Arrays.sort(keyArr);
            String keyStr = new String(keyArr);

            List<String> list = groups.putIfAbsent(keyStr, new ArrayList<>());
            groups.get(keyStr).add(str); 
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> value: groups.values())
        {
            result.add(value);
        }


        return result;
    }


}