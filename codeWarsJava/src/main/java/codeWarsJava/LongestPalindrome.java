package codeWarsJava;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

//The goal of this Kata is to receive a string and find the longest palindrome inside it and return the length
//of that palindrome as an int. A palindrome is a string that is the same whether it's reversed or normal. Example:
//sowracecarbad would return 7. because racecar is the longest one that when reversed is still racecar.
public class LongestPalindrome {
    public static int longestPalindrome(final String s) {
        if (s == "") return 0;

        String max = null;
        ArrayList<String> arrList = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
                String sub = s.substring(1, i+i);
                StringBuilder sequence = new StringBuilder(sub);
                StringBuilder reverse = sequence.reverse();
                if (reverse.equals(sequence)) {
                    String s1 = reverse.toString();
                    arrList.add(s1);
                }
            max = Collections.max(arrList, Comparator.comparing(String::length));
        }
        return max.length();
    }
}