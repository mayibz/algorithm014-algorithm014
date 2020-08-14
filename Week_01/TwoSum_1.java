package Week_01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode-1 两数之和 https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * created by qiminghua on 2020/8/14
 */
public class TwoSum_1 {
    /**
     * 暴力法
     * 时间复杂度 o(n^2)
     * 空间复杂度 o(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * hashmap 法
     * 时间复杂度 o（1）
     * 空间复杂度 o（n）
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{i,index};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i,j};
                }
                if (target - nums[i] > nums[j]) {
                    break;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 4};
        int[] res = twoSum2(arr, 6);
        System.out.println(Arrays.toString(res));
    }
}
