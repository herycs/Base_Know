package algorithm.leetcode.Q1_50;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassNamelicode1
 * @Description
 * @Author ANGLE0
 * @Date2019/12/20 14:24
 * @Version V1.0
 **/
public class licode1_10 {
    /*
        licode1
        DEC：
            求解A+B为定值的数据下标
     */
    public int[] twoSum(int[] nums, int target) throws IllegalAccessException {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalAccessException("No solution");
    }

    /*
        licode2
        DES：
            AB链表求和
     */
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);

        ListNode p = l1, q = l2, list = res;
        int upNum = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            int sum = x + y + upNum;
            upNum = sum / 10;
            list.next = new ListNode(sum % 10);
            list = list.next;

            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (upNum > 0)
            list.next = new ListNode(upNum);
        return res.next;
    }

    /*
        licode3
        DES:
            求解最长不重复子串
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    /*
        licode4
        DES：
            求解AB，Sorted数组中位数
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = 0;
        while(-1 != number){
            number = in.nextInt();
            int result = number & 0x7FFFFFFF;
            System.out.println("input number & 0x7FFFFFFF ="+ result);
        }
    }
}
