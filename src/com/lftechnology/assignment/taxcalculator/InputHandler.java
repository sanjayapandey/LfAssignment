/*
 * Copyright (c) . All rights reserved. 
 *
 *
 *
 */
package com.lftechnology.assignment.taxcalculator;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * All the input handle by this class, It takes those data:
 * <pre>
 * <code>Monthly tax
 * Monthly PF amount
 * Monthly CIT amount
 * Monthly cash in hand<code></pre>
 *
 * @author syanjo
 */
public class InputHandler {
    //input variables

    static private String name;
    static private float monthlySalary;
    static private float monthlyAllowance;
    static private float cit;
    static private float insurancePremium;
    static private float pf;
    static private boolean isMarried;
    static private boolean isFemale;
    static private boolean haveTakeCit;

    /**
     * Operates Monthly tax Monthly PF amount Monthly CIT amount Monthly cash in
     * hand
     *
     * @see com.lftechnology.assignment.taxcalculator.TaxCalculator
     */
    void inputOperation() {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



            System.out.println("Enter Name:");
            name = br.readLine();

            System.out.println("Monthly income:");
            monthlySalary = Float.parseFloat(br.readLine());

            System.out.println("Enter PF percentage:");
            pf = Float.parseFloat(br.readLine());

            System.out.println("Monthly allowance:");
            monthlyAllowance = Float.parseFloat(br.readLine());

            System.out.println("If you wanna enter your CIT?? (true/false):");
            haveTakeCit = new Boolean(br.readLine()).booleanValue();

            if (haveTakeCit) {
                System.out.println("Enter CIT percentage:");
                cit = Float.parseFloat(br.readLine());
            }

            System.out.println("Monthly Insurance premium:");
            insurancePremium = Float.parseFloat(br.readLine());

            System.out.println("If you are married, Enter true and else Enter false :");
            isMarried = new Boolean(br.readLine()).booleanValue();

            System.out.println("If you are Male enter true else enter false:");
            isFemale = new Boolean(br.readLine()).booleanValue();



        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        } catch (IOException ex) {
            Logger.getLogger(TaxCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * It is getter method which returns
     *
     * @return monthlySalary
     */
    float getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * It is getter method which returns
     *
     * @return monthlyAllowance
     */
    float getMonthlyAllowance() {
        return monthlyAllowance;
    }

    /**
     * It is getter method which returns
     *
     * @return cit
     */
    float getCit() {
        return cit;
    }

    /**
     * It is getter method which returns
     *
     * @return insurancePremium
     */
    float getInsurancePremium() {
        return insurancePremium;
    }

    /**
     * It is getter method which returns
     *
     * @return pf
     */
    float getPf() {
        return pf;
    }

    /**
     * It is getter method which returns
     *
     * @return isMarried
     */
    boolean getIsMarried() {
        return isMarried;
    }

    /**
     * It is getter method which returns
     *
     * @return
     */
    boolean getIsFemale() {
        return isFemale;
    }

    /**
     * It is getter method which returns
     *
     * @return
     */
    String getName() {
        return name;
    }
}
