import java.util.*;

class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<Integer>();
        
        Map<String, Integer> yearningMap = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        for (String[] subArray : photo) {
            int sum = 0;
            
            for (String person : subArray) {
                Integer score = yearningMap.get(person);
                
                if (score != null && score != 0) {
                    sum += score;
                }
            }
            
            answer.add(sum);
        }
        
        return answer;
    }
}
