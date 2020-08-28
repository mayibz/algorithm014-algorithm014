package Week_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列2
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * created by qiminghua on 2020/8/28
 */
public class permutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        List<Integer> cur = new ArrayList<>();
        Set<Integer> sets = new HashSet<>();
        int[] levelFlag = new int[length];
        dfs(nums, length, 0,cur, res, levelFlag);
        return res;
    }

    /**
     * 方法一
     * if(i > 0 && nums[i] == nums[i-1] && levelFlag[i-1] == 0) {
     *      continue;
     *  }
     * @param nums
     * @param length
     * @param level
     * @param cur
     * @param res
     * @param levelFlag
     */
    private void dfs(int[] nums, int length, int level, List<Integer> cur, List<List<Integer>> res,  int[] levelFlag) {
        if (level == length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && levelFlag[i-1] == 0) {
                continue;
            }
            if (levelFlag[i] == 1) {
                continue;
            }
            cur.add(nums[i]);
            levelFlag[i] = 1;
            dfs(nums, length, level+1, cur, res, levelFlag);
            levelFlag[i] = 0;
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * 方法2
     * @param nums
     * @param length
     * @param level
     * @param cur
     * @param res
     * @param levelFlag
     */
    private void dfs2(int[] nums, int length, int level, List<Integer> cur, List<List<Integer>> res,  int[] levelFlag) {
        if (level == length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (sets.contains(nums[i])) {
                continue;
            }
            sets.add(nums[i]);
            if (levelFlag[i] == 1) {
                continue;
            }
            cur.add(nums[i]);
            levelFlag[i] = 1;
            dfs2(nums, length, level+1, cur, res, levelFlag);
            levelFlag[i] = 0;
            cur.remove(cur.size() - 1);
            sets.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        permutationsII_47 permutations = new permutationsII_47();
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> result = permutations.permuteUnique(nums);
        System.out.println(result);
    }
}
