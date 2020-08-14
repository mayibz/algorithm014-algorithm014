package Week_01;

import java.util.Arrays;

/**
 * leetCode: 189 https://leetcode-cn.com/problems/rotate-array/  选择数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * case input：[1,2,3,4,5,6,7] 和 k = 3  output: [5,6,7,1,2,3,4] 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 要求：1.至少三种方法解决
 * 2. 使用空间复杂度O(1) 的原地算法
 * created by qiminghua on 2020/8/13
 */
public class RotateArray_189 {
    /**
     * 暴力法
     * 时间复杂度： k * o(n)
     * 空间复杂度 o(1) 原地算法
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return;
        }
        // 细节
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

    /**
     * https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 官方题解 - 反转
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     */
    public static void rotate1(int[] nums, int k) {
        // 细节！ 考虑当k 移动次数大于 nums.legth。 %= 写起来更酷
        k %= nums.length;
        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, nums.length - 1);
    }

    /**
     * https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-yuan-di-huan-wei-xiang-xi-tu-jie/
     * 选择数组思路
     * @param nums
     * @param k
     */
    public static void totate2(int[] nums, int k) {

    }

    public static void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate1(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
