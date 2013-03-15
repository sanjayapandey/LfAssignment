/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lftechnology.assignment.wordswithcounter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Soundbank;

/**
 *
 * @author syanjo
 */
public class WordCounter {

    List<String> listOfWords = new ArrayList<String>();
    List<String> copyOflistOfWords = new ArrayList<String>();
    ArrayList<WordWithCounter> wordCountholder = new ArrayList<>();

    /**
     * 
     * @param fileName 
     */
    public void addWordInArrayList(String fileName) {

        try {
            BufferedReader textOfFile = new BufferedReader(new FileReader(fileName));
            try {
                String line = null;
                while ((line = textOfFile.readLine()) != null) {
                    
                    String[] wordCollector = line.split("[,\\s\\-:?|/\\\\;!]+");

                    for (int i = 0; i < wordCollector.length; i++) {
                        listOfWords.add(wordCollector[i].toLowerCase());
                    }
                }
                textOfFile.close();
            } catch (IOException ex) {
                Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @throws 
     */
    void storeWordsCount() {

        WordWithCounter w = null;

        //with increase of counter
        for (int i = 0; i < listOfWords.size(); i++) {
            if (wordCountholder.isEmpty()) {
                w = new WordWithCounter(listOfWords.get(i));
                wordCountholder.add(w);
                continue;
            }
            //search in the list, if exists then increase in the counter
            boolean haveToInsert = true;
            for (int j = 0; j < wordCountholder.size(); j++) {
                if (listOfWords.get(i).equals(wordCountholder.get(j).word)) {
                    haveToInsert = false;
                    w = wordCountholder.get(j);
                    w.wordCount++;
                    break;
                }
            }
            if (haveToInsert) {
                w = new WordWithCounter(listOfWords.get(i));
                wordCountholder.add(w);
            }
        }

    }

    void sortingOperation() {
        Collections.sort(wordCountholder, new Comparator<WordWithCounter>() {
            @Override
            public int compare(WordWithCounter o1, WordWithCounter o2) {
                return o2.wordCount - o1.wordCount;
            }
        });

    }

    /**
     * It create outFile.txt which contains top 5 words 
     * in inputFile.txt 
     * @throws IOException 
     */
    void createFile() throws IOException {
        String file_name = "outFile.txt";
        FileWriter fstream = new FileWriter(file_name);
        try (BufferedWriter out = new BufferedWriter(fstream)) {
            for (int i = 0; i < wordCountholder.size(); i++) {
                out.write( wordCountholder.get(i).word +"\t count:"+ wordCountholder.get(i).wordCount+"\n");
                if (i == 4) {
                    break;
                }
            }
        }
    }
}
