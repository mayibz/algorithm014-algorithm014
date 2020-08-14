package Week_01;

import java.util.Arrays;

/**
 * leetCode 283: 移动0 https://leetcode-cn.com/problems/move-zeroes/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * created by qiminghua on 2020/8/14
 */
public class MoveZeroes_283 {
    /**
     * 一遍遍历，记录待交换下标
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int changeIndex = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 || nums[i] == prev) {

            }
            if (nums[i] != 0) {
                int temp = nums[changeIndex];
                nums[changeIndex] = nums[i];
                nums[i] = temp;
                changeIndex ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
