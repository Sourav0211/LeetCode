import java.util.HashSet;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test Case 1: " + solution.longestConsecutive(nums1)); // Output: 4

        // Test Case 2
        int[] nums2 = {1, 2, 0, 1};
        System.out.println("Test Case 2: " + solution.longestConsecutive(nums2)); // Output: 3

        // Test Case 3
        int[] nums3 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println("Test Case 3: " + solution.longestConsecutive(nums3)); // Output: 7
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int maxcount = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        for(int i: nums) 
        {
            if(set.contains(i-1))
            {
                continue;
            }
            
            int k = 1;
            int count = 1;

            while (set.contains(i + k)) {
                set.remove(i+k);
                k++;
                count++;
                
            }

            if (count > maxcount) {
                maxcount = count;
            }
        }

        return maxcount;
    }
}