import java.util.Scanner;
import java.util.ArrayList;
/**
 * Creates the wordGame and determines if the endWord is possible within steps
 * 
 * @ Tim Saxe
 * @ 12/8/2015
 */
public class Main
{
    /**
     * Constructor for objects of class Main
     */
    public static void Main()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Start word: ");
        String startWord = s.next();
        System.out.println("End word: ");
        String endWord = s.next();
        System.out.println("Number of steps: ");
        int steps = s.nextInt();
        ArrayList <String> changes = new ArrayList <String>();
        
        Stopwatch stop = new Stopwatch();
        WordGame w = new WordGame("wordList.txt");
        stop.start();
        w.recursiveChange(startWord, endWord, steps, changes);
        stop.stop();
        System.out.println(changes);
        System.out.println(stop);
    }
}
