package Week_03;

/**
 * created by qiminghua on 2020/8/25
 */
public class PowerxN {
//    public double myPow(double x, int n) {
//        // 1. teminator 终止条件
//        if (n < 2) {
//            return
//        }
//        // 2. process(split big problem) 拆分大问题
//        // 3. drill down （处理子问题）
//        // 4. reverse states
//    }

    /**
     * 时间复杂度 o(lgn)
     * 空间复杂度 o(lgn)
     * @param x
     * @param n
     * @return
     */
    public double quickMul(double x, long n) {
        if (n == 0) {
            return x;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        return n < 0 ? 1.0 / quickMul(x,-n) : quickMul(x,n);
    }

    public static void main(String[] args) {
        PowerxN powerxN = new PowerxN();
        double val = powerxN.quickMul(2.0, 5);
        System.out.println(val);
    }
}
