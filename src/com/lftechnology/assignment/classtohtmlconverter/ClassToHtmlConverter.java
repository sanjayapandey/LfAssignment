/*
 * Copyright (c) . All rights reserved. 
 *
 *
 *
 */
package com.lftechnology.assignment.classtohtmlconverter;

import java.io.IOException;


/**
 * The
 * <code>ClasToHtmlConverter</code> class represents
 *conversion process
 * <p>
 * Specifications:
 * <p><pre><code>
 * Create an HTML form dynamically using the fields in the class.
 * $ java myclass.java myform.html
 * </code>
* </pre>
 *
 *
 * @author sanjaya pandey
 *
 */


public class ClassToHtmlConverter {
    
    /**
     * It first takes name of html file form user then 
     * dynamic builds html file using those files which 
     * are present in the another java class
     *{@link com.lftechnology.assignment.classtohtmlconverter.AttributeHolder myLink}
     *
     * @throws  ClassNotFoundException
     * 
     * @throws  IOException
     * 
     * @see com.lftechnology.assignment.classtohtmlconverter.AttributeHolder
     * @see com.lftechnology.assignment.classtohtmlconverter.FormConverter
     *
     *
     */
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        FormConverter formConverter = new FormConverter();
        formConverter.takeAttributs();
    }
}
