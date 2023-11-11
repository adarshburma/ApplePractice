/*
Leetcode:

https://leetcode.com/problems/3sum/

*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ; i < nums.length-2; i++) {

            if ( i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i+1;
            int r = nums.length-1;
            int target = 0 - nums[i];

            while (l < r) {

                if (nums[l] + nums[r] == target) {
                    List<Integer> thriplet = new ArrayList<>();
                    thriplet.add(nums[i]);
                    thriplet.add(nums[l]);
                    thriplet.add(nums[r]);
                    res.add(thriplet);
                    l++;
                    while (nums[l] == nums[l-1] && l < r) {
                        l++;
                    }
                    
                }

                if (nums[l] + nums[r] > 0 - nums[i] ) {
                    r--;
                } else {
                    l++;
                }

            }
        }

        return res;
        
    }
}
