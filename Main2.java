import java.util.Scanner;
import java.util.ArrayList;
/**
 * Creates the wordGame and determines if the endWord is possible within steps
 * 
 * @ Tim Saxe
 * @ 12/8/2015
 */
public class Main2
{
    /**
     * Constructor for objects of class Main
     */
    public static void Main2()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Start word: ");
        String startWord = s.next();
        System.out.println("End word: ");
        String endWord = s.next();
        System.out.println("Number of steps: ");
        int steps = s.nextInt();
        ArrayList <String> changes2 = new ArrayList <String>();
        
        Stopwatch stop2 = new Stopwatch();
        WordGameExp w = new WordGameExp("wordList.txt");
        stop2.start();
        w.recursiveChange(startWord, endWord, steps, changes2);
        stop2.stop();
        System.out.println(changes2);
        System.out.println(stop2);
    }
}
