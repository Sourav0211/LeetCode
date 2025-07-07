class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, new Comparator<int[]>(){

            @Override
            public int compare(int a[],  int b[])
            {
                if(a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }

        });

        int maxDay = 0;

        for(int[] event: events)
        {
            maxDay = Math.max(event[1], maxDay);
        }

        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans  = 0;

  

        for(int day = 1; day <= maxDay ; day++)
        {

            while( i < events.length && events[i][0] <= day )
            {
                pq.offer(events[i][1]);
                i++;
            }

            while(!pq.isEmpty() && pq.peek() < day)
            {
                
                pq.poll();
                
            }

            if(!pq.isEmpty())
            {
                pq.poll();
                ans++;

            }
        }

        return ans;

       
    }
}