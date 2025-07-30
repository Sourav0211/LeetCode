class Solution {


    public String sorted(String str)
    {
        char[] chars= str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs)
        {
            int[] freq = new int[26];
            for(char ch : str.toCharArray())
            {
                freq[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder(26 * 3);

            for(int i : freq)
            {
                sb.append('#').append(i);
            }
            String temp = sb.toString();
            if(!map.containsKey(temp)){
                map.put(temp,new ArrayList<>());
                
            }
            map.get(temp).add(str);
        }
        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry:map.entrySet())
        {
            ans.add(entry.getValue());
        }

        return ans;


    }
}