/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    const m = nums1.length;
    const n = nums2.length;
    if (m > n) return findMedianSortedArrays(nums2, nums1);
    const median = Math.ceil((m + n) / 2);
    const is_odd = (m + n) % 2 === 1;
    let lo = 0;
    let hi = m;
    while (lo <= hi) {
        const m1 = lo + Math.floor((hi - lo) / 2);
        const m2 = median - m1;
        let min1 = m1 === 0 ? -Infinity : nums1[m1 - 1];
        let max1 = m1 === m ? Infinity : nums1[m1];
        let min2 = m2 === 0 ? -Infinity : nums2[m2 - 1];
        let max2 = m2 === n ? Infinity : nums2[m2];
        if (min1 <= max2 && min2 <= max1) {
            if (is_odd) return Math.max(min1, min2);
            return (Math.max(min1, min2) + Math.min(max1, max2)) / 2;
        } else if (min1 > max2) {
            hi = m1 - 1;
        } else 
            lo = m1 + 1;
    }
};