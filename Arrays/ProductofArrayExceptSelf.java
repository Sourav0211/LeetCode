public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);

        // Print the result
        System.out.print("Input array: ");
        printArray(nums);
        System.out.print("Output array: ");
        printArray(result);
    }

    // Helper method to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] leftproduct = new int[nums.length];
        int product = 1;
        for(int j = nums.length-1 ; j >= 0  ; j--)
        {   
                
                product =  product * nums[j]; 
                leftproduct[j] = product;
        }
        int rightproduct =1;
        for(int i = 0;i < nums.length -1  ; i++)
        {
             
            if(i!=0)
                rightproduct = rightproduct * nums[i-1];
            output[i] = rightproduct * leftproduct[i+1];
            
        }
        
        
        
        return output;
    }
    
}