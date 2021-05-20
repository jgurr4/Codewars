package codeWarsJava;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;

public class App {

  public static void main(String[] args) {
    System.out.println(String.format("%.2f", CompoundInterest.checker(20000)));
/*
    //Practicing with number format and Decimal Format:
    NumberFormat nf = NumberFormat.getPercentInstance();
    System.out.println(nf.format(.05));
    DecimalFormat df = new DecimalFormat("##,###.##");
    System.out.println(df.format(43353.5636));
*/

  }

  public String getGreeting() {
    return "Hello World";
  }
}
//        average();
//        System.out.println(BitCounting.countBits(1234));  //should return 10011010010.
//        System.out.println(BraceChecker.isValid("[]"));  //true
//        System.out.println(BraceChecker.isValid("[(])"));  //false
//        System.out.println(BraceChecker.isValid("([{}])"));  //true
//        System.out.println(BraceChecker.isValid("[({})](]"));  //false
//        CompoundInterest.checker();
//        System.out.println(JadenCase.toJadenCase("Hi, my name is jared."));  //returns Hi, My Name Is Jared.
//        MultiDimensionArray.make();  //returns columns and rows with values.
//    	  Numbers20.result();  //returns nums 1-20 with certain nums replaced with words.
//    	System.out.println(SquareDigit.squareDigits(9119));   //works great.
//    	int[] intArray = {5,1,3,4,1}; //Uncomment this if you uncomment line below.
//    	int[] intArray2 = {1,1,1,3,1}; //Uncomment this if you uncomment line below.
//    	System.out.println(Greed.greedy(intArray)); //Should return 250
//    	System.out.println(Greed.greedy(intArray2)); //Should return 1100
//    	StringSplit.splitter();  //I think it works. Check again.
//    	System.out.println(ToCamelCase.toCamelCase("the_Stealth_Warrior"));  //Doesn't work yet...
//    	System.out.println(SillyAddition.add(248, 208));
//    	System.out.println(SillyAddition.add(36, 245));
//    	System.out.println(DigitalRoot.digital_root(16));
//    	System.out.println(DigitalRoot.digital_root(942));
//        System.out.println(SqInRect2.sqInRect(5, 3));  //Answer should be [3, 2, 1, 1]
//        System.out.println(SqInRect2.sqInRect(17, 30));  //Answer should be [17, 13, 4, 4, 4, 1, 1, 1, 1,]
//        System.out.println(CamelCaseWithSpace.camelCase("camelcasing"));
//        System.out.println(CamelCaseWithSpace.camelCase("camelCasing"));
//        System.out.println(CountDigits.countDigits(43214));
//        System.out.println(LongestPalindrome.longestPalindrome("a"));
//        System.out.println(LongestPalindrome.longestPalindrome("aa"));
//        String[] strarr = {"tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"};
//        System.out.println(ConsecutiveStrings.longestConsec(strarr, 2));
//        System.out.println(ConsecutiveStrings.longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
//        System.out.println(SumOfParts.sumParts(new int[] {})); //{0}
//        System.out.println(SumOfParts.sumParts(new int[] {0, 1, 3, 6, 10}));  //new int[] {20, 20, 19, 16, 10, 0}
//        System.out.println(SumOfParts.sumParts(new int[] {1, 2, 3, 4, 5, 6})); //new int[] {21, 20, 18, 15, 11, 6, 0}
//        System.out.println(SumOfParts.sumParts(new int[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358})); //{10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0}
//        long[][] lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
//        long[][] lst2 = new long[][] { {69, 130}, {87, 1310}, {30, 40} };
//        System.out.println(Fracts.convertFrac(lst2)); //(18078,34060)(2262,34060)(25545,34060)
//        System.out.println(Fracts.convertFrac(lst)); //(6,12)(4,12)(3,12)
//        System.out.println("\nRESULT: " + StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } ));
//        System.out.println("SHOULD BE: apples, pears\ngrapes\nbananas");
//        System.out.println("\nRESULT: " + StripComments.stripComments("a\n b\nc ", new String[] { "#", "!"}) + ">");
//        System.out.println("SHOULD BE: a\n b\nc >");
//        System.out.println("\nRESULT: " + StripComments.stripComments("so\n$my\n ouch\n he!llo\n #bee$\n &some\n otherones\n\n!", new String[] {"$", "!", "#", "&"}));
//        System.out.println("SHOULD BE: <so\n\n ouch\n he\n\n otherones\n\n>");
//        System.out.println("\nRESULT: " + StripComments.stripComments("        ", new String[] {"#"}));
//        System.out.println("SHOULD BE: <>");
//        System.out.println("\nRESULT: " + StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } ));
//        System.out.println("SHOULD BE: a\nc\nd");
//        System.out.println("\nRESULT: " + StripComments.stripComments( "a #b\n\n\n\nc\nd $e\n\n f g\n\ncec[$\n#\n]", new String[] { "#", "$" } ));
//        System.out.println("SHOULD BE: a\n\n\n\nc\nd\n\n f g\n\ncec[\n\n]");
//        System.out.println((RangeExtraction.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20})));
//        System.out.println("SHOULD BE: -6,-3-1,3-5,7-11,14,15,17-20");
//        System.out.println(RangeExtraction.rangeExtraction(new int[] {5,-3,2,-1,55,0,-23}));  //tests disordered input
//        System.out.println("SHOULD BE: -23,-3,-1,0,2,5,55");
//        System.out.println((RangeExtraction.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20})));  //tests ability to handle range of negatives.
//        System.out.println("SHOULD BE: -3--1,2,10,15,16,18-20");
//        System.out.println(RangeExtraction.rangeExtraction(new int[] {3,3,4,5}));  //tests duplicate values input as well as input that should equal output exactly.
//        System.out.println("SHOULD BE: 3,3-5");  //I believe it should return duplicates for this kata, I'll find out if that is correct soon enough.
/*
    String a = ".W.\n" +
               ".W.\n" +
               "...",

            b =     ".W.\n" +
                    ".W.\n" +
                    "W..",

            c =     "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    "......",

            d =     "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    ".....W\n" +
                    "....W.",

            e =     ".W...\n" +
                    ".W...\n" +
                    ".W.W.\n" +
                    "...W.\n" +
                    "...W.";

    Finder finderA = new Finder();
    Finder finderB = new Finder();
    Finder finderC = new Finder();
    Finder finderD = new Finder();
    Finder finderE = new Finder();
    System.out.println("\n" + finderA.pathFinder(a) + "\n result should be true.");
    System.out.println("\n" + finderB.pathFinder(b) + "\n result should be false.");
    System.out.println("\n" + finderC.pathFinder(c) + "\n result should be true.");
    System.out.println("\n" + finderD.pathFinder(d) + "\n result should be false.");
    System.out.println("\n" + finderE.pathFinder(e) + "\n result should be true.");
*/


        /*Note: This is saved as an example to show how to use non-static methods and share variables.
        SqInRect sir = new SqInRect(); 
        sir.sqInRect(5, 3);   //look above for answer.
        sir.sqInRect(17, 30);  //look above for answer.
        */


/*    private static void average() {
    	System.out.println("enter 5 numbers:");
		final Scanner input = new Scanner(System.in);
		int total = 0;
		int grade;
		int average;
		int counter = 0;
	

		while (counter < 5) {
			grade = input.nextInt();
			total += grade;
			counter++;
		}
		input.close();
		average = total/5; 
		System.out.println("Your average is: " + average);
	}
*/
//In mathematics Average is the sum divided by the count

