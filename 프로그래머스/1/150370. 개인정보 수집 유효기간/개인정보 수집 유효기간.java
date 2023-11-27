import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<String, Integer>();
        List<Integer> answerList = new ArrayList<Integer>();
        
        for (String term : terms) {
            String[] termArr = term.split(" ");
            String key = termArr[0];
            int value = Integer.parseInt(termArr[1]);

            termMap.put(key, value);
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyArr = privacies[i].split(" ");
            String collectDt = privacyArr[0];
            String termType = privacyArr[1];
            String expiredDt = addMonths(collectDt, termMap.get(termType));
            
            if (isAfterToday(today, expiredDt)) {
                answerList.add(i + 1);
            }
        }
        
        return answerList;
    }
    
    private String addMonths(String collectDt, int monthsToAdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
       
        LocalDate date = LocalDate.parse(collectDt, formatter);
        LocalDate newDate = date.plusMonths(monthsToAdd);

        String resultDate = newDate.format(formatter);
        
        return resultDate;
    }
    
    private boolean isAfterToday(String today, String expiredDt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        LocalDate date1 = LocalDate.parse(today, formatter);
        LocalDate date2 = LocalDate.parse(expiredDt, formatter);

        if (date1.isAfter(date2) || date1.isEqual(date2)) {
            return true;
        } else {
            return false;
        }
    }
}