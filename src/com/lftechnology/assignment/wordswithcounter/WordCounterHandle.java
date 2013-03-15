/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lftechnology.assignment.wordswithcounter;

import java.io.IOException;

/**
 *
 * @author syanjo
 */
public class WordCounterHandle {

    public static void main(String[] agrs) throws IOException {
        WordCounter wordCounter = new WordCounter();
        wordCounter.addWordInArrayList("inputFile.txt");
        wordCounter.storeWordsCount();
        wordCounter.sortingOperation();
        wordCounter.createFile();
    }
}
