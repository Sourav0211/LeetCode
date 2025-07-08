class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) return new int[0];

        // int[] ans = new int[n - k + 2];
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ;i < n ;i++)
        {

            if(!dq.isEmpty() &&  dq.peekFirst() < i - k + 1)
            {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
            {
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k - 1)
            {
               list.add(nums[dq.peekFirst()]);
            }


        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}