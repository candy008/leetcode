package com.leetcode.code;

/**
 * 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

        int [] height = {2,3,4,5,18,17,6};
        int area = maxArea2(height);
        System.out.println(area);

    }

    public static int maxArea1(int[] height){

        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int lv = height[left];
            int rv = height[right];
            int minHeight = lv <= rv ? lv : rv;
            int area = minHeight*(right-left);
            maxArea = maxArea >= area ? maxArea: area;
            if(height[left]>height[right]){
                right--;
            }else {
                left++;
            }
        }
        return maxArea;
    }


    public static int maxArea2(int[] height){

        int left = 0, rt = height.length - 1;
        int lf_max = height[0];
        int rt_max = height[height.length - 1];
        int res = Math.min(rt_max,lf_max)*(height.length-1);
        int i = 0;
        while (left<rt){
            System.out.println(i++);

            while (lf_max >= rt_max && left < rt) {
                rt--;
                if (height[rt] > rt_max) {
                    rt_max = height[rt];
                    res = Math.max((rt - left) * Math.min(rt_max, lf_max), res);
                }
            }
            while (lf_max < rt_max && left < rt) {
                System.out.println(i++);

                left++;
                if (height[left]>lf_max){
                    lf_max = height[left];
                    res = Math.max((rt - left) * Math.min(rt_max, lf_max), res);
                }
            }
        }
        return res;
    }



}
