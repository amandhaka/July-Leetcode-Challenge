Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
```
Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        if(nums.length==0) return list;
        List<Integer> currentSubset=new ArrayList<>();
        findSubsets(list,currentSubset,nums,0);
        return list;
    }
    public static void findSubsets(List<List<Integer>> list, List<Integer> currentSubset,int[] nums,int idx){
        list.add(new ArrayList<>(currentSubset));
        for(int i=idx;i<nums.length;i++){
            currentSubset.add(nums[i]);
            //System.out.println("idx"+idx+" "+currentSubset);
            findSubsets(list,currentSubset,nums,i+1);
            currentSubset.remove(currentSubset.size()-1);
        }
    }
}
 
```
