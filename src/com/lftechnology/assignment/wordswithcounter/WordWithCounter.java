/*
 * 
 */
package com.lftechnology.assignment.wordswithcounter;

/**
 *This <code>WordWithCounter </code>class  holds two data; word and its word count
 * <br> The <code>WordWithCounter</code> constructor does initialization of count equal to 1 of 
 * that related word.
 * @author syanjo
 */
class WordWithCounter {
    /**
     * This <code>word</code> of <code>String </code> datatype holds word from<br>
     * file.
     */
    public String word;
    /**
     * This <code>wordCount</code> of <code> Integer</code> datatype holds count of <br>
     * every words; Intially its value set into 1 by constructor but after all its <br>
     * value is increases it same word is repeated in multiple time on that file. 
     * 
     */
    public int wordCount;
/**
 * This <code>WordWithCounter</code> is constructor.
 * @param word 
 * @see com.lftechnology.assignment.wordswithcounter.WordCounterHandle 
 * @see com.lftechnology.assignment.wordswithcounter.WordCounter
 */
    public WordWithCounter(String word) {
    this.word = word;
    /**
     * wordCount is set to 1; The increment is done in another <code>class WordCounter</code>.
     * 
     */
    wordCount =1;
    }
    
    
}
