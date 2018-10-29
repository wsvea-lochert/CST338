/*
 * Title: Homework5
 * Abstract: This program is a bank account simulation program with a savings and checking account.
 *           You can deposit and withdraw form the accounts.
 * Author: William Svea-Lochert
 * Date: 10/28/2018
 */

package csumb.william.homework5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import java.util.Locale;
import java.util.Scanner;


public class AccountApp {

    private static String intrestratePritty(Double intrest){
        return new DecimalFormat("#").format(intrest) + "%";
    }

    private static String prettifyAmount(double amount) {
        Locale locale = new Locale("en", "US");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        String pattern = "#,###.####";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setGroupingSize(3);
        String number = decimalFormat.format(amount);
        if((amount%100) == 0){
            number += ".00";
        }
        return number;
    }

    public static void display(CheckingAccount ch, SavingsAccount sv){
       // DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("OK! This is your information");
        System.out.println("Checking Amount: $" + prettifyAmount(ch.getBalance()));
        System.out.println("Checking Amount: $" + prettifyAmount(sv.getBalance()));
        System.out.println("Checking Fee: $" + ch.getTransactionFee());
        System.out.println("Interest Rate: " + intrestratePritty(sv.getMonthlyIntrestRate()));
    }

    public static void transactions(CheckingAccount ch, SavingsAccount sv){

        Scanner sc = new Scanner(System.in);
        char cont = 'Y';
        while(cont == 'Y'){
            System.out.print("Withdrawal or deposit? (w/d): ");
            char withdrawOrDeposit = sc.next().toUpperCase().charAt(0);

            switch (withdrawOrDeposit){
                case 'W':
                    withdrawAmount(ch, sv);
                    break;
                case 'D':
                    depositAmount(ch, sv);
                    break;
                default:
                    System.out.println("invalid option, try agien.");
                    transactions(ch, sv);
            }
            System.out.print("Continue? (y/n): ");
            cont = continueValue();
        }


        sv.setLastBalance();

        System.out.println("Monthly Payments and Fees");
        System.out.println("checking fee: $" + ch.getTotalFee());
        System.out.println("Savings intrest payment: $" + sv.getMonthlyIntrestPayment());
        System.out.println("Final Balances");
        System.out.println("Checking: $" + ch.getBalance());
        System.out.println("Savings: $" + sv.getBalance());
    }

    public static char continueValue(){
        Scanner sc = new Scanner(System.in);
        char tempCont = sc.next().toUpperCase().charAt(0);

        if(tempCont == 'Y'){
            return tempCont;
        }
        else if(tempCont == 'N'){
            return tempCont;
        }
        else{
            continueValue();
        }
        return tempCont;
    }

    public static double amount(){
        System.out.print("Amount?: ");
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        double amount = sc.nextDouble();
        if(amount >= 0){
            return amount;
        }
        else{
            System.out.println("Invalid input, try agien");
            amount();
        }
        return amount;
    }

    private static void withdrawAmount(CheckingAccount ch, SavingsAccount sv){

        char option = checkingOrSaving();
        double newAmount = amount();

        switch (option){
            case 'C':
                ch.withdraw(newAmount);
                break;
            case 'S':
                sv.withdraw(newAmount);
                break;
            default:
                break;
        }
    }

    private static void depositAmount(CheckingAccount ch, SavingsAccount sv){

        char option = checkingOrSaving();
        double newAmount = amount();

        switch (option){
            case 'C':
                ch.deposit(newAmount);
                break;
            case 'S':
                sv.deposit(newAmount);
                break;
            default:
                break;
        }
    }

    private static char checkingOrSaving(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Checking or savings? (c/s): ");
        char checkingOrSavings = sc.next().toUpperCase().charAt(0);

        switch (checkingOrSavings){
            case 'C':
                return checkingOrSavings;
            case 'S':
                return checkingOrSavings;
            default:
                System.out.println("invalid option, try agien.");
                checkingOrSaving();
        }
        return checkingOrSavings;
    }


    public static void main(String[] args){

        //scanner to read input from user
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        //welcome message
        System.out.println("Welcome to the Account application");

        //checking account amount
        System.out.print("Enter initial checking amount: ");
        double CheckingAmount = sc.nextDouble();

        //savings account amount
        System.out.print("Enter initial saving amount: ");
        double savingsAmount = sc.nextDouble();

        //checking fee amount
        System.out.print("Enter checking fee: ");
        double checkingFee = sc.nextDouble();

        //savings intrest rate
        System.out.print("Enter Saving intrest: ");
        double savingIntrestrate = sc.nextDouble();

        //create checkings account
        CheckingAccount checkingAccount = new CheckingAccount(CheckingAmount, checkingFee);

        // create savings account
        SavingsAccount savingsAccount = new SavingsAccount(savingsAmount, savingIntrestrate);

        //displays the accounts
        display(checkingAccount, savingsAccount);

        System.out.println("Enter the transactions for the month");
        transactions(checkingAccount, savingsAccount);

    }




}
