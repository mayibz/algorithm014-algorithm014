package Week_02;

import java.util.HashMap;

/**
 *https://leetcode-cn.com/problems/valid-anagram/description/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * created by qiminghua on 2020/8/19
 */
public class ValidAnagram_242 {
    public static boolean isAnagram(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        for (char ss : sarr) {
            Integer count = map.get(ss);
            map.put(ss, count == null ? 1 : ++count);
        }
        for (char tt : tarr) {
            Integer count = map.get(tt);
            if (count == null) {
                return false;
            }
            map.put(tt, --count);
        }
        for (char ket : map.keySet()) {
            if (map.get(ket) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Integer scount = map.get(s.charAt(i));
            map.put(s.charAt(i),scount == null ? 0 : scount ++);
            Integer tcount = map.get(t.charAt(i));
            map.put(t.charAt(i),tcount == null ? 0 : tcount --);
        }
        for (char ket : map.keySet()) {
            if (map.get(ket) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagramm", t = "nagarnm";
        System.out.println(isAnagram2(s,t));
    }
}
