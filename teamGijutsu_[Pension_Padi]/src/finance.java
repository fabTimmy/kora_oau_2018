/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oluwaseun
 */
public class finance {
    /***
     * class to deal with all calculations of salary and gratuity
     */
    public static double pension_balance = 0;
    public static double gratuity = 0;
    public static double wallet_balance = 0;
    public static double last_salary = 0;
    public static double pension_contribute = 0;
    public static double pension_draw = 0;
    public static int age = 0;
    public static double year = 0;
   /**
    * 
    * @param pension_contribution gets your total pension contribution as at the time of retirement/death
    * @param last_salary gets the last salary received by the worker before death or retirement
    * @return 
    */ 
    public static double getPension(double pension_contribution, double last_salary){
        if (pension_contribution > ((20/100)*last_salary)){
            pension_contribution = (20/100)*last_salary;
        }
        pension_balance += pension_contribution;
        return pension_balance;
    }
   /** NOTE : once you retire, your pension draw becomes your salary
    * 
    * @return pension draw as salary
    */ 
    public static double getSalarypay(){
        if (RetireStatus(age,year) == true){
            if (pension_balance - pension_draw > 0){
                last_salary = pension_draw;
            }
            else if (pension_balance - pension_draw < 0){
                last_salary = pension_balance;
                pension_balance = 0;
            }
            else{
                 last_salary = 0;
            }
            
        }
        else if (RetireStatus(age,year) == false){
            last_salary -= pension_contribute;
            pension_balance += pension_contribute; 
        }
        return last_salary;
    }
    /**
     * method to pay salary based on balance
     * @param salary
     * @return new wallet balance for transaction
     */
    public static double paySalary(double salary){
        wallet_balance += salary;
        return wallet_balance;
    }
    /**
     * 
     * @param salary, the last salary as at the time of retirement
     * @param years, the number of years spent in service
     * @return the calculated gratuity
     */
    public static double computeGratuity(double salary,double years){
        int year = (int) Math.ceil(years);
        //years needs to be changed to float and rounded up
        
        if (year >= 5){
            gratuity = (salary / 26)*15*year;
        }
        else{
        gratuity = 0;
        }
        return gratuity;
    }
    /**
     * 
     * @param age age of the worker as at the time of checking, determined by the date of birth
     * @param years the number of years spent in service
     * @return  boolean retirement status... true if you should retire 
     */
      
    public static boolean RetireStatus(int age, double years){
        
        int year = (int) Math.ceil(years);
        
        boolean status = false;
        if (age >= 60 | year >= 35){
            status = true;
        }
        else{
            status = false;
        }
        return status;
        
    }
    
}
