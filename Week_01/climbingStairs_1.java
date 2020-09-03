package Week_01;

public class climbingStairs_1 {

    //普通递归的方法
    public int climbStairs_Method1(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return climbStairs_Method1(n - 1) + climbStairs_Method1(n - 2);
        }
    }

    //记忆化递归的方法
    public int climbStairs_Method2(int n) {
        if (n < 0) {
            return 0;
        } else {
            int[] memo = new int[n + 1];
            return memoClimbStairs(n, memo);
        }
    }

    private int memoClimbStairs(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 0 || n == 1) {
            memo[0] = 1;
            memo[1] = 1;
        } else {
            memo[n] = memoClimbStairs(n - 1, memo) + memoClimbStairs(n - 2, memo);
        }
        return memo[n];
    }

    //动态规划的方法
    public int climbStairs_Method3(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //斐波那契数列问题
    public int climbStairs_Method4(int n) {
        if (n < 0) {
            return 0;
        }
        int q1 = 1, q2 = 1;
        for (int i = 2; i <= n; i++) {
            q2 = q2 + q1;
            q1 = q2 - q1;
        }
        return q2;
    }

    //矩阵快速幂
    public int climbStairs_Method5(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    //通项公式
    public int climbStairs_Method6(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }
}
