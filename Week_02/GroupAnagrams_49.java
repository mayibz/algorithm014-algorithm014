package Week_02;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * created by qiminghua on 2020/8/19
 */
public class GroupAnagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List> map = new HashMap<>();
       for (String str : strs) {
           char[] strArr = str.toCharArray();
           Arrays.sort(strArr);
           String key = new String(strArr);
           List list = map.get(key);
           if (list == null) {
               list = new ArrayList();
           }
           list.add(str);
           map.put(key,list);
       }
       List list = new ArrayList();
       for (String key : map.keySet()) {
           list.add(map.get(key));
       }
       return list;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list);
    }
}
