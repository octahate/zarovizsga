package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.Set;
import java.util.TreeSet;

public class DigitsCounter {

    public static final String NUMBERS = "0123456789";

    public int getCountOfDigits(String s){
        Set<Character> numbers = new TreeSet<>();
        if (s == null || s.isBlank()){
            return 0;
        }
        for (Character currentChar : s.toCharArray()){
            if (NUMBERS.contains(currentChar.toString())){
                numbers.add(currentChar);
            }
        }
        return numbers.size();
    }
}
