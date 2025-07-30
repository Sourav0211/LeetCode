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
            String temp = Arrays.toString(freq);
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