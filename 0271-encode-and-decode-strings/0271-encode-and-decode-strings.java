public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs)
        {
            sb.append(str.replace("/", "//"));
            sb.append("/:");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        StringBuilder currWord = new StringBuilder();
        int i=0; 
        while (i < s.length())
        {
            if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i+1) == ':')
            {
                result.add(currWord.toString());
                currWord = new StringBuilder();
                i += 2;
            } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i+1) == '/')
            {
                currWord.append('/');
                i += 2;
            } else {
                currWord.append(s.charAt(i));
                i += 1;
            }
        }
        

        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));