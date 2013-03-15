/*
 * Copyright (c) . All rights reserved. 
 *
 *
 *
 */
package com.lftechnology.assignment.taxcalculator;

/**
 * Finally displays all the summary of tax calculator taxMonthly,pfMonthly,
 * citMonthly and handInCashMoney
 *
 * @author syanjo
 */
public class SummaryTaxCalculator {

    TaxOperations taxOperations = new TaxOperations();

    /**
     * display taxMonthly,pfMonthly, citMonthly and handInCashMoney after all
     * related calculations.
     *
     * @see com.lftechnology.assignment.taxcalculator.InputHandler
     * @see com.lftechnology.assignment.taxcalculator.TaxCalculator
     */
    SummaryTaxCalculator() {
        System.out.println("your monthly CIT is:" + taxOperations.getCitMonthly());
        System.out.println("your monthly handInCash is:" + taxOperations.getHandInCashMonthly());
        System.out.println("your monthly Pf is:" + taxOperations.getPfMonthly());
        System.out.println("Your monthly tax is:" + taxOperations.getTaxtMonthly());
    }
}
