package codeWarsJava;

import java.util.Arrays;

public class Greed {
	public static int greedy(int[] dice) {

		int answer = 0;
		String str = Arrays.toString(dice);
		str = str.replace("[", "").replace("]", "").replace(",", "").replace(" ", "");

		String newStr1 = str.replace("1", "");
		String newStr2 = str.replace("2", "");
		String newStr3 = str.replace("3", "");
		String newStr4 = str.replace("4", "");
		String newStr5 = str.replace("5", "");
		String newStr6 = str.replace("6", "");

		switch (newStr1.length()) {
			case 0:
				answer += 1200;
				break;
			case 1:
				answer += 1100;
				break;
			case 2:
				answer += 1000;
				break;
			case 3:
				answer += 200;
				break;
			case 4:
				answer += 100;
				break;
		}

		switch (newStr2.length()) {
			case 0:
			case 1:
			case 2:
				answer += 200;
				break;
		}

		switch (newStr3.length()) {
			case 0:
			case 1:
			case 2:
				answer += 300;
				break;
		}

		switch (newStr4.length()) {
			case 0:
			case 1:
			case 2:
				answer += 400;
				break;
		}

		switch (newStr5.length()) {
			case 0:
				answer += 600;
				break;
			case 1:
				answer += 550;
				break;
			case 2:
				answer += 500;
				break;
			case 3:
				answer += 100;
				break;
			case 4:
				answer += 50;
				break;
		}

		switch (newStr6.length()) {
			case 0:
			case 1:
			case 2:
				answer += 600;
				break;
		}

		return answer;
	}
}

// 		 Three 1's => 1000 points
//		 Three 6's =>  600 points
//		 Three 5's =>  500 points
//		 Three 4's =>  400 points
//		 Three 3's =>  300 points
//		 Three 2's =>  200 points
//		 One   1   =>  100 points
//		 One   5   =>   50 point


//To-do: Figure out why these work:
//#1
//public static int greedy(int[] dice) {
//int n[] = new int[7];
//for (int d : dice) n[d]++;
//return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
//}

//#2
//public static int greedy(int[] dice){
//    int res = 0;
//    int[] count = new int[]{0, 0, 0, 0, 0, 0};
//    int[] weight = new int[]{100, 0, 0, 0, 50, 0};
//    int[] weight3 = new int[]{1000, 200, 300, 400, 500, 600};
//
//    for (int die : dice) count[die-1]++;
//
//    for (int i = 0; i < count.length; i++) res+=(count[i]/3*weight3[i]) + (count[i]%3 * weight[i]);
//
//    return res;
//}
