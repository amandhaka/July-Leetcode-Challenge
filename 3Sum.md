Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:
```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

```java

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
                if(nums.length<=2) return list;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int target=-nums[i];
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            twoSum(left,right,nums,list,target);
        }
        return list;
    }
    public static void twoSum(int left,int right,int[] nums, List<List<Integer>> list, int target){
        while(left<right){
            if((nums[left]+nums[right])==target){
                list.add(Arrays.asList(-target,nums[left],nums[right]));
                left++;
                right--;
                while(left<right && nums[left]==nums[left-1]) left++;
                while(left<right && nums[right]==nums[right+1]) right--;
            }
            else if((nums[left]+nums[right])<target) left++;
            else if(nums[left]+nums[right]>target) right--;
        }
    }
}
```
