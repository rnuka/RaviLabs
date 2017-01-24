package practice.coding;

/**
 * Created by rnuka on 8/24/16.
 */
import com.xx.wordcounter.*;

import java.util.List;

public class TestWordCount {
    /**
     * sample testcase
     */
    public void testCase1(){
        WordCounter wordCnt = new WordCounter();
        String fileName="THE STORY OF THUMBELINA.txt";
        String fileFullPath = "/Users/rnuka/WordCounter/src/com/xx/wordcounter/"+fileName;

        List<Word> results = wordCnt.mostFrequentWords(fileFullPath, 10);

        //print result
        int i=0;
        System.out.println("Test Case Results");
        for(Word curr: results){
            System.out.println(++i+". "+curr.word+" has a count of "+curr.count);
        }

        //see if THE has most count otherwise Assert Fail
        //myassert(results.get(0).word.equalsIgnoreCase("THE"));
    }

    /**
     * test bench
     */
    public void testBench(){
        testCase1();
        System.out.println("--------------");

    }

    /**
     * Main method of test bench
     * @param args commandline arguments
     */
    public static void main(String args[]){
        TestWordCount wordCntrTest = new TestWordCount();
        wordCntrTest.testBench();

    }
}
