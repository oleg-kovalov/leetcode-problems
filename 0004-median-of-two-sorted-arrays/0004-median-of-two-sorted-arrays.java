class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int k;
        if (size % 2 == 1)
        {
            return rec(0, nums1.length-1, 0, nums2.length-1, (size+1)/2, nums1, nums2);
        }
        else {
            return ((double)
                (
                    rec(0, nums1.length-1, 0, nums2.length-1, (size)/2, nums1, nums2)
                        + rec(0, nums1.length-1, 0, nums2.length-1, (size)/2 + 1, nums1, nums2)
                ) / 2
            );
        }

    }

    private int rec (int lo1, int hi1, int lo2, int hi2, int k, int[] nums1, int[] nums2)
    {
        if (hi1 < lo1) return nums2[lo2 + k - 1];
        if (hi2 < lo2) return nums1[lo1 + k - 1];


        int mid1 = (lo1 + hi1) / 2;
        int mid2 = (lo2 + hi2) / 2;


        if (k >= mid1 - lo1 + 1 + mid2 - lo2 + 1)
        {
            // cut one smallest half
            // decreate K by count of smallest elements in removed half
            if (nums1[mid1] < nums2[mid2])
            {
                return rec(mid1+1, hi1, lo2, hi2, k - (mid1 - lo1 + 1), nums1, nums2);
            } else
            {
                return rec(lo1, hi1, mid2+1, hi2, k - (mid2 - lo2 + 1), nums1, nums2);
            }
        } else {
            // cut one largest half
            // removal doesn't change K
            if (nums1[mid1] < nums2[mid2])
            {
                return rec(lo1, hi1, lo2, mid2-1, k, nums1, nums2);
            } else {
                return rec(lo1, mid1-1, lo2, hi2, k, nums1, nums2);
            }
        }

    }
}