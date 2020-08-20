package Week_01;

import java.util.Stack;

/**
 * 接雨水 leetcode 42
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * created by qiminghua on 2020/8/17
 */
public class TrappingRainWater_42 {
    /**
     * 暴力法：
     * 时间复杂度 o(n ^ 2)
     * 空间复杂度 o(1)
     * 计算每一列 可接水量 = min(左边最大值，右边最大值) - 当前高度
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }
            for (int k = i; k < height.length; k++) {
                rightMax = Math.max(height[k], rightMax);
            }
            sum += Math.min(leftMax, rightMax) - height[i];
        }
        return sum;
    }

    public static int trap2(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int popIndex = stack.pop();
                while (!stack.isEmpty() && height[popIndex] == height[stack.peek()]) {
                    stack.pop();
                }
                int popHeight = height[popIndex];
                if (!stack.isEmpty()) {
                    Integer left = stack.peek();
                    int leftHeight = height[left];
                    sum += (i - left - 1) * (Math.min(i, leftHeight) - popHeight);
                }
            }
            stack.push(i);
        }
        return sum;
    }

    public int trap3(int[] height) {
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        arr = new int[]{2,0,2};
        int res = trap2(arr);
        System.out.println(res);
    }
}
