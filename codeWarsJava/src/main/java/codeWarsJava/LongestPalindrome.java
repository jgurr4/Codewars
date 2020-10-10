package codeWarsJava;

import java.util.ArrayList;

//The goal of this Kata is to receive a string and find the longest palindrome inside it and return the length
//of that palindrome. A palindrome is a string that is the same whether it's reversed or normal. Example:
//sowracecarbad would return 7. because racecar is the longest one that when reversed is still racecar.
public class LongestPalindrome {
    public static int longestPalindrome(final String s) {
        for(int i = 0; i < s.length(); i++){
            while(s.charAt(i) < s.length()){
                String s1 = "";
                s1 = s1 + s.charAt(i);
                StringBuilder rev = new StringBuilder(s1).reverse();
                Boolean tOrF = rev.toString().contentEquals(s.substring(0, i));
                ArrayList<String> myArr = new ArrayList<String>();
                if(tOrF == true) {
                   myArr.add(s1);
                }
                int num = 0;
                for(int e = 0; e < myArr.size(); e++) {
                    if(myArr.get(e).length() > num) {
                        num = myArr.get(e).length();
                    }
                }

                Math.max(a, b);
            }
        }
        return -1;
    }
}