package Week_01;

import java.util.Arrays;

/**
 * leetcode 26 删除排序数组中重复项: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * case: input: nums = [1,1,2], output: 2   newArr = [1,2]
 *       input: nums = [0,0,1,1,1,2,2,3,3,4], output: 5    newArr = [0,1,2,3,4]
 *  要求 o(1) 空间复杂度, 原地数组
 * created by qiminghua on 2020/8/13
 */
public class RemoveDuplicatesFromSortedArray_26 {
    /**
     * 思路，记录待交换的下标和前一个值，待交换下标从1开始
     * 然后遍历数组，如果下一个元素和pre不一样，进行元素交换，更新pre， 并将交换下标++
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int changeIndex = 1;
        int pre = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pre) {
                change(nums,i,changeIndex);
                pre = nums[changeIndex];
                changeIndex ++;
            }
        }
        return changeIndex;
    }

    public static void change(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
     * 官方题解 双指针法
     * 感悟：和我的思路其实是差不多的，只不过，这道题其实不关心后面的元素值，所以不用交换，直接覆盖就可以.
     * 不过还是比我妙！
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
     * 优化 细节： 对于[0,1,2,3] 这种没有重复元素的数据，没必要进行复制操作，即判定 快指针-慢指针 = 1
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                if (j - i > 1) {
                    nums[++i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        System.out.println(removeDuplicates(arr));
        arr = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
