package Week_02;

import java.util.*;

/**
 * leetCode : 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * created by qiminghua on 2020/8/18
 */
public class HuaDongChuangKouDeZuiDaZhiLcof_59 {
    /**
     * 使用单调双端队列
     * 时间复杂度 o(n)
     * 空间复杂度 o(k)
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums,int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> dequeue = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!dequeue.isEmpty() && nums[i] >= nums[dequeue.peekLast()]) {
                dequeue.pollLast();
            }
            dequeue.addLast(i);
            if (dequeue.peekFirst() <= i-k) {
                dequeue.pollFirst();
            }
            if (i+1 >= k) {
                // 保存
                res[index ++] = nums[dequeue.peekFirst()];
            }
        }
        return res;
    }

    /**
     * 使用大顶堆
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums,int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }
        int[] res = new int[nums.length -k + 1];
        int index = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
            if (i+1 >= k) {
                res[index++] = priorityQueue.peek();
                priorityQueue.remove(nums[i+1-k]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow2(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
