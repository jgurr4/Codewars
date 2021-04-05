package codeWarsJava;

import java.util.Arrays;

public class ConsecutiveStrings {

    public static String longestConsec(String[] strarr, int k) {
        String arr = Arrays.toString(strarr);
        System.out.println(arr + " groupNumber: " + k);
        String combo = "";
        String temp = "";
        if (k <= 0 || k > strarr.length) {
            return "";
        }
        for (int i = 0; i <= strarr.length; i++) {
            if(i + k <= strarr.length) {
                String[] subset = Arrays.copyOfRange(strarr, i, i+k);
                for (String element : subset) {
                    temp += element;
                }
                if (temp.length() > combo.length()) {
                    combo = temp;
                }
            } else {
                return combo;
            }
            temp = "";
        }

        return combo;
    }
}
//        if (k <= 0 || k > strarr.length) {
//                return "";
//                }
//                for (int i = 0; i < strarr.length; i++) {
//        int remaining = strarr.length - (i+k-1);
//        if (remaining > k) {
//        if (k == 1) {
//        temp = strarr[i];
//        } else {
//        String[] subset = Arrays.copyOfRange(strarr, i, k);
//        for (String element : subset) {
//        temp2 += element;
//        }
//        if (temp.length() > combo.length()) {
//        combo = temp2;
//        }
//        }
//        if (temp.length() > combo.length()) {
//        combo = temp;
//        }
//        } else {
//        return combo;
//        }
//        }
//    int remaining = strarr.length - i + k - 1;
//            if (k != 1 && i+k-1 <= strarr.length) {
//        temp = strarr[i] + strarr[i + k - 1];
//        if (temp.length() > combo.length()) {
//            combo = temp;
//        }
//    } else if (k == 1) {
//        temp = strarr[i];
//        if (temp.length() > combo.length()) {
//            combo = temp;
//        }
//    } else if (remaining <= 0){
//        temp = strarr[i + 1];
//        if (temp.length() > combo.length()) {
//            combo = temp;
//        }
//    } else {
//        temp = strarr[i] + strarr[i + k - 1];
//    }
