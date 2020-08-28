package Week_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 括号生成
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * created by qiminghua on 2020/8/25
 */
public class GenerateParentheses_22 {

    /**
     * 时间复杂度 o （2^2n） 官方分析，O（n）
     * 空间复杂度 o（n）
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0,0,n,"", res);
        return res;
    }

    private static void generate(int left, int right, int n, String s, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (right < n && right < left) {
            generate(left,right +1, n, s + ")");
        }
    }

    public static void all(int i, int n, String str, String current, Set<String> sets) {
        if (i == n) {
            System.out.println(str);
            return;
        }
        if (sets.contains(current)) {
            return;
        }
        sets.add("A");
        all(i+1, n, str + "A", "A", sets);
        sets.add("B");
        all(i+1, n, str + "B", "B",sets);
        sets.add("C");
        all(i+1,n,str + "C","C", sets);
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet();
        all(0,3,"","",set);
    }

    public static void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (right < n && right < left) {
            generate(left,right +1, n, s + ")");
        }
    }

    public static void generate(int n) {
        generate(0,2 * n, "");
    }

    private static void generate(int i, int max, String s) {
        // 终止条件
        if (i >= max) {
            // 判断合法性
            System.out.println(s);
            return;
        }
        // 处理当前结果
        String s1 = s + "(";
        String s2 = s + ")";
        // 下一层
        generate(i + 1, max, s1);
        generate(i + 1, max, s2);
    }
}
