//depositcoins()
//display()
//buyticket()
//cancel()
//changeratestrat()
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.util.Scanner;

/**
 *
 * @author tue72283
 */
public class Menu {
    
    Scanner scan = new Scanner(System.in);
    PayStation ps = new PayStationImpl();
    
    public Menu() throws IllegalCoinException {
        int selection = -1;
        
        while(selection != 6) {
            displayMenu();
            selection = scan.nextInt();
            switch(selection) {
                case 1:
                    depositCoins();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    buyTicket();
                    break;
                case 4:
                    cancel();
                    break;
                case 5:
                    changeRateStrategy();
                    break;
                default:
                    System.out.println("Invalid input, enter a number from 1-6");
                    break;
            }
        }
    }
    
    public static void displayMenu() {
        // Display menu graphics
        System.out.println("============================");
        System.out.println("|   PayStation Menu    |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. DepositCoins       |");
        System.out.println("|        2. Display                 |");
        System.out.println("|        3. Buy ticket                |");
        System.out.println("|        4. Cancel                     |");
        System.out.println("|        5. Change Rate Strategy       |");  
        System.out.println("|        6. Quit                       |"); 
        System.out.println("============================");
    }
    
    public void depositCoins() throws IllegalCoinException {
        int x = -1;
        int coinValue;
        while (x != 0) {
            System.out.println("what is the coin value?");
            coinValue = scan.nextInt();
            ps.addPayment(coinValue);
            System.out.println("Finished? (y=0, n=1)");
            x = scan.nextInt();
        }
    }
    
    public void display(){
        System.out.println("You have purchased " + ps.readDisplay() + " minutes");
    }
    
    public void buyTicket(){
        display();
        ps.buy();
    }
    
    public void cancel() {
        ps.cancel();
    }
    
    public void changeRateStrategy() {
        int selection = -1;
        
        while(selection != 1 && selection != 2 && selection != 3) {
            displayRateStrategyMenu();
            selection = scan.nextInt();
            if(selection == 1)
                ps.setRateStrategy(new LinearRateStrategy());
            if(selection == 2)
                ps.setRateStrategy(new ProgressiveRateStrategy());
            if(selection == 3)
                ps.setRateStrategy(new AlternatingRateStrategy());
        }
    }
    
    public void displayRateStrategyMenu() {
        System.out.println("============================");
        System.out.println("|   Rate Strategy Menu    |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Linear Rate Strategy       |");
        System.out.println("|        2. Progressive Rate Strategy   |");
        System.out.println("|        3. Alternating Rate Strategy   |");
        System.out.println("============================");
    }
}
