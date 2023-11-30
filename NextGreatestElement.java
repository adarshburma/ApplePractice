/*

  Given the two distinct integer arrays, nums1 and nums2, where nums1 is a subset of nums2, 
  find all the next greater elements for nums1 values in the corresponding places of nums2.

In general, the next greater element of an element, 

, in an array is the first greater element present on the right side of 

 in the same array. However, in the context of this problem, for each element 

 in nums1, find the next greater element present on the right side of 

 in nums2 and store it in the ans array. If there is no such element, store −1
−1 for this number. The ans array should be of the same length as nums1, 
and the order of the elements in the ans array should correspond to the order of the elements in nums1.

Return the ans array after finding the next greater elements.

*/


import java.util.*;

public class NextGreater{
   public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int[] res = new int[nums1.length];
      Stack<Integer> st = new Stack<>();
      HashMap<Integer, Integer> map = new HashMap<>();

      for (int current : nums2) {
         while (!st.isEmpty() && current > st.peek()) {
            map.put(st.pop(), current);
         }

         st.push(current);
      }

      while (!st.isEmpty()) {
         map.put(st.pop(), -1);
      }

      for (int j = 0 ; j < nums1.length; j++) {
         res[j] = map.get(nums1[j]);
      }
      
      // Replace this placeholder return statement with your code
      return res;
   }
}
