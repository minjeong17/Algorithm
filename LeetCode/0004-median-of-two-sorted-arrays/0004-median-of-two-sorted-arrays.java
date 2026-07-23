import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        for (int n : nums1) list.add(n);
        for (int n : nums2) list.add(n);

        Collections.sort(list);

        int size = list.size();
        if (size % 2 == 0) {
            return (list.get((size / 2) - 1) + list.get(size / 2)) / 2.0;
        } else return list.get(size / 2);
    }
}