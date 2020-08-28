package Week_03;

import java.util.*;

/**
 * 字符串全排列
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * created by qiminghua on 2020/8/28
 */
public class StringQuanPaiLie {
    List<String> res = new LinkedList<>();
    char[] c;

    /**
     * 题解1
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    /**
     * 自己理解 写的回溯
     * @param str
     * @return
     */
    public List<String> permute(String str) {
        int len = str.length();
        List<String> res= new ArrayList<>();
        if (len <= 0) {
            return res;
        }
        Set<Character> sets = new HashSet<>();
        dfs(str,"",sets,res);
        return res;
    }

    private void dfs(String str, String cur, Set<Character> sets, List<String> res) {
        if (cur.length() == str.length()) {
            System.out.println(cur);
            res.add(cur);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!sets.contains(str.charAt(i))) {
                cur += str.charAt(i);
                sets.add(str.charAt(i));
                dfs(str,cur, sets,res);
                sets.remove(str.charAt(i));
                cur = cur.substring(0,cur.length()-1);
            }
        }
    }

    public List<String> permute3(String str) {
        int len = str.length();
        List<String> res = new ArrayList<>();
        dfs(str,"",0,len,res);
        return res;
    }

    public void dfs(String str, String cur, int level, int n, List<String> res) {
        if (level == n) {
            res.add(cur);
            return;
        }
        for (int i = 0; i < n; i++) {
            Set<Character> sets = new HashSet<>();
            if (!sets.contains(str.charAt(i))) {
                cur += str.charAt(i);
                sets.add(str.charAt(i));
                dfs(str, cur, level + 1, n, res);
                cur = cur.substring(0, cur.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        StringQuanPaiLie stringQuanPaiLie = new StringQuanPaiLie();
        List<String> result = stringQuanPaiLie.permute3("abc");
        System.out.println(result.toString());
    }
}
