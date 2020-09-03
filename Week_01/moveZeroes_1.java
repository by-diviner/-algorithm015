package Week_01;

public class moveZeroes_1 {
    public void moveZeroes_Method1(int[] nums) {
        //两次遍历方法
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroes_Method2(int[] nums) {
        //一次遍历方法
        if (nums == null) {
            return;
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
