/*
 * Copyright (c) . All rights reserved. 
 *
 *
 *
 */
package com.lftechnology.assignment.taxcalculator;

/**
 * The
 * <code>TaxOperations</code>operates input data then returns taxMonthly,
 * pfMonthly, citMonthly and handInCashMoney after all related calculations.
 *
 * @author sanjaya pandey
 *
 */

public class TaxOperations {

    InputHandler inputHander = new InputHandler();
    //out box
    static float taxMonthly;
    static float pfMonthly;
    static float citMonthly;
    static float handInCashMonthly;
    private float monthlyIncome_;
    private float monthlyAllowance_;
    private float cit_;
    private float insurancePremiumMonthly_;
    private float pf_;
    private boolean isMarried_ = false;
    private boolean isFemale = false;
    private String name_;

    /**
     * It operated monthlyIncome and all related amount then finally determines
     * taxMonthly, pfMonthly, citMonthly and handInCashMoney It does not takes
     * any arguments It has no return type;
     *
     * @see com.lftechnology.assignment.taxcalculator.InputHandler
     * @see com.lftechnology.assignment.taxcalculator.TaxCalculator
     *
     *
     */
    void operation() {


        //input


        monthlyIncome_ = inputHander.getMonthlySalary();
        monthlyAllowance_ = inputHander.getMonthlyAllowance();
        cit_ = inputHander.getCit();
        insurancePremiumMonthly_ = inputHander.getInsurancePremium();
        pf_ = inputHander.getPf();
        isMarried_ = inputHander.getIsMarried();
        name_ = inputHander.getName();

        float monthlyIncomeWithPf_;
        float extraPayForInsuranceYearly_ = 0;
        float extraPayForCitYearly_ = 0;
        float applicableMoneyForTaxYearly_;
        float taxYearly_ = 0;
        float taxYearlyBracket1_;
        float taxYearlyBracket2_;
        float taxYearlyBracket3_;

        pfMonthly = pf_ * monthlyIncome_ / 100;
        monthlyIncomeWithPf_ = monthlyIncome_ + pfMonthly;
        //we can deposit 33% in cit_. So, remaining amount is 13% of total salary including pf_

        if (cit_ == 0) {
            cit_ = (float) ((0.33 - pf_ * 2 / 100) * (monthlyIncomeWithPf_+monthlyAllowance_)); //gives in percentage
        } else {
            cit_ = cit_ *(monthlyIncomeWithPf_+monthlyAllowance_)/ 100;//convert into percentage
        }
        //condition on cit_ when limit exceeds 
        if (cit_ * 12 > 300000) {
            extraPayForCitYearly_ = cit_ * 12 - 300000;
            cit_ = 300000 / 12;
        }

        //insurance premium
        if (insurancePremiumMonthly_ * 12 > 20000) {

            extraPayForInsuranceYearly_ = insurancePremiumMonthly_ * 12 - 20000;
            insurancePremiumMonthly_ = 20000 / 12;
        }


        applicableMoneyForTaxYearly_ = (monthlyIncomeWithPf_ - pfMonthly - cit_ - insurancePremiumMonthly_ +monthlyAllowance_) * 12;

        //unmarried case
        if (!isMarried_) {
            if (applicableMoneyForTaxYearly_ < 160000) {
                taxYearlyBracket1_ = (float) (applicableMoneyForTaxYearly_ * 0.01);
                taxYearly_ = taxYearly_ + taxYearlyBracket1_;
            } else if (applicableMoneyForTaxYearly_ >= 160000) {

                taxYearlyBracket1_ = (float) (1600000 * 0.01);
                taxYearly_ = taxYearly_ + taxYearlyBracket1_;

                if (applicableMoneyForTaxYearly_ >= 260000) {
                    taxYearlyBracket2_ = (float) (100000 * 0.15);
                    taxYearly_ = taxYearly_ + taxYearlyBracket2_;

                    if (applicableMoneyForTaxYearly_ > 260000) {
                        taxYearlyBracket3_ = (float) ((applicableMoneyForTaxYearly_ - 260000) * 0.25);
                        taxYearly_ = taxYearly_ + taxYearlyBracket3_;
                    }

                } else {
                    taxYearlyBracket2_ = (float) ((applicableMoneyForTaxYearly_ - 160000) * 0.15);
                    taxYearly_ = taxYearly_ + taxYearlyBracket2_;
                }

            }
        } //married case
        else if (isMarried_) {
            if (applicableMoneyForTaxYearly_ < 200000) {
                taxYearlyBracket1_ = (float) (applicableMoneyForTaxYearly_ * 0.01);
                taxYearly_ = taxYearly_ + taxYearlyBracket1_;
            } else if (applicableMoneyForTaxYearly_ > 200000) {
                taxYearlyBracket1_ = (float) (200000 * 0.01);
                taxYearly_ = taxYearly_ + taxYearlyBracket1_;

                if (applicableMoneyForTaxYearly_ >= 300000) {
                    taxYearlyBracket2_ = (float) (100000 * 0.15);
                    taxYearly_ = taxYearly_ + taxYearlyBracket2_;

                    if (applicableMoneyForTaxYearly_ > 300000) {
                        taxYearlyBracket3_ = (float) ((applicableMoneyForTaxYearly_ - 300000) * 0.25);
                        taxYearly_ = taxYearly_ + taxYearlyBracket3_;
                    }

                } else {
                    taxYearlyBracket2_ = (float) ((applicableMoneyForTaxYearly_ - 160000) * 0.15);
                    taxYearly_ = taxYearly_ + taxYearlyBracket2_;
                }

            }
        }

        //special offer for female
        if (isFemale) {
            float discount = (float) (taxYearly_ * 0.1);
            taxYearly_ = taxYearly_ - discount;
        }

        // for print 

        taxMonthly = taxYearly_ / 12;
        citMonthly = cit_;
        handInCashMonthly = monthlyIncomeWithPf_ - pfMonthly * 2 - insurancePremiumMonthly_
                - extraPayForInsuranceYearly_ / 12 - extraPayForCitYearly_ / 12 - taxYearly_ / 12;



    }

    /**
     * It is getter method which returns
     *
     * @return taxMonthly
     */
    float getTaxtMonthly() {
        return taxMonthly;
    }

    /**
     * It is getter method which returns
     *
     * @return pfMonthly
     */
    float getPfMonthly() {
        return pfMonthly;
    }

    /**
     * It is getter method which returns
     *
     * @return citMonthly
     */
    float getCitMonthly() {
        return citMonthly;
    }

    /**
     * It is getter method which returns
     *
     * @return hadInCashMonthly
     */
    float getHandInCashMonthly() {
        return handInCashMonthly;
    }
}
