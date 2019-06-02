package poc;

import java.util.Arrays;
 

public class Solution {
	 
	  public int[] twoSum(int[] nums, int target) {
	        int[] copy = Arrays.copyOf(nums, nums.length);
	        
	        Arrays.sort(nums);
	        int[] ans = new int[2];
	        int lo = 0, hi = nums.length - 1;
	        while (lo < hi) {
	            if(nums[lo] + nums[hi] == target) {
	                ans[0] = nums[lo]; 
	                ans[1] = nums[hi];
	                break;
	           }
	            else if (nums[lo] + nums[hi] < target) lo++;
	            else hi--;
	        }
	        
	        //Just search the elemnt's original indices (before sorting)
	        int remaining = -1;
	        int i=0, answer[] = new int[2];
	        for(i=0; i<copy.length; i++) {
	            if(copy[i] == ans[0] || copy[i] == ans[1]) {
	                answer[0] = i;
	                remaining = (copy[i++] == ans[0]) ? ans[1] : ans[0];
	                break;
	            } 
	        }
	        
	        for(; i<copy.length; i++) {
	            if (copy[i] == remaining){
	                answer[1] = i;
	                break;
	            }   
	        }
	        
	        return answer;
	        
	    }
}
