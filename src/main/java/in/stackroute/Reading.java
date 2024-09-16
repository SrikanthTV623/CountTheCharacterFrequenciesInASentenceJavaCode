package in.stackroute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Reading {
    public static void main(String[] args) throws FileNotFoundException {

        String paragraph = new Scanner(new
                FileInputStream("src/main/resources/textFile.txt")).
                useDelimiter("\\Z").next();

        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char c : paragraph.toCharArray()){
            if(charCountMap.containsKey(c)){
                charCountMap.put(c,charCountMap.get(c)+1);
            }else{
                charCountMap.put(c, 1);
            }
        }
        System.out.println(charCountMap);

        Set<Map.Entry<Character,Integer>> entries = charCountMap.entrySet();
        int max = Integer.MIN_VALUE;
        char maxKey ='\0';
        for (Map.Entry<Character,Integer> entry : entries){
            if(entry.getValue()>max){
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("Character with the highest occurrences: " + maxKey);
        System.out.println("Number of occurrences: " + max);

        // Step 1: Count character frequencies
        /*
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) { // Count only letters, ignore spaces and punctuation
                c = Character.toLowerCase(c);
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    charCountMap.put(c, 1);
                }
            }
        }
        System.out.println(charCountMap);
        */
        /*
        // Step 2: Find the character with the highest frequency
        char maxChar = '\0';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        System.out.println("Character with the highest occurrences: " + maxChar);
        System.out.println("Number of occurrences: " + maxCount);

         */
    }
}
