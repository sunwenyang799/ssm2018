package com.ssm.test;
import java.util.Arrays;

/**
 *  一个随机位数的int数组,只能用一次循环将数组中的值排序
 * */
class TestSort {

    static int currIndex = 1;
    static int hdIndex = 0;
    static int futureIndex = 1;
    static int recod = 1;
    static int found = 0;
    static int[] result = new int[2];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{0,2,1,2})));
    }

    public static int[] singleNumber(int[] nums) {
        // System.out.print(Arrays.toString(nums));
        if (nums.length == 2) {
            return nums;
        }
        while (true) {
            System.out.println(Arrays.toString(nums));
            if (hdIndex >= nums.length) {
                break;
            }
            if (nums[hdIndex] > nums[currIndex]) {
                hdGtCurr(nums);
            } else if (nums[hdIndex] <= nums[currIndex]) {
                hdLtCurr(nums);
            }
            if (futureIndex == nums.length + 1) {
                break;
            }
        }
        System.out.print(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (found == 2) {
                break;
            }
            if (i + 1 == nums.length) {
                result[1] = nums[i];
                break;
            }
            if (nums[i] != nums[i+1]) {
                result[found] = nums[i];
                found ++;
            } else {
                i ++;
            }
        }
        return result;
    }

    private static void hdLtCurr(int[] nums) {
        hdIndex = futureIndex - 1;
        if (hdIndex < 0) {
            hdIndex = 0;
            currIndex = 1;
        }
        currIndex = futureIndex;
        futureIndex = currIndex + 1;
        recod = futureIndex;
    }

    private static void hdGtCurr(int[] nums) {
        int temp = nums[currIndex];
        nums[currIndex] = nums[hdIndex];
        nums[hdIndex] = temp;
        currIndex --;
        hdIndex --;
        futureIndex = recod - 1;
        if (hdIndex < 0) {
            hdIndex = 0;
            currIndex = 1;
        }
    }
}