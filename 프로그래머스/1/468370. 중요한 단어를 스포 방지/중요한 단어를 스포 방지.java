import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
                
        Set<String> notImportant = new HashSet<>();
        Set<String> important = new HashSet<>();
        
        boolean[] isSpoiled = new boolean[message.length()];
        
        for(int[] spoiler : spoiler_ranges){
            int start = spoiler[0];
            int end = spoiler[1];
            
            for(int i = start ; i <= end; i++){
                isSpoiled[i] = true;
            }
        }
        
        int idx = 0;
        while(idx < message.length()){
            
            if(message.charAt(idx) == ' '){
                idx++;
                continue;
            }
            
            int start = idx;
            while(idx < message.length() && message.charAt(idx) != ' '){
                idx++;
            }
            int end = idx - 1;
            
            boolean hasSpoiler = false;
            for(int i = start; i <= end; i++){
                if(isSpoiled[i]){
                    hasSpoiler = true;
                }
            }
            
            if(!hasSpoiler){
                notImportant.add(message.substring(start, end + 1));
            }
            
            
            
        }
        
        for(int[] range : spoiler_ranges){
               String fullWord = getFullWord(range, message);
               String[] words = fullWord.split(" ");
               for(String word : words){
                   String w = word.trim();
                   if(!w.isEmpty() && !notImportant.contains(w)){
                       important.add(w);
                   }
               }
                
        }
        
        return important.size();
        
    }
    
    public String getFullWord(int[] range, String message){
        int start = range[0];
        int end = range[1];
        int limit = message.length();

        if (start < 0 || end >= limit || start > end) return "";

        while (start > 0 && message.charAt(start - 1) != ' ') {
            start--;
        }
        while (end < limit - 1 && message.charAt(end + 1) != ' ') {
            end++;
        }

        return message.substring(start, end + 1).trim();
    }
}