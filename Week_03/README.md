学习笔记

### 递归
1. 递归要训练做到直接看函数，写出来。
2. 找出最小单元(重复单元)
3. 套用递归模板
> 递归模板
```java
public void digui(int level, int param) {
    // 1. 判断终止条件
    if (level > MAX_LEVEL) {
        process result;
        return;
    }
    // 2. 处理当前层
    process(level,param);
    // 3. 处理下一层
    digui(level + 1, param);
    // 4. 清尾操作
}
```

二叉搜索树的中序遍历，是单调递增的。

### 分治
找重复性单元
> 代码模板
```java
 public void divide(problem, param1,param2....) {
    // 1. 判断终止条件， 没有子问题了
    // 2. 准备数据
    // 3。 处理子问题
    // 4. 合并并生成结果
 }
```

### 回溯
八皇后，数独问题
> 代码模板

https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/

https://leetcode-cn.com/problems/subsets/solution/hui-su-si-xiang-tuan-mie-pai-lie-zu-he-zi-ji-wen-t/

总结 ： 回溯是基于DFS（深度优先遍历算法）的一种搜索算法。
所以，回溯算法相当于全遍历，时间复杂度很高，所以一般用 递归+剪枝 来处理。

步骤：
1。确定终止条件
2.设置状态遍历
3.深入搜索
4.回溯（回到上一层节点，状态变量要重置）
