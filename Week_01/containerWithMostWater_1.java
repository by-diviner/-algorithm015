package Week_01;

public class containerWithMostWater_1 {

    //暴力枚举法
    public int maxArea_Method1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    //双指针法
    public int maxArea_Method2(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(area, max);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
