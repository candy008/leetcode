package com.leetcode.code;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int res = search2(nums,0);
        System.out.println(res);
    }

    public static int search1(int[] nums, int target) {
        if(nums==null){
            return -1;
        }
        if(nums.length==0){
            return -1;
        }
        if(nums[0]==target){
            return 0;
        }
        if(nums[nums.length-1]==target){
            return nums.length-1;
        }


        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                return i;
            }
        }
        return -1;
    }


    //{6,7,8,0,1,2,3,4,5}
    public static int search2(int[] nums, int target) {

        if(nums==null){
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l + r) / 2;
            if(target==nums[mid]){
                return mid;
            }
            if(nums[mid] >= nums[l]){
                if(target>=nums[l]&&nums[mid] > target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(target > nums[mid]  && nums[r] >= target){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            System.out.println(r+":"+l);
        }
        return -1;
    }


    public  static int  search3(int[] nums, int target) {
        //实际上就是两个递增序列，依旧是二分法
        //只不过只在递增序列中二分
        if(nums.length==0){
            return -1;
        }
        int st = 0,end = nums.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[st]){
                if(nums[st]<=target&&target<nums[mid]){
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[end]){
                    st = mid+1;
                }else{

                    end = mid==0?mid:mid-1;
                }
            }
        }
        return -1;
    }
}
