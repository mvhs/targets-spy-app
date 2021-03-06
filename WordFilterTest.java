import java.io.*;
import java.util.List;

/**
 * Automatic tests run on WordFilter
 * You do not need to modify this file.
 * Using `targets check` or the web console
 * to run the tests included here.
 * 
 * These tests are basic. Passing them does
 * not guarantee that your code works or that
 * you will receive full credit on the assignment.
 * @author Jack Thakar
 */
public class WordFilterTest {
    public static void main(String[] args) {
        if (args[0].equals("getFourLetterWords")) {
            testGetFourLetterWords();
        } else if (args[0].equals("findFour")) {
            testFindFour();
        } else if (args[0].equals("replaceFour")) {
            testReplaceFour();
        } else if (args[0].equals("getLog")) {
            testGetLog();
        } else if (args[0].equals("printFilteredText")) {
            testPrintFilteredText();
        } else if (args[0].equals("challenge")) {
            challengeTests();
        }
    }
    
    private static void testGetFourLetterWords() {
        List<String> words = WordFilter.getFourLetterWords();
        if (words == null) {
            System.out.println("failed");
        } else if(words.size()<8||!words.contains("food")||
                !words.contains("pear")||!words.contains("taco")) {
            System.out.println("failed");
        } else System.out.println("passed");
    }
    
    private static void testFindFour() {
        WordFilter wf = new WordFilter("Hello a food pear taco testing food pear taco");
        WordFilter wf2 = new WordFilter("A sentence is perfect pears tacos");
        List<String> findA = wf.findFour();
        List<String> findB = wf2.findFour();
        if (findA == null || findB == null || 
            findA.size() != 6 || findB.size() != 0) {
            System.out.println("failed");
        } else if (!findA.get(0).equals("food") || 
            !findA.get(2).equals("taco")) {
            System.out.println("failed");
        } else System.out.println("passed");
    }
    
    private static void testReplaceFour() {
        WordFilter wf = new WordFilter("Hello a food pear taco testing food pear taco");
        WordFilter wf2 = new WordFilter("A sentence is perfect pears tacos");
        String resultA = wf.replaceFour("food");
        wf.replaceFour("taco");
        String resultB = wf.replaceFour("food");
        wf.replaceFour("pear");
        wf.replaceFour("pear");
        String resultC = wf.replaceFour("taco");
        String expectedA = "Hello a **** pear taco testing food pear taco";
        String expectedB = "Hello a **** pear **** testing **** pear taco";
        String expectedC = "Hello a **** **** **** testing **** **** ****";
        if (!expectedA.equals(resultA)||!expectedB.equals(resultB)||!expectedC.equals(resultC)) {
            System.out.println("failed");
        } else System.out.println("passed");
    }
    
    private static void testGetLog() {
        WordFilter wf = new WordFilter("Hello a food pear taco testing food pear taco");
        WordFilter wf2 = new WordFilter("A sentence is perfect pears tacos");
        wf.replaceFour("food");
        wf.replaceFour("taco");
        wf.replaceFour("food");
        wf.replaceFour("pear");
        wf.replaceFour("pear");
        wf.replaceFour("taco");
        List<String> log = wf.getLog();
        if (log==null || log.size() != 6 || 
            !log.get(0).toLowerCase().equals("food")||
            !log.get(5).toLowerCase().equals("taco")){
            System.out.println("failed");
        } else System.out.println("passed");
    }
    
    private static void testPrintFilteredText() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String text = "food pear taco testing 1 2 3 food pear taco";
        WordFilter filter = new WordFilter(text);
        filter.printFilteredText();
        String filtered = baos.toString();
        System.setOut(stdout);
        String expected = "**** **** **** testing 1 2 3 **** **** ****";
        if (!expected.equals(filtered.trim())) {
            System.out.println("failed");
        } else System.out.println("passed");
    }

    private static void challengeTests() {
        //getFourLetterWords
        List<String> words = WordFilter.getFourLetterWords();
        if (words == null) {
            error("getFourLetterWords");
        } else if(words.size()<8||!words.contains("food")||
                !words.contains("pear")||!words.contains("taco")) {
            error("getFourLetterWords");
        }
        WordFilter wf = new WordFilter("Hello a food pear taco testing Food PEAR tAcO");
        WordFilter wf2 = new WordFilter("A sentence is perfect pears tacos");
        List<String> findA = wf.findFour();
        List<String> findB = wf2.findFour();
        if (findA == null || findB == null || 
            findA.size() != 6 || findB.size() != 0) {
            error("findFour");
        } else if (!findA.get(0).equals("food") || 
            !findA.get(2).equals("taco")) {
            error("findFour");
        }
        //replaceFour
        String resultA = wf.replaceFour("food");
        wf.replaceFour("taco");
        String resultB = wf.replaceFour("food");
        wf.replaceFour("pear");
        wf.replaceFour("pear");
        String resultC = wf.replaceFour("taco");
        String expectedA = "Hello a **** pear taco testing Food PEAR tAcO";
        String expectedB = "Hello a **** pear **** testing **** PEAR tAcO";
        String expectedC = "Hello a **** **** **** testing **** **** ****";
        if (!expectedA.equals(resultA)||!expectedB.equals(resultB)||!expectedC.equals(resultC)) {
            error("replaceFour");
        }
        //getLog
        List<String> log = wf.getLog();
        if (log==null || log.size() != 6 || 
            !log.get(0).toLowerCase().equals("food")||
            !log.get(5).toLowerCase().equals("taco")){
            error("getLog");
        }
        //printFilteredText
        PrintStream stdout = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String text = "food pear taco testing 1 2 3 Food PEAR tAcO";
        WordFilter filter = new WordFilter(text);
        filter.printFilteredText();
        String filtered = baos.toString();
        System.setOut(stdout);
        String expected = "**** **** **** testing 1 2 3 **** **** ****";
        if (!expected.equals(filtered.trim())) {
            error("printFilteredText");
        }
    }
    
    private static boolean firstError = true;
    
    private static void error(String err){
        if(firstError){
            firstError = false;
            System.out.println("\nErrors With:");
        }
        System.out.println("    " + err);
    }
}
