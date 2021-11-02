package com.miles.demo1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Classname ClimbStairs
 * @Description TODO
 * @Date 2021-10-26 10:40
 * @Created by ChenMX
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] ints = new int[n];
        ints[0] = 1;
        if (n == 1) {
            return ints[0];
        }
        ints[1] = 2;
        for (int i = 2; i < n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n - 1];
    }

    public int coinChange(int[] coins, int amount) {
        int[] ints = new int[amount + 1];
        ints[0] = 0;
        Arrays.fill(ints, 0);
        int length = coins.length;
        for (int i = 1; i <= amount; i++) {
            int[] amounts = new int[length];
            for (int j = 0; j < length; j++) {
                int coin = coins[j];
                if (i - coin >= 0) {
                    if (ints[i - coin] == -1) {
                        amounts[j] = -1;
                    } else {
                        amounts[j] = ints[i - coin] + 1;
                    }
                } else {
                    amounts[j] = -1;
                }
            }
            int flag = -1;
            for (int j = 0; j < length; j++) {
                int k = amounts[j];
                if (flag == -1) {
                    flag = k;
                } else {
                    if (k >= 0) {
                        flag = Integer.min(flag, k);
                    }
                }
            }
            ints[i] = flag;
        }
        return ints[amount + 1];
    }

    public int maxValue(int[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int length = grid[0].length;
        if (length == 0) {
            return 0;
        }
        int[][] ints = new int[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0 && j == 0) {
                    ints[i][j] = grid[i][j];
                } else if (i == 0) {
                    ints[i][j] = grid[i][j] + ints[i][j - 1];
                } else if (j == 0) {
                    ints[i][j] = grid[i][j] + ints[i - 1][j];
                } else {
                    ints[i][j] = grid[i][j] + Integer.max(ints[i - 1][j], ints[i][j - 1]);
                }
            }
        }
        return ints[height - 1][length - 1];
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b=a;
            a=c;
        }
        return a;
    }
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] ints = new int[length];
        Arrays.fill(ints,1);
        int max=1;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if(num>nums[j]){
                    ints[i]=Integer.max(ints[i],ints[j]+1);
                    max=Integer.max(ints[i],max);
                }
            }
        }
        return max;
    }
    public int uniquePaths(int m, int n) {
        int[][] ints = new int[m + 1][n + 1];
        ints[1][1]=1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i==1&&j==1){
                    continue;
                }
                ints[i][j]=ints[i-1][j]+ints[i][j-1];
            }
        }
        return ints[m][n];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int length = obstacleGrid[0].length;
        int[][] res = new int[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if(obstacleGrid[i][j]==1)continue;
                if(i==0&&j==0){
                    res[i][j]=1;
                }else if(i==0){
                    res[i][j]=res[i][j-1];
                }else if(j==0){
                    res[i][j]=res[i-1][j];
                }else{
                    res[i][j]=res[i-1][j]+res[i][j-1];
                }
            }
        }
        return res[height-1][length-1];
    }

    public int numDecodings(String s) {
        if(s.startsWith("0"))return 0;
        int a=1;
        int b=1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c;
            String s1 = s.substring(i - 1, i);
            if(s1.equals("0")){
                c=a;
            }else{
                c=tmp.compareTo("10")>=0&&tmp.compareTo("26")<=0?a+b:a;
            }
            b=a;
            a=c;
        }
        return a;
    }
    public int numWays(int n) {
        int a=1;
        int b=1;
        for (int i = 2; i <=n ; i++) {
            int c=a+b;
            b=a;
            a=c%1000000007;
        }
        return a;
    }
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        int a=1;
        int b=0;
        int c;
        for (int i = 2; i <= n; i++) {
            c=(a+b)%1000000007;
            b=a;
            a=c;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] ints = {{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
        int i = new ClimbStairs().numDecodings("10");
        int i1 = new ClimbStairs().translateNum(10);
        System.out.println(i);
    }
}
