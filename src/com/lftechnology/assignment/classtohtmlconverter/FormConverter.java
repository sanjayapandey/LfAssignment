/*
 * Copyright (c) . All rights reserved. 
 *
 *
 *
 */
package com.lftechnology.assignment.classtohtmlconverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The
 * <code>ClasToHtmlConverter</code> class represents
 *conversion process
 * <p>
 * Specifications:
 * Create an HTML form dynamically using the fields in the class
 * <p><pre><code>
 * 
 * java myclass.java myform.html
 * </code>
* </pre>
 *
 *
 * @author sanjaya pandey
 * @version 1.0
 *
 */
public class FormConverter {
    /**
     * The <code> takeAttributs() </code>
     * takes attributes from another class <br>
     * keeps it in <code> fieldVariable</code>
     *Calls 
     * 
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    
    void takeAttributs() throws ClassNotFoundException, IOException{
    Class<?> c  = Class.forName("com.lftechnology.assignment.classtohtmlconverter.AttributeHolder");
    Field[] f = c.getFields();
    String[] fieldVariable = new String[f.length];
    for(int i =0;i<f.length;i++){
        fieldVariable[i] = f[i].getName();
    }
    makeHtmlFile(fieldVariable);
    }
    /**
     *Makes html file Using fields on passes class
     * @param fields
     * @throws IOException 
     */
    
    void makeHtmlFile(String[] fields ) throws IOException{
        
            String header = "<html> <head> </head>";
            String footer ="Thanks for visit my page</html> ";
            String formStartElement = "<form action='formAction.html'>";
            String formEndElement ="<input type='submit' value ='submit'></form>";
            String preRequire = "";
            for(int i =0;i<fields.length;i++){
                preRequire = preRequire+fields[i].toString()+"<input type = 'text' name= '"+fields[i].toString()+"'><br><br>";
            }
            String finalString = header+formStartElement+preRequire+formEndElement+footer;
            System.out.println(finalString);
           
            String file_name = "myHtml.html";
            FileWriter fstream = new FileWriter(file_name);
            BufferedWriter out = new BufferedWriter(fstream);
             out.write(finalString);
            //Close the output stream
            out.close();
            
       
        
    }
}
