/*
 * Copyright (c) . All rights reserved. 
 *
 *
 *
 */
package com.lftechnology.assignment.taxcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The
 * <code>TaxCalculator</code> class represents tax Calculator This is useful in
 * every case where we have to determine tax and also related facts.
 * 
 * <b>Specifications:</b>
 * <p><pre>
 * PF can be max 10% of income (not allowance)
 *Company will match the PF amount
 *CIT can be max 33% of total income
 *CIT total yearly cannot exceed Rs. 300,000.
 *Insurance deduction max 20,000 per year.
 *Tax calculated on yearly tax
 *income is divided into 3 brackets
 *bracket 1 – 160000 for unmarried, 200,000 for married employees
 *bracket 2 – next 100,000
 *bracket 3 – anything else
 *tax on bracket 1 – 1%
 *tax on bracket 2 – 15%
 *tax on bracket 3 – 25%taxMonthly
 *Females get 10% off of the total tax
 *When designing the class, make allowance for feature addition – bonus,
 * salary increments, pay cuts due to leaves.</pre>
 *
 *
 * @author sanjaya pandey
 *
 */
public class TaxCalculator {

    /**
     * It first takes all the input using {@Link InputHandler }
     * Then all those operations performed in {@Link TaxOperations.operation}
     * After all Display those results as a summary.
     *
     * @see com.lftechnology.assignment.taxcalculator.InputHandler
     * @see com.lftechnology.assignment.taxcalculator.TaxOperations
     * @see com.lftechnology.assignment.taxcalculator.SummaryTaxCalculator
     *
     *
     */
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        inputHandler.inputOperation();

        TaxOperations taxtOperations = new TaxOperations();
        taxtOperations.operation();

        SummaryTaxCalculator summaryTaxCalculator = new SummaryTaxCalculator();

    }
}
