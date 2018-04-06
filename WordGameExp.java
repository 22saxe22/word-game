import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * Takes in the start word and outputs if it is possible to reach the entered
 * end word within the desired steps
 * @ Tim Saxe
 * @ 12/4/2015
 */
public class WordGameExp
{
    HashSet<String>  words2 = new HashSet<String>();
    /**
     * Constructor for WordGame2
     * @param filename the file that conatains the dictionary for the project
     */
    public WordGameExp(String filename)
    {
        Scanner inFile = null;
        try{
            inFile = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error opening file");
            System.exit(0);
        }

        while (inFile.hasNextLine())
        {
            String line = inFile.nextLine();
            words2.add(line);
        }
        
        ArrayList <String> changes = new ArrayList <String>();
    }

    /**
     * Converts an int to a letter
     * @param number the int that will be converted
     * @return letters[number] the desired letter from the given number
     */
    public char numberConverter(int number) {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        return letters[number];
    }

    /**
     * Replaces a letter at a certain position in the given startword
     * @param letter the new char 
     * @param position the new position of the char
     * @param startWord the word in which the char is being changed
     * @return sb.toString() the new word with letter inserted at position 
     */
    public String replace (char letter, int position, String startWord)
    {
        StringBuilder sb = new StringBuilder(startWord);
        sb.setCharAt(position, letter);
        return sb.toString();
    }

    /**
     * Actually changes the startWord to endWord in the desired steps if its possible
     * @param startWord the begininning word
     * @param endWord the target word
     * @param steps the desired number of steps it will be completed in
     * @param ArrayList <String> changes2 the words as they are changed each step 
     * @return true if the endWord is possible within steps
     * @return false if the endWord isn't possible within steps
     */
    public boolean recursiveChange(String startWord, String endWord, int steps, ArrayList <String> changes2)
    {
        if (startWord.equals(endWord))
        {
            changes2.add(0, startWord);
            return true;
        }

        else if(steps == 0)
        {
            return false;
        }

        for(int i = 0; i < startWord.length(); i++)
        {
            startWord.charAt(i);
            for (int j = 0; j < 26; j++)
            {
                numberConverter(j);
                String word = replace(numberConverter(j), i, startWord);
                if(words2.contains(word) == true)
                {boolean success = recursiveChange(word, endWord, steps - 1, changes2);
                    if(success == true) 
                    {
                        changes2.add(0, startWord);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
