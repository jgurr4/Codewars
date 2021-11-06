/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codeWarsJava;

import codeWarsJava.algorithms.SelectionSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;


public class AppTest {
  @Test
  public void testAppHasAGreeting() {
    App classUnderTest = new App();
    assertNotNull("app should have a greeting", classUnderTest.getGreeting());
  }

  @Test
  public void testSimpleDirReduc() {
    assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
            new String[]{"WEST"},
            DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
            new String[]{},
            DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
  }

  @Test
  public void testCompoundInterest() {
    assertEquals(12201.90, CompoundInterest.checker(10000), .009);
    assertEquals(12201.900399479671, CompoundInterest.checker(10000), 0);
    //Note: For double or floating point values, delta represents the amount the actual answer can be off from the correct answer. For example, 12201.9003 doesn't exactly match
    // the correct answer due to being more precise. So delta of .009 allows that to still return as true.
    //In other words it returns true in this case: Math.abs(expected - actual) < epsilon
    // You could also leave it at zero so that it has to be exactly correct, but you have to include the full expected answer as seen in example above.
  }

  @Test
  public void testMultiples() {
    assertEquals(23, new Multiples().sumOfMultiples(10));
    assertEquals(143, new Multiples().sumOfMultiples(25));
    assertEquals(0, new Multiples().sumOfMultiples(-25));
  }

  @Test
  public void testFinder() {
    String a = ".W.\n" +
            ".W.\n" +
            "...",

            b = ".W.\n" +
                    ".W.\n" +
                    "W..",

            c = "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    "......",

            d = "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    ".....W\n" +
                    "....W.",

            e = ".W...\n" +
                    ".W...\n" +
                    ".W.W.\n" +
                    "...W.\n" +
                    "...W.",

            f = ".W.W.W......",

            g = "..W...W\n" +
                    ".W..W..",

            h = "......W.............W......W......W......W.............W\n" +
                    "......W......W......W.............W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W.............W......W......W......W......W\n" +
                    "......W......W......W......W......W......W.............W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    ".............W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W.............W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W......W......W......W......W\n" +
                    "......W......W......W......W.............W......W.....W.";

    Finder finderA = new Finder();
    Finder finderB = new Finder();
    Finder finderC = new Finder();
    Finder finderD = new Finder();
    Finder finderE = new Finder();
    Finder finderF = new Finder();
    Finder finderG = new Finder();
    Finder finderH = new Finder();
    System.out.println("test A:");
    assertTrue(finderA.pathFinder(a));
    System.out.println("test B:");
    assertFalse(finderB.pathFinder(b));
    System.out.println("test C:");
    assertTrue(finderC.pathFinder(c));
    System.out.println("test D:");
    assertFalse(finderD.pathFinder(d));
    System.out.println("test E:");
    assertTrue(finderE.pathFinder(e));
    System.out.println("test F:");
    assertFalse(finderF.pathFinder(f));
    System.out.println("test G:");
    assertFalse(finderG.pathFinder(g));
    System.out.println("test H:");
    assertFalse(finderH.pathFinder(h));

  }

  @Test
  public void sampleTests() {
    assertEquals(Arrays.asList("epaeii", "ygbbyh'ie", "ueh"), TopWords.top3("eLTRGYWgSu_EpAEIi.TRGtXWEkZ;UeH bnV-SKiHIUI TRGtXWEkZ kCTvxGU UeH kcOeKnPJ-UeH jlHzCBWS-EpAEIi;bnV TRGtXWEkZ yOFbCWMnDi yGBbYh'IE/kcOeKnPJ-UeH.eLTRGYWgSu SKiHIUI Fje RHXPBgVusF UeH yGBbYh'IE kcOeKnPJ!eLTRGYWgSu EpAEIi EpAEIi/EpAEIi.kCTvxGU/aERGC-sLY' RHXPBgVusF RHXPBgVusF?RHXPBgVusF yGBbYh'IE?TRGtXWEkZ sLY' yGBbYh'IE UeH bnV EpAEIi jlHzCBWS yOFbCWMnDi_yOFbCWMnDi yGBbYh'IE?sLY' kcOeKnPJ yGBbYh'IE;UeH bnV-EpAEIi?UeH UeH.jlHzCBWS yOFbCWMnDi kcOeKnPJ?bnV EpAEIi?bnV t'gxk:bnV-SKiHIUI.TRGtXWEkZ kCTvxGU sLY' RHXPBgVusF yOFbCWMnDi/bnV jlHzCBWS eLTRGYWgSu UeH_SKiHIUI,EpAEIi t'gxk.kCTvxGU EpAEIi UeH bnV_aERGC yGBbYh'IE;yGBbYh'IE;TRGtXWEkZ?yGBbYh'IE EpAEIi:bnV yGBbYh'IE TRGtXWEkZ EpAEIi.TRGtXWEkZ aERGC TRGtXWEkZ;kCTvxGU-eLTRGYWgSu EpAEIi RHXPBgVusF-jlHzCBWS yOFbCWMnDi yGBbYh'IE.RHXPBgVusF EpAEIi:jlHzCBWS:kCTvxGU?RHXPBgVusF;Fje sLY' SKiHIUI.yOFbCWMnDi?SbyxHWD RHXPBgVusF/eLTRGYWgSu TRGtXWEkZ/aERGC bnV?EpAEIi.jlHzCBWS eLTRGYWgSu jlHzCBWS eLTRGYWgSu sLY':jlHzCBWS eLTRGYWgSu_SKiHIUI SKiHIUI jlHzCBWS-jlHzCBWS sLY' yGBbYh'IE kcOeKnPJ.eLTRGYWgSu!t'gxk,TRGtXWEkZ sLY'!TRGtXWEkZ TRGtXWEkZ;sLY' EpAEIi_kCTvxGU RHXPBgVusF TRGtXWEkZ-aERGC.bnV bnV,UeH,EpAEIi bnV UeH/aERGC sLY'_sLY'_eLTRGYWgSu bnV yGBbYh'IE kCTvxGU:EpAEIi kcOeKnPJ yOFbCWMnDi TRGtXWEkZ aERGC?Fje bnV kcOeKnPJ SbyxHWD_aERGC SKiHIUI UeH yGBbYh'IE bnV:sLY' RHXPBgVusF?EpAEIi EpAEIi EpAEIi:SKiHIUI kcOeKnPJ;yGBbYh'IE;Fje TRGtXWEkZ:t'gxk yGBbYh'IE yGBbYh'IE:yGBbYh'IE bnV Fje;EpAEIi UeH,TRGtXWEkZ TRGtXWEkZ TRGtXWEkZ?sLY'_eLTRGYWgSu eLTRGYWgSu bnV sLY' kCTvxGU/SKiHIUI UeH yGBbYh'IE/eLTRGYWgSu:aERGC yOFbCWMnDi yOFbCWMnDi sLY' EpAEIi-UeH UeH-yGBbYh'IE eLTRGYWgSu TRGtXWEkZ yOFbCWMnDi/EpAEIi/yGBbYh'IE RHXPBgVusF/eLTRGYWgSu UeH sLY';RHXPBgVusF TRGtXWEkZ EpAEIi RHXPBgVusF_kcOeKnPJ SKiHIUI kCTvxGU;eLTRGYWgSu?t'gxk TRGtXWEkZ?yGBbYh'IE UeH kCTvxGU,yGBbYh'IE yGBbYh'IE?kcOeKnPJ_yOFbCWMnDi eLTRGYWgSu aERGC UeH UeH kCTvxGU-bnV-kCTvxGU sLY'-RHXPBgVusF:sLY' UeH-yGBbYh'IE UeH!yGBbYh'IE UeH-EpAEIi!EpAEIi RHXPBgVusF yOFbCWMnDi EpAEIi;RHXPBgVusF:EpAEIi SbyxHWD TRGtXWEkZ_RHXPBgVusF!TRGtXWEkZ eLTRGYWgSu?TRGtXWEkZ sLY',kCTvxGU;yGBbYh'IE kCTvxGU/jlHzCBWS bnV_jlHzCBWS,t'gxk kCTvxGU bnV jlHzCBWS.sLY' jlHzCBWS;YdfIGc bnV,TRGtXWEkZ RHXPBgVusF sLY' EpAEIi t'gxk TRGtXWEkZ/yGBbYh'IE sLY' kCTvxGU UeH kCTvxGU yGBbYh'IE yOFbCWMnDi eLTRGYWgSu t'gxk UeH UeH bnV!t'gxk eLTRGYWgSu kcOeKnPJ SKiHIUI-kCTvxGU UeH aERGC eLTRGYWgSu t'gxk:"));
    assertEquals(Arrays.asList("e", "ddd", "aa"), TopWords.top3("e e e e DDD DDD DDD: DdD ddd aa aA Aa, bb cc cC e e e"));
    assertEquals(Arrays.asList("e", "d", "a"), TopWords.top3("a a a  b  c c  d d d d  e e e e e"));
    assertEquals(Arrays.asList("won't", "wont"), TopWords.top3("  //wont won't won't "));
    assertEquals(Arrays.asList("e"), TopWords.top3("  , e   .. "));
    assertEquals(Arrays.asList(), TopWords.top3("  ...  "));
    assertEquals(Arrays.asList(), TopWords.top3("  '  "));
    assertEquals(Arrays.asList(), TopWords.top3("  '''  "));
    assertEquals(Arrays.asList("a", "of", "on"), TopWords.top3(Stream
            .of("In a village of La Mancha, the name of which I have no desire to call to",
                    "mind, there lived not long since one of those gentlemen that keep a lance",
                    "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                    "coursing. An olla of rather more beef than mutton, a salad on most",
                    "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                    "on Sundays, made away with three-quarters of his income.")
            .collect(joining("\n"))));
  }


  //[1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, 28, 31, 39, 40, 43, 45, 49, 55, 57, 58, 64, 67, 82]
  @Test
  public void doubleLinearTest() {

    assertEquals(22, DoubleLinear.dblLinear(10));
    assertEquals(57, DoubleLinear.dblLinear(20));
    assertEquals(91, DoubleLinear.dblLinear(30));
    assertEquals(175, DoubleLinear.dblLinear(50));
    assertEquals(80914, DoubleLinear.dblLinear(6000));
    assertEquals(227638, DoubleLinear.dblLinear(13526));

  }

  @Test
  public void josephusSurvivorTest() {
    assertEquals(4, JosephusSurvivor.josephusSurvivor(7, 3));
    assertEquals(10, JosephusSurvivor.josephusSurvivor(11, 19));
    assertEquals(28, JosephusSurvivor.josephusSurvivor(40, 3));
    assertEquals(100, JosephusSurvivor.josephusSurvivor(100, 1));
  }

  @Test
  public void humanReadableTimeTest() {
    assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
    assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
    assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
    assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
    assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
  }

  @Test
  public void countDuplicatesTest() {
    Playground.printNumberOfDuplicates(new int[]{1, 1, 1, 1, 2, 2, 4, 4, 4, 5, 5, 6, 7, 7, 8, 9, 9, 9, 9});
    Playground.printNumberOfDuplicates(new int[]{1, 1, 1, 1, 2, 2, 4});
  }

  @Test
  public void playgroundTest() {
    Playground myPlay = new Playground();         //How to use non-static methods.
    myPlay.rxJava3Practice();
    Playground.fileOperations();
    assertEquals(new ArrayList<String>(Arrays.asList("Benny")), Playground.compareEmployeeFiles());
    assertEquals(16, myPlay.exponent(2, 4));
    assertEquals(3, Playground.modulo(8, 5));  //How to use static methods.
    assertEquals(5, MorePlay.modulo(11, 6));
    assertEquals(2, MorePlay.divide(8, 4));
    assertEquals(4, Playground.Something.multiply(2, 2));  //Accessing nested class method.
    final int totalRuns = Playground.totalRuns;
    System.out.println("total runs = " + totalRuns);
  }

  @Test
  public void snailTest() {
    int[][] array =
            {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
    int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
    int[][] arr2 =
            {{1, 2, 3, 9},
            {4, 5, 6, 4},
            {7, 8, 9, 1},
            {1, 2, 3, 4}};
    int[] r2 = {1, 2, 3, 9, 4, 1, 4, 3, 2, 1, 7, 4, 5, 6, 9, 8};

//    test(array, r);
    test(arr2, r2);
  }

  public String int2dToString(int[][] a) {
    return Arrays.stream(a).map(row -> Arrays.toString(row)).collect(joining("\n"));
  }

  public void test(int[][] array, int[] result) {
    String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
    System.out.println(text);
    Assert.assertArrayEquals(result, Snail.snail(array));
  }

  @Test
  public void selectionSortTest() {
    assertEquals(Arrays.toString(new int[]{4, 5, 12, 23, 23, 25, 28, 30}), Arrays.toString(
            SelectionSort.sort(new int[]{23, 12, 4, 5, 30, 28, 25, 23})
    ));
    assertEquals(Arrays.toString(new int[]{}), Arrays.toString(SelectionSort.sort(new int[]{})));
    assertEquals(Arrays.toString(new char[]{'a','a','a','b','b','c','c','c','d','d','d','d','e','e','e'}), Arrays.toString(SelectionSort.sort(new char[]{'d','e','b','a','c','c','e','d','d','a','b','c','a','e','d'})));
/*
    assertEquals(Arrays.toString(new String[]{"bob", "john", "jose", "kevin", "mary"}), Arrays.toString(
            SelectionSort.sort(new String[]{"john", "mary", "kevin", "bob", "jose"})
    ));
*/
  }

  @Test
  public void removeThreesTest() {
    assertEquals("[1, 2, 4, 5, 6]", RemoveThrees.removeThrees(new int[]{1, 2, 3, 4, 5, 6}));
    assertEquals("[6, 2, 80, 23, 14, 27, 18, 28, 45, 10, 9, 17]", RemoveThrees.removeThrees(new int[]{6, 3, 2, 80, 3, 23, 3, 14, 27, 3, 18, 28, 45, 3, 10, 9, 17}));
  }

  @Test
  public void spiralizorTest() {
    assertArrayEquals(new int[][] {
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 1},
        {1, 1, 1, 0, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1}
    }, Spiralizor.spiralize(5));
  }


  @Test
  public void getZeros() {
    assertEquals(4, Factorial.getZeros(23));
    assertEquals(0, Factorial.getZeros(4));
  }

}


