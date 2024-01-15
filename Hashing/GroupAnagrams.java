
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;




class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] split = word.toCharArray();
            Arrays.sort(split);
            String newsort= new String(split);
           

            if (map.containsKey(newsort)) {
                List<String> temp = map.get(newsort);
                temp.add(word);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(word);
                map.put(newsort, temp);
            }
        }

        List<List<String>> output = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> temp2 = map.get(key);
            output.add(temp2);
        }

        return output;
    }
}


public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test input
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Call the groupAnagrams method
        List<List<String>> result = solution.groupAnagrams(strs);

        // Print the result
        System.out.println("Grouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
