/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lftechnology.assignment.wordswithcounter;

import java.io.IOException;

/**
 * It is
 * <code>WordCounterHandle class</code> for word count and store them into
 * another file by sorting them into decreasing order <br>
 *
 * @author syanjo
 *
 */
public class WordCounterHandle {

    /**
     * We have a input txt file which contains some information <br>
     * This WordCounterHandle takes the name of input txt file as *.txt <br>
     * and then stores them into
     * <code>ArrayList of WordWithCounter</code><br>
     * using
     * <code>ArrayList of type String</code>, Which is used as a temporary
     * holder of those all words;<br>
     * <code>Sorting operation </code> is performed Finally top five word are
     * stored in another txt file.
     * @param agrs
     * @throws IOException
     * @see com.lftechnology.assignment.wordswithcounter.WordWithCounter
     * @see com.lftechnology.assignment.wordswithcounter.WordCounter
     */
    public static void main(String[] agrs) throws IOException {
        WordCounter wordCounter = new WordCounter();
        wordCounter.addWordInArrayList("inputFile.txt");
        wordCounter.storeWordsCount();
        wordCounter.sortingOperation();
        wordCounter.createFile();
    }
}
