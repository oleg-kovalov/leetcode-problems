class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {

        Set<Integer> s1 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }

        Set<Integer> s2 = new HashSet<>();
        for (int i : nums2) {
            s2.add(i);
        }

        Set<Integer> common = new HashSet<>(s1);
        common.retainAll(s2);

        int n = nums1.length;

        if (s1.size() - common.size() >= n/2 && s2.size() - common.size() >= n/2)
        {
            //case 1
            return n;
        }

        if (s1.size() - common.size() >= n/2 && s2.size() - common.size() < n/2)
        {
            // case 2
            int result = 0;
            result += n/2; //n/2 from s1 - common
            result += s2.size() - common.size(); // all from s2 - common
            if (common.size() >= (n/2 - (s2.size()-common.size())))
            {
                result += n/2 - (s2.size()-common.size()); // as much as needed from common
            } else {
                result += common.size();  // up to common size
            }
            return result;
        }

        if (s1.size() - common.size() < n/2 && s2.size() - common.size() >= n/2)
        {
            // case 3
            return n/2 // n/2 from s2 - common
             + s1.size() - common.size() // all from s1 - common
                + Math.min(n/2 - (s1.size() - common.size()), common.size()); // up to needed from common
        }

        if (s1.size() - common.size() < n/2 && s2.size() - common.size() < n/2)
        {
            // case 4
            return
                s1.size() - common.size() // all from s1 - common
            + s2.size() - common.size() // all from s2 - common
            + Math.min(
                n/2 - (s1.size() - common.size()) + n/2 - (s2.size() - common.size()), // needed from common
                common.size()); // up to common size

        }

        //never reach here
        return -1;
    }
}