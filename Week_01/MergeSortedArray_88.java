package Week_01;

import java.util.Arrays;

/**
 * leetCode:88 合并有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 *说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * created by qiminghua on 2020/8/13
 */
public class MergeSortedArray_88 {
    /**
     *  思路同 有序链表合并
     *
     *  时间复杂度：o（n） + o(m)
     *  空间复杂度 o(m)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mc = new int[m];
        System.arraycopy(nums1,0,mc,0,m);
        int i = 0;
        int m1 = 0;
        int n1 = 0;
        while (m1 < m && n1 < n) {
            int a = mc[m1];
            int b = nums2[n1];
            if (a < b) {
                nums1[i++] = mc[m1++];
            }else {
                nums1[i++] = nums2[n1++];
            }
        }
        while (m1 < m) {
            nums1[i++] = mc[m1++];
        }
        while (n1 < n) {
            nums1[i++] = nums2[n1++];
        }
    }

    /**
     * https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
     * 官方的双指针法，和我思路一致，不过代码比较简洁，后续的数组复制直接使用System.arrayCopy
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] mc = new int[m];
        System.arraycopy(nums1, 0, mc, 0, m);
        int n1 = 0, m1 = 0, i = 0;
        while (n1 < n && m1 < m) {
            nums1[i++] = mc[m1] < nums2[n1] ? mc[m1++] : nums2[n1++];
        }
        while (n1 < n) {
            System.arraycopy(mc,n1--,nums1,i,n - n1);
        }
        while (m1 < m) {
            System.arraycopy(nums2,m1--,nums1,i,m-m1);
        }
    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n -1;
        m = m-1;
        n = n-1;
        while (m >= 0 && n >= 0) {
            nums1[i--] = nums1[m] < nums2[n] ? nums2[n--] : nums1[m--];
        }
        while (m >= 0) {
            nums1[i--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[i--] = nums2[n--];
        }
    }

    public static void merge4(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n -1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (m >= 0) {
            nums1[i--] = nums1[m--];
        }
        while (n >= 0) {
            nums2[i--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m =3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge3(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
