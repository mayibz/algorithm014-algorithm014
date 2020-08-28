package Week_03;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * created by qiminghua on 2020/8/25
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
