/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.*;

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int firstIdx = -1;
        int prevIdx = -1;
        int maxD = Integer.MIN_VALUE;
        int minD = Integer.MAX_VALUE;
        int idx = 0;
        int prev = 0;
        ListNode curr = head;
        while (curr.next != null) {

            if (idx > 0) {
                if ((curr.val < prev && curr.val < curr.next.val) || (curr.val > prev && curr.val > curr.next.val)) {
                    if (firstIdx == -1) firstIdx = idx;
                    else maxD = idx - firstIdx;

                    if (prevIdx != -1) minD = Math.min(minD, idx - prevIdx);
                    
                    prevIdx = idx;
                }
            }

            prev = curr.val;
            curr = curr.next;

            idx++;
        }

        if (maxD == Integer.MIN_VALUE) return new int[] {-1, -1};
        else return new int[] {minD, maxD}; 
    }
}